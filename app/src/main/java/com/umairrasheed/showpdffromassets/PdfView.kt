package com.umairrasheed.showpdffromassets

// Importing necessary libraries for Android context, Compose UI, and coroutines
import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PdfView(
    fileName: String // The name of the PDF file located in the assets folder
) {
    // Get the current context (used to access the assets and for PDFView creation)
    val context = LocalContext.current

    // Box to hold the PDF view
    Box(modifier = Modifier.fillMaxSize()) {
        // Call rememberPdfView to get the initialized PDFView
        val pdfView = rememberPdfView(context, fileName)

        // Use AndroidView to display the standard Android view (PDFView) inside Jetpack Compose
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp), // Padding at the bottom for UI layout
            factory = { pdfView } // Pass the initialized PDFView
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun rememberPdfView(
    context: Context, // The Android context to access resources
    fileName: String // The name of the file in the assets folder
): PDFView {

    // Use the remember function to keep the same PDFView instance across recompositions
    val pdfView = remember(context, fileName) {
        PDFView(context, null).apply {
            // Launch a coroutine on the main thread to load the PDF from assets
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    // Access the AssetManager to retrieve the file from the assets folder
                    val assetManager: AssetManager = context.assets
                    val inputStream = assetManager.open(fileName) // Open the PDF file as a stream

                    // Load the PDF into the PDFView from the input stream
                    this@apply.fromStream(inputStream)
                        .scrollHandle(
                            com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle(context)
                        ) // Enable scrolling through the PDF
                        .defaultPage(0) // Set the default page to open (first page)
                        .load() // Load the PDF into the view
                } catch (e: Exception) {
                    e.printStackTrace() // Print the error in case something goes wrong
                }
            }
        }
    }
    return pdfView // Return the initialized PDFView instance
}