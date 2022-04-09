package com.github.freeezzzi.coursework3.actions

import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettingsApplierImpl
import com.github.freeezzzi.coursework3.checkers.properties.GradlePropertiesChecker
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project

abstract class PropertiesAction: AnAction() {
    private val checker = GradlePropertiesChecker()

    fun configureSettingsApplier(anActionEvent: AnActionEvent): GradlePropertiesSettingsApplierImpl {
        val psiFile = requireNotNull(anActionEvent.getData(CommonDataKeys.PSI_FILE))
        val wholeFile = psiFile.originalFile
        val settings = checker.getActualSettings(wholeFile)

        val editor: Editor = anActionEvent.getRequiredData(CommonDataKeys.EDITOR)
        val project: Project = anActionEvent.getRequiredData(CommonDataKeys.PROJECT)
        val document: Document = editor.document

        return GradlePropertiesSettingsApplierImpl(settings, document, project)
    }
}