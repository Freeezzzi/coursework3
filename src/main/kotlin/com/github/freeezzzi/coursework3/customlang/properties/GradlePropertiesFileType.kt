package com.github.freeezzzi.coursework3.customlang.properties

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class GradlePropertiesFileType: LanguageFileType(GradlePropertiesLang.INSTANCE) {
    override fun getName() = "gradle properties"

    override fun getDescription() = "gradle properties"

    override fun getDefaultExtension() = "properties"

    override fun getIcon() = null

    companion object {
        @JvmField
        val INSTANCE = GradlePropertiesFileType()
    }
}