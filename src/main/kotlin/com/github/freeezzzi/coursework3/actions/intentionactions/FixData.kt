package com.github.freeezzzi.coursework3.actions.intentionactions

data class FixData(
    val startOffset: Int,
    val endOffset: Int,
    val stringToReplace: String,
)