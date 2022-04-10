package com.github.freeezzzi.coursework3.javakotlinchecker

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile

class ModuleInspectionTool: LocalInspectionTool() {
    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor>? {
        val problemsHolder = ProblemsHolder(manager, file, isOnTheFly)
        println("1")
        val wholeFile = file.originalFile
        if (checkIsBuildGradleFile(wholeFile)) {
            var containJavaFiles = false
            var containKotlinFiles = false
            file.containingDirectory.accept(object : PsiElementVisitor() {
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

    private fun checkIsBuildGradleFile(file: PsiFile): Boolean {
        return file.name == "build.gradle" || file.name == "build.gradle.kts"
    }
}