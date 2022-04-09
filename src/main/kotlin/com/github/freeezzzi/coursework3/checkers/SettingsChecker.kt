package com.github.freeezzzi.coursework3.checkers

import com.intellij.psi.PsiFile

interface SettingsChecker<T> {
    fun getActualSettings(targetFile: PsiFile): T
}