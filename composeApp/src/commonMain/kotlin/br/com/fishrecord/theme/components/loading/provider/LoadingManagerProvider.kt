package br.com.fishrecord.theme.components.loading.provider

import androidx.compose.runtime.staticCompositionLocalOf
import br.com.fishrecord.theme.components.loading.LoadingDialogManager

/**
 * Provides a [Loading Dialog] that can be used by Easy application.
 */
val LocalLoadingDialog = staticCompositionLocalOf { LoadingDialogManager() }
