package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/example/bundoman/NetworkSenseBaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/bundoman/NetworkHandler$CustomNetworkCallback;", "()V", "networkHandler", "Lcom/example/bundoman/NetworkHandler;", "getNetworkHandler", "()Lcom/example/bundoman/NetworkHandler;", "setNetworkHandler", "(Lcom/example/bundoman/NetworkHandler;)V", "networkSnackbar", "Lcom/google/android/material/snackbar/Snackbar;", "getNetworkSnackbar", "()Lcom/google/android/material/snackbar/Snackbar;", "setNetworkSnackbar", "(Lcom/google/android/material/snackbar/Snackbar;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNetAvailable", "onNetNotAvailable", "onPause", "onResume", "app_debug"})
public class NetworkSenseBaseActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.bundoman.NetworkHandler.CustomNetworkCallback {
    public com.example.bundoman.NetworkHandler networkHandler;
    public com.google.android.material.snackbar.Snackbar networkSnackbar;
    
    public NetworkSenseBaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.bundoman.NetworkHandler getNetworkHandler() {
        return null;
    }
    
    public final void setNetworkHandler(@org.jetbrains.annotations.NotNull
    com.example.bundoman.NetworkHandler p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.material.snackbar.Snackbar getNetworkSnackbar() {
        return null;
    }
    
    public final void setNetworkSnackbar(@org.jetbrains.annotations.NotNull
    com.google.android.material.snackbar.Snackbar p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    public void onNetAvailable() {
    }
    
    @java.lang.Override
    public void onNetNotAvailable() {
    }
}