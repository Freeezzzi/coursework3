package com.github.freeezzzi.coursework3.appliers.buildgradle

import java.util.regex.Pattern

class BuildGradleSettings {
    // true - нужно добавить, false - не нужно
    // эти значения проверяем только в дебаг конфиге
    var disablePngCrunching: Boolean = true
    var disableMinifyRequired = true
    var disableShrinkRequired = true

    companion object {
        const val OPENING_QUOTE = '{'
        const val CLOSING_QUOTE = '}'
        val ANDROID_TAG_PATTERN = Pattern.compile("(\\s)*(android)")
        val BUILD_TYPE_PATTERN = Pattern.compile("(\\s)*buildTypes")
        val RELEASE_PATTERN = Pattern.compile("(\\s)*release")
        val DEBUG_PATTERN = Pattern.compile("(\\s)*debug")
        val BUILDCONFIG_PATTERN = Pattern.compile("(\\s)*buildConfig")


        private const val PLACEHOLDER = "PLACEHOLDER"
        const val BUILD_GRADLE_PATTERN = "(\\s)*${PLACEHOLDER}(\\s)+(true)?(false)?"

        const val PNG_CRUNCHING = "crunchPngs"
        const val PNG_CRUNCHING_VALUE = "false"
        val PNG_CRUNCHING_PATTERN = Pattern.compile(BUILD_GRADLE_PATTERN.replace(PLACEHOLDER, PNG_CRUNCHING))

        const val MINIFY = "minifyEnabled"
        const val MINIFY_VALUE = "false"
        val MINIFY_PATTERN = Pattern.compile(BUILD_GRADLE_PATTERN.replace(PLACEHOLDER, MINIFY))

        const val SHRINK = "shrinkResources"
        const val SHRINK_VALUE = "false"
        val SHRINK_PATTERN = Pattern.compile(BUILD_GRADLE_PATTERN.replace(PLACEHOLDER, SHRINK))
    }
}