package com.github.freeezzzi.coursework3.javakotlinchecker

import com.intellij.codeInspection.*
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile

class ModuleInspectionTool: LocalInspectionTool() {
    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        val problemsHolder = ProblemsHolder(manager, file, isOnTheFly)
        val wholeFile = file.originalFile
        if (checkIsSourceCodeFile(wholeFile)) {
            var containJavaFiles = false
            var containKotlinFiles = false
            wholeFile.containingDirectory.accept(object : PsiElementVisitor() {
                override fun visitDirectory(dir: PsiDirectory) {
                    super.visitDirectory(dir)
                    dir.files.forEach {
                        visitFile(it)
                    }
                    dir.subdirectories.forEach {
                        visitDirectory(it)
                    }
                }
                override fun visitFile(file: PsiFile) {
                    if (file.name.endsWith(".kt")) {
                        containKotlinFiles = true
                    } else if (file.name.endsWith(".java")) {
                        containJavaFiles = true
                    }
                }
            })
            if (containKotlinFiles && containJavaFiles) {
                problemsHolder.registerProblem(file, "This module mixing Java and Kotlin code. Try to avoid doing this.")
            }
        }
        return problemsHolder.resultsArray
    }

    private fun checkIsSourceCodeFile(file: PsiFile): Boolean {
        return file.name.endsWith(".java") || file.name.endsWith(".kt")
    }
}