package com.example.bundoman.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bundoman/repository/TransactionRepository;", "", "database", "Lcom/example/bundoman/room/TransactionDatabase;", "(Lcom/example/bundoman/room/TransactionDatabase;)V", "listTransaction", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/bundoman/room/TransactionEntity;", "getListTransaction", "()Landroidx/lifecycle/LiveData;", "deleteTransaction", "", "transaction", "(Lcom/example/bundoman/room/TransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTransaction", "updateTransaction", "app_debug"})
public final class TransactionRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.bundoman.room.TransactionDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.bundoman.room.TransactionEntity>> listTransaction = null;
    
    public TransactionRepository(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.bundoman.room.TransactionEntity>> getListTransaction() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}