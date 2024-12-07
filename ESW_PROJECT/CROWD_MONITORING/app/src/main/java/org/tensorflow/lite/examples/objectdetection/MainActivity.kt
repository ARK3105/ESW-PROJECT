package org.tensorflow.lite.examples.objectdetection

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.os.Debug
import android.os.Environment
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), BatteryMonitor.BatteryListener {

    private lateinit var textViewBatteryLevel: TextView
    private lateinit var textViewCpuUsage: TextView
    private lateinit var textViewBatteryConsumption: TextView
    private lateinit var textViewSelectedModel: TextView
    private lateinit var batteryMonitor: BatteryMonitor
    private lateinit var textViewPersonCount: TextView


    private var logFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewBatteryLevel = findViewById(R.id.textViewBatteryLevel)
        textViewCpuUsage = findViewById(R.id.textViewCpuUsage)
        textViewBatteryConsumption = findViewById(R.id.textViewBatteryConsumption)
        textViewSelectedModel = findViewById(R.id.textViewSelectedModel)
          // Initialize person count TextView
        textViewPersonCount = findViewById(R.id.textViewPersonCount)

        batteryMonitor = BatteryMonitor(this, this)
        batteryMonitor.startMonitoring()

        createLogFile()
    }

    override fun onDestroy() {
        super.onDestroy()
        batteryMonitor.stopMonitoring()
    }

    override fun onBatteryLevelChanged(batteryLevel: Int) {
        textViewBatteryLevel.text = "Battery Level: $batteryLevel%"
        updateSelectedModel()

        writeToLogFile("Timestamp: ${getCurrentTimestamp()}")
        writeToLogFile("Selected Model: ${getModelBasedOnCriteria()}")
        writeToLogFile("Battery Level: $batteryLevel%")
    }

    override fun onCpuUsageChanged(cpuUsage: Float) {
        textViewCpuUsage.text = "CPU Usage: $cpuUsage%"
        updateSelectedModel()

        writeToLogFile("Timestamp: ${getCurrentTimestamp()}")
        writeToLogFile("Selected Model: ${getModelBasedOnCriteria()}")
        writeToLogFile("CPU Usage: $cpuUsage%")
    }

    override fun onBatteryConsumptionChanged(batteryConsumption: Float) {
        textViewBatteryConsumption.text = "Battery Consumption: $batteryConsumption%"
        updateSelectedModel()

        writeToLogFile("Timestamp: ${getCurrentTimestamp()}")
        writeToLogFile("Selected Model: ${getModelBasedOnCriteria()}")
        writeToLogFile("Battery Consumption: $batteryConsumption%")
    }

    // Implement the new method
    fun onPersonCount(count: Int) {
        textViewPersonCount.text = "Persons Detected: $count"
    }

    private fun updateSelectedModel() {
        val selectedModel = getModelBasedOnCriteria()
        textViewSelectedModel.text = "Selected Model: $selectedModel"
    }

    private fun getModelBasedOnCriteria(): String {
        val cpuUsage = getCpuUsage()
        val batteryLevel = getBatteryLevel() 
        val batteryConsumption = getBatteryConsumption()

        return when {
            cpuUsage > 80 -> "EfficientDet Lite0"
            cpuUsage > 60 -> "EfficientDet Lite1"
            cpuUsage > 40 -> "EfficientDet Lite2"
            batteryLevel > 80 -> "EfficientDet Lite0"
            batteryLevel > 60 -> "EfficientDet Lite1"
            batteryLevel > 40 -> "EfficientDet Lite2"
            batteryConsumption > 80 -> "EfficientDet Lite0"
            batteryConsumption > 60 -> "EfficientDet Lite1"
            batteryConsumption > 40 -> "EfficientDet Lite2"
            else -> "MobileNet V1"
        }
    }

    private fun getCpuUsage(): Float {
        val cpuTime = Debug.threadCpuTimeNanos()
        val elapsedTime = System.nanoTime() - cpuTime
        val cpuUsage = (cpuTime / elapsedTime.toFloat()) * 100

        return if (cpuUsage.isNaN() || cpuUsage.isInfinite()) 0f else cpuUsage
    }

    private fun getBatteryLevel(): Int {
        val batteryManager = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }

    private fun getBatteryConsumption(): Float {
        val batteryManager = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batteryLevel = getBatteryLevel()
        val cpuUsage = getCpuUsage()

        // Replace the following line with your calculation logic for battery consumption
        // This is just a sample calculation based on battery level and CPU usage
        return batteryLevel * cpuUsage / 100.0f
    }

    private fun createLogFile() {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "log_$timeStamp.txt"
        val directory = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)

        if (directory != null && directory.exists()) {
            logFile = File(directory, fileName)
        } else {
            logFile = File(filesDir, fileName)
        }
    }

    private fun writeToLogFile(message: String) {
        if (logFile != null) {
            try {
                val writer = FileWriter(logFile!!, true)
                writer.write(message)
                writer.write("\n")
                writer.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun getCurrentTimestamp(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val currentTime = Date()
        return dateFormat.format(currentTime)
    }
}

class BatteryMonitor(private val context: Context, private val listener: BatteryListener) {

    private val batteryReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            listener.onBatteryLevelChanged(batteryLevel)
        }
    }

    private val cpuMonitorHandler = Handler(Looper.getMainLooper())
    private val cpuMonitorRunnable = object : Runnable {
        override fun run() {
            val cpuUsage = getCpuUsage()
            listener.onCpuUsageChanged(cpuUsage)
            listener.onBatteryConsumptionChanged(cpuUsage) // Notify about battery consumption
            cpuMonitorHandler.postDelayed(this, CPU_MONITOR_INTERVAL)
        }
    }

    fun startMonitoring() {
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        context.registerReceiver(batteryReceiver, filter)
        cpuMonitorHandler.postDelayed(cpuMonitorRunnable, CPU_MONITOR_INTERVAL)
    }

    fun stopMonitoring() {
        context.unregisterReceiver(batteryReceiver)
        cpuMonitorHandler.removeCallbacks(cpuMonitorRunnable)
    }

    private fun getCpuUsage(): Float {
        val cpuTime = Debug.threadCpuTimeNanos()
        val elapsedTime = System.nanoTime() - cpuTime
        val cpuUsage = (cpuTime / elapsedTime.toFloat()) * 100

        return if (cpuUsage.isNaN() || cpuUsage.isInfinite()) 0f else cpuUsage
    }

    interface BatteryListener {
        fun onBatteryLevelChanged(batteryLevel: Int)
        fun onCpuUsageChanged(cpuUsage: Float)
        fun onBatteryConsumptionChanged(batteryConsumption: Float)
    }

    companion object {
        private const val CPU_MONITOR_INTERVAL = 1000L // 1 second
    }
}
