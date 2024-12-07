/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import java.util.LinkedList
import kotlin.math.max
import org.tensorflow.lite.task.vision.detector.Detection
import android.graphics.Bitmap

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var results: List<DetectionWithEmotion> = LinkedList<DetectionWithEmotion>()
    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()
    private var textPaint = Paint()
//    private var emotions: List<String> = emptyList()

    private var scaleFactor: Float = 1f

    private var bounds = Rect()

    init {
        initPaints()
    }

    fun clear() {
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate()
        initPaints()
    }

    private fun initPaints() {
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL
        textBackgroundPaint.textSize = 50f
        textBackgroundPaint.alpha = 180 

        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        boxPaint.color = ContextCompat.getColor(context!!, R.color.bounding_box_color)
        boxPaint.strokeWidth = 8F
        boxPaint.style = Paint.Style.STROKE
    }
   // private var resultsWithEmotions: List<Pair<Detection, String>> = emptyList()


    override fun draw(canvas: Canvas) {
        super.draw(canvas)

//        results.forEach { result ->
//        // Only process if it's a person
//        result.categories.forEach { category ->
//            if (category.label.lowercase() == "person") {
//                val boundingBox = result.boundingBox
//                val top = boundingBox.top
//                val bottom = boundingBox.bottom
//                val left = boundingBox.left
//                val right = boundingBox.right
//
//                // Draw bounding box
//                val drawableRect = RectF(left, top, right, bottom)
//                canvas.drawRect(drawableRect, boxPaint)
//
//                // Create text to display (category + confidence + emotion)
//                val categoryText = category.label + " " +
//                        String.format("%.2f", category.score)
//                val emotionText = "Emotion: ${result.emotion}"
//
//                // Calculate text bounds for background
//                val textBounds = Rect()
//                textPaint.getTextBounds(categoryText, 0, categoryText.length, textBounds)
//
//                // Draw text background and texts
//                val textBottom = top - 10
//                canvas.drawRect(
//                    left,
//                    textBottom - textBounds.height() - 40,
//                    left + textBounds.width() + 40,
//                    textBottom,
//                    textBackgroundPaint
//                )
//
//                canvas.drawText(
//                    categoryText,
//                    left + 20,
//                    textBottom - 20,
//                    textPaint
//                )
//
//                canvas.drawText(
//                    emotionText,
//                    left + 20,
//                    bottom + textBounds.height() + 20,
//                    textPaint
//                )
//            }
//        }
//    }
//
        results.forEach { result ->
            val boundingBox = result.boundingBox

            // Apply scaleFactor if needed
            val top = boundingBox.top * scaleFactor
            val bottom = boundingBox.bottom * scaleFactor
            val left = boundingBox.left * scaleFactor
            val right = boundingBox.right * scaleFactor

            // Check for person category
            result.categories.firstOrNull { it.label.lowercase() == "person" }?.let { category ->
                // Draw bounding box around detected objects
                val drawableRect = RectF(left, top, right, bottom)
                canvas.drawRect(drawableRect, boxPaint)

                // Create text to display
                val categoryText = category.label + " " + String.format("%.2f", category.score)
                val emotionText = "Emotion: ${result.emotion}"

                // Calculate text bounds
                val bounds = Rect()
                textPaint.getTextBounds(categoryText, 0, categoryText.length, bounds)

                // Calculate full text (category + emotion)
                val fullText = "$categoryText | $emotionText"
                val fullTextBounds = Rect()
                textPaint.getTextBounds(fullText, 0, fullText.length, fullTextBounds)

                // Draw text background
                val textPadding = Companion.BOUNDING_RECT_TEXT_PADDING
                canvas.drawRect(
                    left,
                    top - fullTextBounds.height() - (2 * textPadding),
                    left + fullTextBounds.width() + (2 * textPadding),
                    top,
                    textBackgroundPaint
                )

                // Draw combined text
                canvas.drawText(
                    fullText,
                    left + textPadding,
                    top - textPadding,
                    textPaint
                )
            }
        }
        
        }

    fun setResults(
        detectionResults: List<DetectionWithEmotion>?,
        imageHeight: Int,
        imageWidth: Int,
    ) {
        results = detectionResults ?: LinkedList()
        // PreviewView is in FILL_START mode. So we need to scale up the bounding box to match with
        // the size that the captured images will be displayed.
        scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
    }

    companion object {
        private const val BOUNDING_RECT_TEXT_PADDING = 8
    }
}
