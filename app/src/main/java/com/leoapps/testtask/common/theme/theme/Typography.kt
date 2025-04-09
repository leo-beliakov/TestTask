package com.leoapps.testtask.common.theme.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leoapps.testtask.R

val PoppinsFamily
    @Composable get() = FontFamily(
        Font(
            resId = R.font.poppins_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.poppins_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.poppins_semi_bold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resId = R.font.poppins_bold,
            weight = FontWeight.Bold
        ),
    )

val Typography
    @Composable get() = Typography(
        headlineSmall = TextStyle(
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsFamily,
            color = primaryText,
            fontSize = 24.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp,
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsFamily,
            color = primaryText,
            fontSize = 18.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp,
        ),
        titleMedium = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontFamily = PoppinsFamily,
            color = primaryText,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.sp,
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsFamily,
            color = primaryText,
            letterSpacing = 0.sp,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsFamily,
            color = secondaryText,
            letterSpacing = 0.sp,
            fontSize = 12.sp,
            lineHeight = 22.sp,
        )
    )
