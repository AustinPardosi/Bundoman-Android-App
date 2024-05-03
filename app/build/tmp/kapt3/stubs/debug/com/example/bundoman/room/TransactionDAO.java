package com.example.bundoman.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\'J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bundoman/room/TransactionDAO;", "", "deleteTransaction", "", "transaction", "Lcom/example/bundoman/room/TransactionEntity;", "(Lcom/example/bundoman/room/TransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransactionWithId", "id", "", "getAllTransaction", "Landroidx/lifecycle/LiveData;", "", "getAllTransactionAsList", "getTransaction", "insertTransaction", "updateTransaction", "app_debug"})
@androidx.room.Dao
public abstract interface TransactionDAO {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull
    com.example.bundoman.room.TransactionEntity transaction, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM transactions ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.bundoman.room.TransactionEntity>> getAllTransaction();
    
    @androidx.room.Query(value = "SELECT * FROM transactions ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.bundoman.room.TransactionEntity> getAllTransactionAsList();
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract com.example.bundoman.room.TransactionEntity getTransaction(int id);
    
    @androidx.room.Query(value = "DELETE FROM transactions WHERE id = :id")
    public abstract void deleteTransactionWithId(int id);
}