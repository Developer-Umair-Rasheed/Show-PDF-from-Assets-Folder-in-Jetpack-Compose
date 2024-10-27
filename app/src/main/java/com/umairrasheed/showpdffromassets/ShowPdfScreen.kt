package com.umairrasheed.showpdffromassets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShowPdfScreen() {

    Scaffold(
        content = { paddingValues ->
            // Box to show the pdf from assets folder
            Box(modifier = Modifier.padding(paddingValues)) {
                PdfView(
                    "my_pdf.pdf"
                )
            }
        },
    )

}