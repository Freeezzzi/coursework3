package com.github.freeezzzi.coursework3.actions

import com.github.freeezzzi.coursework3.StringUtils
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.psi.PsiFile

class DisableGradlePluginFeaturesAction : PropertiesAction() {
    override fun actionPerformed(anActionEvent: AnActionEvent) {
        val settingsApplier = configureSettingsApplier(anActionEvent)
        settingsApplier.optimizeFeatureAidl()
        settingsApplier.optimizeFeatureBuildConfig()
        settingsApplier.optimizeFeatureCompose()
        settingsApplier.optimizeFeatureDataBinding()
        settingsApplier.optimizeFeatureRenderScript()
        settingsApplier.optimizeFeatureResValues()
        settingsApplier.optimizeFeatureShaders()
        settingsApplier.optimizeFeatureViewBinding()
    }

    override fun update(e: AnActionEvent) {
        val psiFile = e.getData(CommonDataKeys.PSI_FILE) ?: return
        e.presentation.isEnabled = checkIsNeededFile(psiFile)
    }

    private fun checkIsNeededFile(psiFile: PsiFile): Boolean {
        val fileName = psiFile.originalFile.name
        return StringUtils.checkIsGradlePropertiesFile(fileName) && psiFile.isWritable
    }
}