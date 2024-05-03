package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/bundoman/ExcelManager;", "", "()V", "EXCEL_DIRECTORY", "", "createExcelFile", "Ljava/io/File;", "fileName", "getTransactionFile", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "transactions", "", "Lcom/example/bundoman/room/TransactionEntity;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "saveTransactions", "", "format", "app_debug"})
public final class ExcelManager {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EXCEL_DIRECTORY = "/excel_files";
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.ExcelManager INSTANCE = null;
    
    private ExcelManager() {
        super();
    }
    
    public final void saveTransactions(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.bundoman.room.TransactionEntity> transactions, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull
    java.lang.String format) {
    }
    
    private final java.io.File createExcelFile(java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.net.Uri getTransactionFile(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.bundoman.room.TransactionEntity> transactions, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope) {
        return null;
    }
}