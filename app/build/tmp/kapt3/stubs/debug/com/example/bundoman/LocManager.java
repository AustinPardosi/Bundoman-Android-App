package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/example/bundoman/LocManager;", "", "()V", "PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION", "", "currentLatitude", "", "getCurrentLatitude", "()D", "setCurrentLatitude", "(D)V", "currentLongitude", "getCurrentLongitude", "setCurrentLongitude", "checkLocationPermissionAndGetLocation", "", "activity", "Landroid/app/Activity;", "locText", "Lcom/google/android/material/textfield/TextInputEditText;", "getCityFromLatLang", "", "context", "Landroid/content/Context;", "latitude", "longitude", "getLastKnownLocation", "app_debug"})
public final class LocManager {
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private static double currentLatitude = 0.0;
    private static double currentLongitude = 0.0;
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.LocManager INSTANCE = null;
    
    private LocManager() {
        super();
    }
    
    public final double getCurrentLatitude() {
        return 0.0;
    }
    
    public final void setCurrentLatitude(double p0) {
    }
    
    public final double getCurrentLongitude() {
        return 0.0;
    }
    
    public final void setCurrentLongitude(double p0) {
    }
    
    public final void checkLocationPermissionAndGetLocation(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    com.google.android.material.textfield.TextInputEditText locText) {
    }
    
    private final void getLastKnownLocation(android.content.Context context, com.google.android.material.textfield.TextInputEditText locText) {
    }
    
    private final java.lang.String getCityFromLatLang(android.content.Context context, double latitude, double longitude) {
        return null;
    }
}