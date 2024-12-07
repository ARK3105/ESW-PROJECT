package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MetricLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "logFileName", "", "getCurrentTimestamp", "getLogFile", "Ljava/io/File;", "logMetrics", "", "batteryLevel", "", "cpuUsage", "", "batteryConsumption", "selectedModel", "app_debug"})
public final class MetricLogger {
    private final android.content.Context context = null;
    private final java.lang.String logFileName = "metrics_log.txt";
    
    public MetricLogger(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void logMetrics(int batteryLevel, float cpuUsage, float batteryConsumption, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedModel) {
    }
    
    private final java.lang.String getCurrentTimestamp() {
        return null;
    }
    
    private final java.io.File getLogFile() {
        return null;
    }
}