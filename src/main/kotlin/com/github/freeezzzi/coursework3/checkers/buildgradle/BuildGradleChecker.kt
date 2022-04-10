package com.github.freeezzzi.coursework3.checkers.buildgradle

import com.github.freeezzzi.coursework3.appliers.buildgradle.BuildGradleSettings
import com.github.freeezzzi.coursework3.checkers.SettingsChecker
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile

class BuildGradleChecker: SettingsChecker<BuildGradleSettings> {
    override fun getActualSettings(targetFile: PsiFile): BuildGradleSettings {
        val settings = BuildGradleSettings()
        targetFile.accept(object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                var isInsideAndroidTag = false
                var isInsideBuildTypes = false
                var isInsideDebugTag = false
                var isInsideReleaseTag = false
                var degreeOfNesting = 0
                val strings = element.text.split('\n')
                strings.forEach { str ->
                    // tags
                    if (BuildGradleSettings.ANDROID_TAG_PATTERN.matcher(str).find() && degreeOfNesting == 0) {
                        isInsideAndroidTag = true
                    }
                    if (BuildGradleSettings.BUILD_TYPE_PATTERN.matcher(str).find() && degreeOfNesting == 1) {
                        isInsideBuildTypes = true
                    }
                    if (BuildGradleSettings.DEBUG_PATTERN.matcher(str).find() && degreeOfNesting == 2) {
                        isInsideDebugTag = true
                    }
                    if (BuildGradleSettings.RELEASE_PATTERN.matcher(str).find() && degreeOfNesting == 2) {
                        isInsideReleaseTag = true
                    }
                    // properties
                    if (BuildGradleSettings.PNG_CRUNCHING_PATTERN.matcher(str).find()
                        && isInsideAndroidTag && isInsideBuildTypes && isInsideDebugTag) {
                        settings.disablePngCrunching = false
                    }
                    if (BuildGradleSettings.MINIFY_PATTERN.matcher(str).find()
                        && isInsideAndroidTag && isInsideBuildTypes && isInsideDebugTag) {
                        settings.disableMinifyRequired = false
                    }
                    if (BuildGradleSettings.SHRINK_PATTERN.matcher(str).find()
                        && isInsideAndroidTag && isInsideBuildTypes && isInsideDebugTag) {
                        settings.disableShrinkRequired = false
                    }

                    var newDegree = getDegreeOfNestingForThisStr(str)
                    if (newDegree < 0) {
                        while (newDegree != 0) {
                            when (degreeOfNesting) {
                                1 -> {
                                    if (isInsideAndroidTag)  {
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

            }
        })
        return settings
    }

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