package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import sportikmultiplatform.composeapp.generated.resources.Res
import sportikmultiplatform.composeapp.generated.resources.montserrat
import sportikmultiplatform.composeapp.generated.resources.montserrat_alternates
import sportikmultiplatform.composeapp.generated.resources.montserrat_bold
import sportikmultiplatform.composeapp.generated.resources.montserrat_medium

object Fonts {

    object Montserrat {
        @Composable
        @OptIn(ExperimentalResourceApi::class)
        fun bold(): FontFamily = Font(Res.font.montserrat_bold, FontWeight.Bold).toFontFamily()

        @Composable
        @OptIn(ExperimentalResourceApi::class)
        fun semiBold(): FontFamily = Font(Res.font.montserrat, FontWeight.SemiBold).toFontFamily()

        @Composable
        @OptIn(ExperimentalResourceApi::class)
        fun medium(): FontFamily = Font(Res.font.montserrat_medium, FontWeight.Medium).toFontFamily()
    }

    object MontserratAlternates {
        @Composable
        @OptIn(ExperimentalResourceApi::class)
        fun semiBold(): FontFamily = Font(Res.font.montserrat_alternates, FontWeight.SemiBold).toFontFamily()
    }
}
