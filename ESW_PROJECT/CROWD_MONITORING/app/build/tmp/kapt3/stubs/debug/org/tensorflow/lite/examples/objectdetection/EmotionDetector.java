package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J/\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\r2\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u00060\u0006H\u0002\u00a2\u0006\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\"\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00060\u00060\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/EmotionDetector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "emotions", "", "", "[Ljava/lang/String;", "inputArray", "", "[[[[F", "inputBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "interpreter", "Lorg/tensorflow/lite/Interpreter;", "outputArray", "[[F", "detectEmotion", "bitmap", "loadModelFile", "Ljava/nio/MappedByteBuffer;", "preprocessImage", "", "input", "(Landroid/graphics/Bitmap;[[[[F)V", "app_debug"})
public final class EmotionDetector {
    private final org.tensorflow.lite.Interpreter interpreter = null;
    private final java.lang.String[] emotions = {"Angry", "Disgusted", "Fearful", "Happy", "Neutral", "Sad", "Surprised"};
    private final android.graphics.Bitmap inputBitmap = null;
    private final float[][][][] inputArray = null;
    private final float[][] outputArray = null;
    
    public EmotionDetector(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String detectEmotion(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void preprocessImage(android.graphics.Bitmap bitmap, float[][][][] input) {
    }
    
    private final java.nio.MappedByteBuffer loadModelFile(android.content.Context context) {
        return null;
    }
}