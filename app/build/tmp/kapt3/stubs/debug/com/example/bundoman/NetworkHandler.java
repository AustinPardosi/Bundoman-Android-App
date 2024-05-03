package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/example/bundoman/NetworkHandler;", "Landroid/net/ConnectivityManager$NetworkCallback;", "context", "Landroid/content/Context;", "customNetworkCallback", "Lcom/example/bundoman/NetworkHandler$CustomNetworkCallback;", "(Landroid/content/Context;Lcom/example/bundoman/NetworkHandler$CustomNetworkCallback;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "kotlin.jvm.PlatformType", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "networkRequest", "Landroid/net/NetworkRequest;", "getNetworkRequest", "()Landroid/net/NetworkRequest;", "hasInternet", "", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "register", "unregister", "Companion", "CustomNetworkCallback", "app_debug"})
public final class NetworkHandler extends android.net.ConnectivityManager.NetworkCallback {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private final com.example.bundoman.NetworkHandler.CustomNetworkCallback customNetworkCallback = null;
    private final android.net.ConnectivityManager connectivityManager = null;
    private final android.net.NetworkRequest networkRequest = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String baseUrl = "https://pbd-backend-2024.vercel.app";
    @org.jetbrains.annotations.NotNull
    private static final com.squareup.moshi.Moshi moshi = null;
    private static final retrofit2.Retrofit retrofit = null;
    private static boolean hasInternetAccess = true;
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.NetworkHandler.Companion Companion = null;
    
    public NetworkHandler(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    com.example.bundoman.NetworkHandler.CustomNetworkCallback customNetworkCallback) {
        super();
    }
    
    public final android.net.ConnectivityManager getConnectivityManager() {
        return null;
    }
    
    public final android.net.NetworkRequest getNetworkRequest() {
        return null;
    }
    
    public final void register() {
    }
    
    public final void unregister() {
    }
    
    public final boolean hasInternet() {
        return false;
    }
    
    @java.lang.Override
    public void onAvailable(@org.jetbrains.annotations.NotNull
    android.net.Network network) {
    }
    
    @java.lang.Override
    public void onLost(@org.jetbrains.annotations.NotNull
    android.net.Network network) {
    }
    
    @java.lang.Override
    public void onUnavailable() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bundoman/NetworkHandler$Companion;", "", "()V", "baseUrl", "", "hasInternetAccess", "", "getHasInternetAccess", "()Z", "setHasInternetAccess", "(Z)V", "moshi", "Lcom/squareup/moshi/Moshi;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofitClient", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getHasInternetAccess() {
            return false;
        }
        
        public final void setHasInternetAccess(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final retrofit2.Retrofit getRetrofitClient() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bundoman/NetworkHandler$CustomNetworkCallback;", "", "onNetAvailable", "", "onNetNotAvailable", "app_debug"})
    public static abstract interface CustomNetworkCallback {
        
        public abstract void onNetAvailable();
        
        public abstract void onNetNotAvailable();
    }
}