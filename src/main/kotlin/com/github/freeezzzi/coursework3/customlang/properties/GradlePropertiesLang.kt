package com.github.freeezzzi.coursework3.customlang.properties

import com.intellij.lang.Language

class GradlePropertiesLang: Language("properties") {
    companion object {
        @JvmField
        val INSTANCE = GradlePropertiesLang()
    }
}