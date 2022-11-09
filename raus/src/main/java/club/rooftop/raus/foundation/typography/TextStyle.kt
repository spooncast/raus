package club.rooftop.raus.foundation.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val TitleBold: TextStyle by lazy {
    TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp
    )
}

val TitleBoldCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 30.sp,
        textAlign = TextAlign.Center
    )
}

val SubheadRegular: TextStyle by lazy {
    TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
}

val SubheadRegularCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    )
}

val SubheadBold: TextStyle by lazy {
    TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
    )
}

val SubheadBoldCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    )
}

val Body1Regular: TextStyle by lazy {
    TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp
    )
}

val Body1RegularCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    )
}

val Body1RegularEnd: TextStyle by lazy {
    TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.End
    )
}

val Body1Bold: TextStyle by lazy {
    TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp
    )
}

val Body1BoldCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    )
}

val Body2Regular: TextStyle by lazy {
    TextStyle(
        fontSize = 12.sp,
        lineHeight = 42.sp
    )
}

val Body2RegularCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 12.sp,
        lineHeight = 42.sp,
        textAlign = TextAlign.Center
    )
}

val Body2Bold: TextStyle by lazy {
    TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp
    )
}

val Body2BoldCenter: TextStyle by lazy {
    TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center
    )
}

val Body3Regular: TextStyle by lazy {
    TextStyle(
        fontSize = 10.sp,
        lineHeight = 15.sp
    )
}

val Headline2Bold: TextStyle by lazy {
    TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 42.sp
    )
}

val Headline3Bold: TextStyle by lazy {
    TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp
    )
}
