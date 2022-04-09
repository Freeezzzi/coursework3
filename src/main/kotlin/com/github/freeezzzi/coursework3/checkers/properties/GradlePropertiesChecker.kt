package com.github.freeezzzi.coursework3.checkers.properties

import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettings
import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettingsApplierImpl
import com.github.freeezzzi.coursework3.checkers.SettingsChecker
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile

class GradlePropertiesChecker: SettingsChecker<GradlePropertiesSettings> {
    override fun getActualSettings(targetFile: PsiFile): GradlePropertiesSettings {
        val settings = GradlePropertiesSettings()
        targetFile.accept(object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                val strings = element.text.split('\n')
                strings.forEach { str ->
                    checkString(settings, str)
                }
            }
        })
        return settings
    }

    private fun checkString(settings: GradlePropertiesSettings, str: String) {
        if (settings.buildFeatureAidlPattern.matcher(str).find()) {
            settings.buildFeatureAidl = false
        } else if (settings.buildFeaturesBuildConfigPattern.matcher(str).find()) {
            settings.buildFeaturesBuildConfig = false
        } else if (settings.buildFeaturesComposePattern.matcher(str).find()) {
            settings.buildFeaturesCompose = false
        } else if (settings.buildFeaturesDataBindingPattern.matcher(str).find()) {
            settings.buildFeaturesDataBinding = false
        } else if (settings.buildFeaturesRenderScriptPattern.matcher(str).find()) {
            settings.buildFeaturesRenderScript = false
        } else if (settings.buildFeaturesResValuesPattern.matcher(str).find()) {
            settings.buildFeaturesResValues = false
        } else if (settings.buildFeaturesShadersPattern.matcher(str).find()) {
            settings.buildFeaturesShaders = false
        } else if (settings.buildFeaturesViewBindingPattern.matcher(str).find()) {
            settings.buildFeaturesViewBinding = false
        } else if (settings.jetifierPattern.matcher(str).find()) {
            settings.jetifierRequired = false
        } else if (settings.gradleDaemonPattern.matcher(str).find()) {
            settings.gradleDaemonRequired = false
        } else if (settings.nonTransitiveClassesPattern.matcher(str).find()) {
            settings.nonTransitiveClassesRequired = false
        } else if (settings.parallelExecutionPattern.matcher(str).find()) {
            settings.parallelExecutionRequired = false
        } else if (settings.configurationCachePattern.matcher(str).find()) {
            settings.configurationCache = false
        } else if (settings.configurationCacheProblemsPattern.matcher(str).find()) {
            settings.configurationCacheProblemsWarn = false
        } else if (str == GradlePropertiesSettingsApplierImpl.TEXT) {
            settings.suggestRequired = false
        }
    }
}