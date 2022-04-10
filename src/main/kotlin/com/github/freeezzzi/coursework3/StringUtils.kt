package com.github.freeezzzi.coursework3

object StringUtils {
    private const val gradlePropertiesFileNamePattern = "gradle.properties"
    fun checkIsGradlePropertiesFile(fileName: String): Boolean {
        return fileName.trim() == gradlePropertiesFileNamePattern
    }

    fun getOppositeBooleanValue(value: String): String {
        return if (value == "true") {
            "false"
        } else if (value == "false") {
            "true"
        } else {
            ""
        }
    }
}