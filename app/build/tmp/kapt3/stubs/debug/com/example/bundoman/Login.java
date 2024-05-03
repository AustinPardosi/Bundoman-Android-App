package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/example/bundoman/Login;", "Lcom/example/bundoman/NetworkSenseBaseActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "validateEmail", "", "email", "", "validatePassword", "password", "Companion", "app_debug"})
public final class Login extends com.example.bundoman.NetworkSenseBaseActivity {
    private static boolean loggingIn = false;
    private static boolean calledByLoginPage = false;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String currEmail = "";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String currPassword = "";
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.Login.Companion Companion = null;
    
    public Login() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean validateEmail(java.lang.String email) {
        return false;
    }
    
    private final boolean validatePassword(java.lang.String password) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/bundoman/Login$Companion;", "", "()V", "calledByLoginPage", "", "currEmail", "", "getCurrEmail", "()Ljava/lang/String;", "setCurrEmail", "(Ljava/lang/String;)V", "currPassword", "loggingIn", "login", "", "context", "Landroid/content/Context;", "email", "password", "logout", "relogin", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCurrEmail() {
            return null;
        }
        
        public final void setCurrEmail(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        public final void relogin(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        public final void login(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        java.lang.String email, @org.jetbrains.annotations.NotNull
        java.lang.String password) {
        }
        
        public final void logout(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
}