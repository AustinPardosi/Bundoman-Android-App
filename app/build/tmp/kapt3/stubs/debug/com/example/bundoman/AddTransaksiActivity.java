package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/example/bundoman/AddTransaksiActivity;", "Lcom/example/bundoman/NetworkSenseBaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "validateInputs", "", "title", "", "nominal", "location", "Companion", "app_debug"})
public final class AddTransaksiActivity extends com.example.bundoman.NetworkSenseBaseActivity {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.Character> charPool = null;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String randomTitle = "";
    private static double randomNominal = 0.0;
    @org.jetbrains.annotations.NotNull
    private static final com.example.bundoman.RandomizeReceiver randomizeReceiver = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.AddTransaksiActivity.Companion Companion = null;
    
    public AddTransaksiActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final boolean validateInputs(java.lang.String title, java.lang.String nominal, java.lang.String location) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bundoman/AddTransaksiActivity$Companion;", "", "()V", "charPool", "", "", "randomNominal", "", "randomTitle", "", "randomizeReceiver", "Lcom/example/bundoman/RandomizeReceiver;", "getRandomizeReceiver", "()Lcom/example/bundoman/RandomizeReceiver;", "randomStringGenerator", "randomizeTransaction", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.bundoman.RandomizeReceiver getRandomizeReceiver() {
            return null;
        }
        
        private final java.lang.String randomStringGenerator() {
            return null;
        }
        
        public final void randomizeTransaction() {
        }
    }
}