package com.pr7.jetpack_compose.JC_17_Animated_Shimmer_Effect

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_7_Expandable_Cardview.ui.theme.Shapes


@Composable
fun AnimatedShimmer() {
    val shimmercolors= listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )
    val transition= rememberInfiniteTransition()
    val translateAnim=transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
    )

    val brush=Brush.linearGradient(
        colors = shimmercolors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
    ShimmerGridItem(brush = brush)
}

@Composable
fun ShimmerGridItem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
    ) {
        Spacer(modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(brush))
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.height(5.dp))
            Spacer(modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Spacer(modifier = Modifier
                .height(20.dp)
                .clip(Shapes.medium)
                .fillMaxWidth(fraction = 0.9f)
                .background(brush)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShimmerGradientPreview() {
    ShimmerGridItem(brush = Brush.linearGradient(listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )))
}

@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerGradientDarkPreview() {
    ShimmerGridItem(brush = Brush.linearGradient(listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )))
}