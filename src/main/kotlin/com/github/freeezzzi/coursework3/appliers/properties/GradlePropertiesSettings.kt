package com.github.freeezzzi.coursework3.appliers.properties

import java.util.regex.Pattern

class GradlePropertiesSettings {
    val buildFeatureAidlPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURE_AIDL));
    val buildFeaturesBuildConfigPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_BUILDCONFIG));
    val buildFeaturesComposePattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_COMPOSE));
    val buildFeaturesDataBindingPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_DATABINDING));
    val buildFeaturesRenderScriptPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_RENDERSCRIPT));
    val buildFeaturesResValuesPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_RESVALUES));
    val buildFeaturesShadersPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_SHADERS));
    val buildFeaturesViewBindingPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, BUILD_FEATURES_VIEWBINDING));
    val jetifierPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, JETIFIER));
    val gradleDaemonPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, GRADLE_DAEMON));
    val nonTransitiveClassesPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, NON_TRANSITIVE_CLASSES));
    val parallelExecutionPattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, PARALLEL_EXECUTION));
    val configurationCachePattern = Pattern.compile(PATTERN_FOR_REGEX.replace(PLACEHOLDER, CONFIGURATION_CACHE));
    val configurationCacheProblemsPattern = Pattern.compile("(\\s)*${CONFIGURATION_CACHE_PROBLEMS_WARN}(\\s)*=(\\s)*[\\w]+");


    var buildFeatureAidl = true
    var buildFeaturesBuildConfig = true
    var buildFeaturesCompose = true
    var buildFeaturesDataBinding = true
    var buildFeaturesRenderScript = true
    var buildFeaturesResValues = true
    var buildFeaturesShaders = true
    var buildFeaturesViewBinding = true

    var jetifierRequired = true
    var gradleDaemonRequired = true
    var nonTransitiveClassesRequired = true
    var parallelExecutionRequired: Boolean = true
    var configurationCache: Boolean = true
    var configurationCacheProblemsWarn: Boolean = true

    var suggestRequired = true

    companion object {
        private const val PLACEHOLDER = "NAME"
        private const val PATTERN_FOR_REGEX = "(\\s)*${PLACEHOLDER}(\\s)*=(\\s)*(true)?(false)?"
        const val BUILD_FEATURES_VALUE = "false"
        const val BUILD_FEATURE_AIDL = "android.defaults.buildfeatures.aidl"
        const val BUILD_FEATURES_BUILDCONFIG = "android.defaults.buildfeatures.buildconfig"
        const val BUILD_FEATURES_COMPOSE = "android.defaults.buildfeatures.compose"
        const val BUILD_FEATURES_DATABINDING = "android.defaults.buildfeatures.dataBinding"
        const val BUILD_FEATURES_RENDERSCRIPT = "android.defaults.buildfeatures.prefab"
        const val BUILD_FEATURES_RESVALUES = "android.defaults.buildfeatures.resvalues"
        const val BUILD_FEATURES_SHADERS = "android.defaults.buildfeatures.shaders"
        const val BUILD_FEATURES_VIEWBINDING = "android.defaults.buildfeatures.viewBinding"

        const val JETIFIER = "android.enableJetifier"
        const val JETIFIER_VALUE = "false"

        const val GRADLE_DAEMON = "org.gradle.daemon"
        const val GRADLE_DAEMON_VALUE = "false"

        const val NON_TRANSITIVE_CLASSES = "android.nonTransitiveRClass"
        const val NON_TRANSITIVE_CLASSES_VALUE = "true"

        const val PARALLEL_EXECUTION = "org.gradle.parallel"
        const val PARALLEL_EXECUTION_VALUE = "true"

        const val CONFIGURATION_CACHE = "org.gradle.unsafe.configuration-cache"
        const val CONFIGURATION_CACHE_VALUE = "true"

        const val CONFIGURATION_CACHE_PROBLEMS_WARN = "org.gradle.unsafe.configuration-cache-problems"
        const val CONFIGURATION_CACHE_PROBLEMS_WARN_VALUE = "warn"

        fun getPropertyWithValueWithoutN(property: String, value: String): String {
            return "${property}=${value}"
        }

        fun getPropertyWithValue(property: String, value: String): String {
            return "${property}=${value}\n"
        }

        @JvmStatic
        fun falseInstance(): GradlePropertiesSettings {
            return GradlePropertiesSettings().apply {
                buildFeatureAidl = false
                buildFeaturesBuildConfig = false
                buildFeaturesCompose = false
                buildFeaturesDataBinding = false
                buildFeaturesRenderScript = false
                buildFeaturesResValues = false
                buildFeaturesShaders = false
                buildFeaturesViewBinding = false

                jetifierRequired = false
                gradleDaemonRequired = false
                nonTransitiveClassesRequired = false
                parallelExecutionRequired = false
                configurationCache = false
                configurationCacheProblemsWarn = false
            }
        }
    }
}