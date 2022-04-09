package com.github.freeezzzi.coursework3.actions

import com.github.freeezzzi.coursework3.StringUtils
import com.github.freeezzzi.coursework3.appliers.build.BuildGradlePropertiesApplierImpl
import com.github.freeezzzi.coursework3.checkers.build.BuildGradleChecker
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class DisablePngCrunching: AnAction() {
    private val buildChecker = BuildGradleChecker()

    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE) ?: return
        val editor: Editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR)
        val project: Project = anActionEvent.getRequiredData(CommonDataKeys.PROJECT)
        val document: Document = editor.document

        if (psiFile.name == "build.gradle" || psiFile.name == "build.gradle.kts") {
            // For Build.gradle file
            val settings = buildChecker.getActualSettings(psiFile)
            settings.disableMinifyRequired = false
            settings.disableShrinkRequired = false
            val settingsApplier = BuildGradlePropertiesApplierImpl(settings, document, project)
            settingsApplier.applySettings()
        }
    }

    override fun update(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        e.presentation.isEnabled = (psiFile.name == "build.gradle" || psiFile.name == "build.gradle.kts" )
    }

    private fun checkIsNeededFile(psiFile: PsiFile): Boolean {
        val fileName = psiFile.originalFile.name
        return StringUtils.checkIsGradlePropertiesFile(fileName) && psiFile.isWritable
    }
}