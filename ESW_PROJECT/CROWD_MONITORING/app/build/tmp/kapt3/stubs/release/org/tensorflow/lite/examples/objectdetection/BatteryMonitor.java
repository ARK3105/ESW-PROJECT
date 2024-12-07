package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor;", "", "context", "Landroid/content/Context;", "listener", "Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor$BatteryListener;", "(Landroid/content/Context;Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor$BatteryListener;)V", "batteryReceiver", "Landroid/content/BroadcastReceiver;", "cpuMonitorHandler", "Landroid/os/Handler;", "cpuMonitorRunnable", "Ljava/lang/Runnable;", "getCpuUsage", "", "startMonitoring", "", "stopMonitoring", "BatteryListener", "Companion", "app_release"})
public final class BatteryMonitor {
    private final android.content.Context context = null;
    private final org.tensorflow.lite.examples.objectdetection.BatteryMonitor.BatteryListener listener = null;
    private final android.content.BroadcastReceiver batteryReceiver = null;
    private final android.os.Handler cpuMonitorHandler = null;
    private final java.lang.Runnable cpuMonitorRunnable = null;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.objectdetection.BatteryMonitor.Companion Companion = null;
    private static final long CPU_MONITOR_INTERVAL = 1000L;
    
    public BatteryMonitor(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    org.tensorflow.lite.examples.objectdetection.BatteryMonitor.BatteryListener listener) {
        super();
    }
    
    public final void startMonitoring() {
    }
    
    public final void stopMonitoring() {
    }
    
    private final float getCpuUsage() {
        return 0.0F;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor$BatteryListener;", "", "onBatteryConsumptionChanged", "", "batteryConsumption", "", "onBatteryLevelChanged", "batteryLevel", "", "onCpuUsageChanged", "cpuUsage", "app_release"})
    public static abstract interface BatteryListener {
        
        public abstract void onBatteryLevelChanged(int batteryLevel);
        
        public abstract void onCpuUsageChanged(float cpuUsage);
        
        public abstract void onBatteryConsumptionChanged(float batteryConsumption);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor$Companion;", "", "()V", "CPU_MONITOR_INTERVAL", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}