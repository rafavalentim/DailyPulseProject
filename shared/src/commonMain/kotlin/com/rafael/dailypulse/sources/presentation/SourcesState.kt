package com.rafael.dailypulse.sources.presentation

import com.rafael.dailypulse.sources.application.Source

data class SourcesState (
    val sources: List<Source>,
    val loading: Boolean = false,
    val error: String? = null
)