package com.github.freeezzzi.coursework3.appliers.properties

import com.github.freeezzzi.coursework3.appliers.SettingsApplier
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project

class GradlePropertiesSettingsApplierImpl(
    private val settings: GradlePropertiesSettings,
    private val document: Document,
    private val project: Project,
) : SettingsApplier {

    override fun applySettings() {
        val textToAppend = getResultedString()
        insertString(textToAppend)
    }

    override fun getResultedString(): String {
        val strBuilder = StringBuilder()
        if (settings.buildFeatureAidl) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURE_AIDL,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesBuildConfig) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_BUILDCONFIG,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesCompose) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_COMPOSE,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesDataBinding) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_DATABINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesRenderScript) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_RENDERSCRIPT,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesResValues) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_RESVALUES,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesShaders) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_SHADERS,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.buildFeaturesViewBinding) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_VIEWBINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        if (settings.jetifierRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.JETIFIER,
                    GradlePropertiesSettings.JETIFIER_VALUE
                )
            )
        }
        if (settings.gradleDaemonRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.GRADLE_DAEMON,
                    GradlePropertiesSettings.GRADLE_DAEMON_VALUE
                )
            )
        }
        if (settings.nonTransitiveClassesRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES,
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES_VALUE
                )
            )
        }
        if (settings.parallelExecutionRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.PARALLEL_EXECUTION,
                    GradlePropertiesSettings.PARALLEL_EXECUTION_VALUE
                )
            )
        }
        if (settings.configurationCache) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.CONFIGURATION_CACHE,
                    GradlePropertiesSettings.CONFIGURATION_CACHE_VALUE
                )
            )
        }
        if (settings.configurationCacheProblemsWarn) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.CONFIGURATION_CACHE_PROBLEMS_WARN,
                    GradlePropertiesSettings.CONFIGURATION_CACHE_PROBLEMS_WARN_VALUE
                )
            )
        }

        var result = strBuilder.toString()
        if (result.isNotEmpty() && settings.suggestRequired) {
            result = "\n${TEXT}\n" + result
        }
        return result
    }

    fun optimizeFeatureAidl() {
        val strBuilder = StringBuilder()
        if (settings.buildFeatureAidl) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURE_AIDL,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureBuildConfig() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesBuildConfig) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_BUILDCONFIG,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureCompose() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesCompose) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_COMPOSE,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureDataBinding() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesDataBinding) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_DATABINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureRenderScript() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesRenderScript) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_RENDERSCRIPT,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureResValues() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesResValues) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_RESVALUES,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureShaders() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesShaders) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_SHADERS,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureViewBinding() {
        val strBuilder = StringBuilder()
        if (settings.buildFeaturesViewBinding) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.BUILD_FEATURES_VIEWBINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureJetifier() {
        val strBuilder = StringBuilder()
        if (settings.jetifierRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.JETIFIER,
                    GradlePropertiesSettings.JETIFIER_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureGradleDaemon() {
        val strBuilder = StringBuilder()
        if (settings.gradleDaemonRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.GRADLE_DAEMON,
                    GradlePropertiesSettings.GRADLE_DAEMON_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureNonTransitiveClasses() {
        val strBuilder = StringBuilder()
        if (settings.nonTransitiveClassesRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES,
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureParallelExecution() {
        val strBuilder = StringBuilder()
        if (settings.parallelExecutionRequired) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.PARALLEL_EXECUTION,
                    GradlePropertiesSettings.PARALLEL_EXECUTION_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureConfigurationCache() {
        val strBuilder = StringBuilder()
        if (settings.configurationCache) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.CONFIGURATION_CACHE,
                    GradlePropertiesSettings.CONFIGURATION_CACHE_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    fun optimizeFeatureConfigurationCacheProblems() {
        val strBuilder = StringBuilder()
        if (settings.configurationCacheProblemsWarn) {
            strBuilder.append(
                GradlePropertiesSettings.getPropertyWithValue(
                    GradlePropertiesSettings.CONFIGURATION_CACHE_PROBLEMS_WARN,
                    GradlePropertiesSettings.CONFIGURATION_CACHE_PROBLEMS_WARN_VALUE
                )
            )
        }
        var result = strBuilder.toString()
        if (result.isNotEmpty()) {
            result = "\n${result}\n"
        }
        insertString(result)
    }

    private fun insertString(str: String) {
        WriteCommandAction.runWriteCommandAction(
            project
        ) {
            val offset = document.getLineEndOffset(document.lineCount - 1)
            document.insertString(offset, str)
        }
    }

    companion object {
        const val TEXT = "# This was added for build time optimization"
    }
}
