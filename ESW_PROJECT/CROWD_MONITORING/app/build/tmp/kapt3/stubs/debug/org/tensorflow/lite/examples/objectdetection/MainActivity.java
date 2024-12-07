package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u000fH\u0014J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0013J\b\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor$BatteryListener;", "()V", "batteryMonitor", "Lorg/tensorflow/lite/examples/objectdetection/BatteryMonitor;", "logFile", "Ljava/io/File;", "textViewBatteryConsumption", "Landroid/widget/TextView;", "textViewBatteryLevel", "textViewCpuUsage", "textViewPersonCount", "textViewSelectedModel", "createLogFile", "", "getBatteryConsumption", "", "getBatteryLevel", "", "getCpuUsage", "getCurrentTimestamp", "", "getModelBasedOnCriteria", "onBatteryConsumptionChanged", "batteryConsumption", "onBatteryLevelChanged", "batteryLevel", "onCpuUsageChanged", "cpuUsage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPersonCount", "count", "updateSelectedModel", "writeToLogFile", "message", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements org.tensorflow.lite.examples.objectdetection.BatteryMonitor.BatteryListener {
    private android.widget.TextView textViewBatteryLevel;
    private android.widget.TextView textViewCpuUsage;
    private android.widget.TextView textViewBatteryConsumption;
    private android.widget.TextView textViewSelectedModel;
    private org.tensorflow.lite.examples.objectdetection.BatteryMonitor batteryMonitor;
    private android.widget.TextView textViewPersonCount;
    private java.io.File logFile;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onBatteryLevelChanged(int batteryLevel) {
    }
    
    @java.lang.Override()
    public void onCpuUsageChanged(float cpuUsage) {
    }
    
    @java.lang.Override()
    public void onBatteryConsumptionChanged(float batteryConsumption) {
    }
    
    public final void onPersonCount(int count) {
    }
    
    private final void updateSelectedModel() {
    }
    
    private final java.lang.String getModelBasedOnCriteria() {
        return null;
    }
    
    private final float getCpuUsage() {
        return 0.0F;
    }
    
    private final int getBatteryLevel() {
        return 0;
    }
    
    private final float getBatteryConsumption() {
        return 0.0F;
    }
    
    private final void createLogFile() {
    }
    
    private final void writeToLogFile(java.lang.String message) {
    }
    
    private final java.lang.String getCurrentTimestamp() {
        return null;
    }
}