package com.github.freeezzzi.coursework3.actions.intentionactions

import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class ProblemFixIntentionAction(
    private val data: FixData,
): BaseIntentionAction() {
    override fun getFamilyName(): String {
        return "Build time fixes"
    }

    override fun getText() = "Optimize"

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        val document: Document = editor?.document ?: return

        WriteCommandAction.runWriteCommandAction(
            project
        ) {
            document.replaceString(data.startOffset, data.endOffset, data.stringToReplace)
        }

    }
}