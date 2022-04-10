package com.github.freeezzzi.coursework3.appliers.buildgradle

import com.github.freeezzzi.coursework3.appliers.SettingsApplier
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project

class BuildGradlePropertiesApplierImpl(
    private val settings: BuildGradleSettings,
    private val document: Document,
    private val project: Project,
) : SettingsApplier {
    override fun applySettings() {
        val fileStrings = document.text.split('\n')
        var isInsideAndroidTag = false
        var androidTagLineNum = -1
        var isInsideBuildTypes = false
        var buildTypeLineNum = -1
        var isInsideDebugTag = false
        var debugTagLineNum = -1
        var isInsideReleaseTag = false
        var degreeOfNesting = 0
        fileStrings.forEachIndexed { i, str ->
            // tags
            if (BuildGradleSettings.ANDROID_TAG_PATTERN.matcher(str).find() && degreeOfNesting == 0) {
                isInsideAndroidTag = true
                androidTagLineNum = i
            }
            if (BuildGradleSettings.BUILD_TYPE_PATTERN.matcher(str).find() && degreeOfNesting == 1) {
                isInsideBuildTypes = true
                buildTypeLineNum = i
            }
            if (BuildGradleSettings.DEBUG_PATTERN.matcher(str).find() && degreeOfNesting == 2) {
                isInsideDebugTag = true
                debugTagLineNum = i
            }
            if (BuildGradleSettings.RELEASE_PATTERN.matcher(str).find() && degreeOfNesting == 2) {
                isInsideReleaseTag = true
            }

            var newDegree = getDegreeOfNestingForThisStr(str)
            if (newDegree < 0) {
                while (newDegree != 0) {
                    when (degreeOfNesting) {
                        1 -> {
                            if (isInsideAndroidTag) {
                                isInsideAndroidTag = false
                            }
                        }
                        2 -> {
                            if (isInsideBuildTypes) {
                                isInsideBuildTypes = false
                            }
                        }
                        3 -> {
                            if (isInsideDebugTag) {
                                isInsideDebugTag = false
                            } else if (isInsideReleaseTag) {
                                isInsideReleaseTag = false
                            }
                        }
                    }

                    newDegree++
                    degreeOfNesting--
                }
            }
            degreeOfNesting += newDegree
        }

        // get resulted string
        var strLineNum = -1
        val strBuilder = StringBuilder()
        if (androidTagLineNum == -1) {
            strBuilder.append("android {\n")
        } else {
            strLineNum = androidTagLineNum
        }
        if (buildTypeLineNum == -1) {
            strBuilder.append("    buildTypes {\n")
        } else {
            strLineNum = buildTypeLineNum
        }
        if (debugTagLineNum == -1) {
            strBuilder.append("        debug {\n")
        } else {
            strLineNum = debugTagLineNum
        }

        if (settings.disablePngCrunching) {
            strBuilder.append("            ${BuildGradleSettings.PNG_CRUNCHING} ${BuildGradleSettings.PNG_CRUNCHING_VALUE}\n")
        }
        if (settings.disableMinifyRequired) {
            strBuilder.append("            ${BuildGradleSettings.MINIFY} ${BuildGradleSettings.MINIFY_VALUE}\n")
        }
        if (settings.disableShrinkRequired) {
            strBuilder.append("            ${BuildGradleSettings.SHRINK} ${BuildGradleSettings.SHRINK_VALUE}\n")
        }

        if (debugTagLineNum == -1) {
            strBuilder.append("        }\n")
        }
        if (buildTypeLineNum == -1) {
            strBuilder.append("    }\n")
        }
        if (androidTagLineNum == -1) {
            strBuilder.append("}\n")
        }

        WriteCommandAction.runWriteCommandAction(
            project
        ) {
            val finalString = if (strBuilder.toString().isEmpty()) {
                ""
            } else {
                "\n" + strBuilder.toString()
            }
            strLineNum = if (strLineNum == -1) {
                document.lineCount - 1
            } else {
                strLineNum
            }
            val offset = document.getLineEndOffset(strLineNum)
            document.insertString(offset, finalString)
        }
    }

    override fun getResultedString(): String = ""


    private fun getDegreeOfNestingForThisStr(string: String): Int {
        var count = 0
        string.forEach {
            if (it == BuildGradleSettings.OPENING_QUOTE) {
                count++
            } else if (it == BuildGradleSettings.CLOSING_QUOTE) {
                count--
            }
        }
        return count
    }
}