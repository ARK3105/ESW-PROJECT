package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class EmotionDetector(context: Context) {
    private val interpreter: Interpreter
    private val emotions = arrayOf("Angry", "Disgusted", "Fearful", "Happy", "Neutral", "Sad", "Surprised")
    // Add a reusable bitmap to avoid constant allocation
    private val inputBitmap = Bitmap.createBitmap(48, 48, Bitmap.Config.ARGB_8888)
    private val inputArray = Array(1) { Array(48) { Array(48) { FloatArray(1) } } }
    private val outputArray = Array(1) { FloatArray(emotions.size) }

    init {
        // Use NNAPI delegate for better performance on modern Android devices
        val options = Interpreter.Options().apply {
            setUseNNAPI(true)
            setNumThreads(2)  // Adjust based on your needs
        }
        interpreter = Interpreter(loadModelFile(context), options)
    }

    fun detectEmotion(bitmap: Bitmap): String {
        // Use Canvas for faster bitmap scaling
        val canvas = android.graphics.Canvas(inputBitmap)
        canvas.scale(48f / bitmap.width, 48f / bitmap.height)
        canvas.drawBitmap(bitmap, 0f, 0f, null)
        
        // Process the image
        preprocessImage(inputBitmap, inputArray)
        
        // Run inference
        interpreter.run(inputArray, outputArray)
        
        return emotions[outputArray[0].indices.maxByOrNull { outputArray[0][it] } ?: 0]
    }

    private fun preprocessImage(bitmap: Bitmap, input: Array<Array<Array<FloatArray>>>) {
        val pixels = IntArray(48 * 48)
        bitmap.getPixels(pixels, 0, 48, 0, 0, 48, 48)
        
        for (i in pixels.indices) {
            val pixel = pixels[i]
            val gray = (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / (3f * 255f)
            input[0][i / 48][i % 48][0] = gray
        }
    }

    private fun loadModelFile(context: Context): MappedByteBuffer {
        val modelPath = "emotion_model.tflite"
        return context.assets.openFd(modelPath).use { fileDescriptor ->
            FileInputStream(fileDescriptor.fileDescriptor).use { inputStream ->
                inputStream.channel.map(
                    FileChannel.MapMode.READ_ONLY,
                    fileDescriptor.startOffset,
                    fileDescriptor.declaredLength
                )
            }
        }
    }
}