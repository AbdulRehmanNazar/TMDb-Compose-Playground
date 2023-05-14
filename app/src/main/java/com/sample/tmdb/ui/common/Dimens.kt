package com.sample.tmdb.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sample.tmdb.R

object Dimens {

    val PaddingMicro = 2.dp

    val PaddingSmall: Dp
        @Composable get() = dimensionResource(R.dimen.padding_small)

    val PaddingMedium = 12.dp

    val GridSpacing: Dp
        @Composable get() = dimensionResource(R.dimen.padding_medium)
}