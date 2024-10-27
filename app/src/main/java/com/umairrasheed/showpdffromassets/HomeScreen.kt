package com.umairrasheed.showpdffromassets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(onGoogleSignInClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Button to show the pdf from assets folder
        Button(
            onClick = {
                onGoogleSignInClick()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.Center)
                .padding(start = 15.dp, end = 15.dp),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
        ) {
            Row(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Cyan,
                                Color.Blue
                            ),
                        )
                    )
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Show Pdf From Assets",
                    fontSize = 20.sp
                )
            }
        }
    }
}