package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.*

class MetricLogger(private val context: Context) {
    private val logFileName = "metrics_log.txt"

    fun logMetrics(
        batteryLevel: Int,
        cpuUsage: Float,
        batteryConsumption: Float,
        selectedModel: String
    ) {
        val timestamp = getCurrentTimestamp()
        val logEntry = "$timestamp, $selectedModel, $batteryLevel, $cpuUsage, $batteryConsumption"

        val logFile = getLogFile()
        logFile.appendText(logEntry + "\n")
    }

    private fun getCurrentTimestamp(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date())
    }

    private fun getLogFile(): File {
        val filesDir = context.filesDir
        return File(filesDir, logFileName)
    }
}
