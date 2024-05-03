package com.example.bundoman;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/bundoman/Dashboard;", "Lcom/example/bundoman/NetworkSenseBaseActivity;", "()V", "binding", "Lcom/example/bundoman/databinding/ActivityDashboardBinding;", "headerText", "", "viewModel", "Lcom/example/bundoman/ui/listTransaction/ListTransactionViewModel;", "getViewModel", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onSaveInstanceState", "outState", "replaceFragment", "fragment", "Landroidx/fragment/app/Fragment;", "setHeaderText", "text", "setupBottomNavigation", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "setupNavigationRail", "navigationRail", "Lcom/google/android/material/navigationrail/NavigationRailView;", "Companion", "app_debug"})
public final class Dashboard extends com.example.bundoman.NetworkSenseBaseActivity {
    private com.example.bundoman.databinding.ActivityDashboardBinding binding;
    @org.jetbrains.annotations.NotNull
    private java.lang.String headerText = "";
    private com.example.bundoman.ui.listTransaction.ListTransactionViewModel viewModel;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String HEADER_TEXT_KEY = "header_text";
    @org.jetbrains.annotations.NotNull
    public static final com.example.bundoman.Dashboard.Companion Companion = null;
    
    public Dashboard() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.bundoman.ui.listTransaction.ListTransactionViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle outState) {
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    private final void setHeaderText(java.lang.String text) {
    }
    
    private final void setupBottomNavigation(com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView) {
    }
    
    private final void setupNavigationRail(com.google.android.material.navigationrail.NavigationRailView navigationRail) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/bundoman/Dashboard$Companion;", "", "()V", "HEADER_TEXT_KEY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}