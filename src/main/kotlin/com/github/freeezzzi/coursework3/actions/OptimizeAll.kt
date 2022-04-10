package com.github.freeezzzi.coursework3.actions

import com.github.freeezzzi.coursework3.StringUtils
import com.github.freeezzzi.coursework3.appliers.buildgradle.BuildGradlePropertiesApplierImpl
import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettingsApplierImpl
import com.github.freeezzzi.coursework3.checkers.buildgradle.BuildGradleChecker
import com.github.freeezzzi.coursework3.checkers.properties.GradlePropertiesChecker
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile


class OptimizeAll : AnAction() {
    private val checker = GradlePropertiesChecker()
    private val buildChecker = BuildGradleChecker()

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE) ?: return

        val editor: Editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR)
        val project: Project = anActionEvent.getRequiredData(CommonDataKeys.PROJECT)
        val document: Document = editor.document

        if (psiFile.name == "build.gradle" || psiFile.name == "build.gradle.kts") {
            // For Build.gradle file
            val settings = buildChecker.getActualSettings(psiFile)
            val settingsApplier = BuildGradlePropertiesApplierImpl(settings, document, project)
            settingsApplier.applySettings()
        }
        if (psiFile.name == "gradle.properties") {
            // For gradle.properties
            val settingsProperties = checker.getActualSettings(psiFile)

            val settingsApplierProperties = GradlePropertiesSettingsApplierImpl(settingsProperties, document, project)
            settingsApplierProperties.applySettings()
        }
    }

    override fun update(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        /*val buildFile = psiFile.containingDirectory.findFile("build.gradle")
        val buildFileKts = psiFile.containingDirectory.findFile("build.gradle.kts")
        val gradleFile = psiFile.containingDirectory.findFile("gradle.properties")
        e.presentation.isEnabled = (buildFile != null || buildFileKts != null) && gradleFile != null*/
        e.presentation.isEnabled = (psiFile.name == "build.gradle" || psiFile.name == "build.gradle.kts" ||psiFile.name == "gradle.properties")
    }

    private fun checkIsNeededFile(psiFile: PsiFile): Boolean {
        val fileName = psiFile.originalFile.name
        return StringUtils.checkIsGradlePropertiesFile(fileName) && psiFile.isWritable
    }
}