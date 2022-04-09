package com.github.freeezzzi.coursework3.actions.intentionactions


import com.github.freeezzzi.coursework3.StringUtils
import com.github.freeezzzi.coursework3.appliers.properties.GradlePropertiesSettings
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.startOffset


class GradlePropertiesAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val strings = element.text.split('\n')
        var symCount = 0
        strings.forEachIndexed { i, str ->
            var range = TextRange(0, 0)
            val trimmed = str.trim()
            val offset = element.startOffset + symCount + i * 1
            val textToReplace = if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURE_AIDL,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURE_AIDL,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_BUILDCONFIG,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_BUILDCONFIG,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_COMPOSE,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_COMPOSE,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_DATABINDING,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_DATABINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_RENDERSCRIPT,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_RENDERSCRIPT,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_RESVALUES,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_RESVALUES,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_SHADERS,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_SHADERS,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_VIEWBINDING,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.BUILD_FEATURES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.BUILD_FEATURES_VIEWBINDING,
                    GradlePropertiesSettings.BUILD_FEATURES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.JETIFIER,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.JETIFIER_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.JETIFIER,
                    GradlePropertiesSettings.JETIFIER_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.GRADLE_DAEMON,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.GRADLE_DAEMON_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.GRADLE_DAEMON,
                    GradlePropertiesSettings.GRADLE_DAEMON_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.NON_TRANSITIVE_CLASSES_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES,
                    GradlePropertiesSettings.NON_TRANSITIVE_CLASSES_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.PARALLEL_EXECUTION,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.PARALLEL_EXECUTION_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.PARALLEL_EXECUTION,
                    GradlePropertiesSettings.PARALLEL_EXECUTION_VALUE
                )
            } else if (trimmed == GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.CONFIGURATION_CACHE,
                    StringUtils.getOppositeBooleanValue(GradlePropertiesSettings.CONFIGURATION_CACHE_VALUE)
                )
            ) {
                range = TextRange.from(offset, str.length)
                GradlePropertiesSettings.getPropertyWithValueWithoutN(
                    GradlePropertiesSettings.CONFIGURATION_CACHE,
                    GradlePropertiesSettings.CONFIGURATION_CACHE_VALUE
                )
            } else {
                ""
            }
            if (range.startOffset != 0 && range.endOffset != 0) {
                holder.newAnnotation(HighlightSeverity.WARNING, "This property may slow down project build time. Consider about removing it.")
                    .range(range)
                    .highlightType(ProblemHighlightType.WARNING)
                    .withFix(ProblemFixIntentionAction(FixData(range.startOffset, range.endOffset, textToReplace)))
                    .create()
            }
            symCount += str.length
        }
    }
}