package com.github.freeezzzi.coursework3.actions

import com.github.freeezzzi.coursework3.StringUtils
import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettingsApplierImpl
import com.github.freeezzzi.coursework3.checkers.properties.GradlePropertiesChecker
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile


class EnableParallelBuildAction: PropertiesAction() {
    override fun actionPerformed(anActionEvent: AnActionEvent) {
        configureSettingsApplier(anActionEvent).optimizeFeatureParallelExecution()
    }

    override fun update(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        e.presentation.isEnabled = checkIsNeededFile(psiFile)
    }

    private fun checkIsNeededFile(psiFile: PsiFile): Boolean {
        val fileName = psiFile.originalFile.name
        return StringUtils.checkIsGradlePropertiesFile(fileName) && psiFile.isWritable
    }
}