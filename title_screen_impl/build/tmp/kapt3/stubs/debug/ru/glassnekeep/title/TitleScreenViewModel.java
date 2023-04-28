package ru.glassnekeep.title;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "getAnimeUseCase", "Lru/glassnekeep/media_data/use_cases/GetAnimeUseCase;", "mediaId", "", "(Lru/glassnekeep/media_data/use_cases/GetAnimeUseCase;I)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadMedia", "", "reduce", "event", "Lru/glassnekeep/title/TitleScreenViewModel$Event;", "Companion", "Event", "TitleState", "title_screen_impl_debug"})
public final class TitleScreenViewModel extends androidx.lifecycle.ViewModel {
    private final ru.glassnekeep.media_data.use_cases.GetAnimeUseCase getAnimeUseCase = null;
    private final int mediaId = 0;
    private kotlinx.coroutines.flow.MutableStateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleState> _state;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleState> state = null;
    @org.jetbrains.annotations.NotNull()
    private static final ru.glassnekeep.title.TitleScreenViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String DEFAULT_ERROR_MSG = "Error occurred";
    
    @javax.inject.Inject()
    public TitleScreenViewModel(@org.jetbrains.annotations.NotNull()
    ru.glassnekeep.media_data.use_cases.GetAnimeUseCase getAnimeUseCase, @ru.glassnekeep.title.di.MediaId()
    int mediaId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleState> getState() {
        return null;
    }
    
    private final void loadMedia() {
    }
    
    public final void reduce(@org.jetbrains.annotations.NotNull()
    ru.glassnekeep.title.TitleScreenViewModel.TitleState state, @org.jetbrains.annotations.NotNull()
    ru.glassnekeep.title.TitleScreenViewModel.Event event) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "", "()V", "Data", "Error", "Loading", "NotFound", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Data;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Error;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Loading;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState$NotFound;", "title_screen_impl_debug"})
    public static abstract class TitleState {
        
        private TitleState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Loading;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "()V", "title_screen_impl_debug"})
        public static final class Loading extends ru.glassnekeep.title.TitleScreenViewModel.TitleState {
            @org.jetbrains.annotations.NotNull()
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleState.Loading INSTANCE = null;
            
            private Loading() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Data;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "data", "Lru/glassnekeep/media_data/models/AnimeDetail;", "(Lru/glassnekeep/media_data/models/AnimeDetail;)V", "getData", "()Lru/glassnekeep/media_data/models/AnimeDetail;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "title_screen_impl_debug"})
        public static final class Data extends ru.glassnekeep.title.TitleScreenViewModel.TitleState {
            @org.jetbrains.annotations.NotNull()
            private final ru.glassnekeep.media_data.models.AnimeDetail data = null;
            
            @org.jetbrains.annotations.NotNull()
            public final ru.glassnekeep.title.TitleScreenViewModel.TitleState.Data copy(@org.jetbrains.annotations.NotNull()
            ru.glassnekeep.media_data.models.AnimeDetail data) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Data(@org.jetbrains.annotations.NotNull()
            ru.glassnekeep.media_data.models.AnimeDetail data) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.glassnekeep.media_data.models.AnimeDetail component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ru.glassnekeep.media_data.models.AnimeDetail getData() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleState$NotFound;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "()V", "title_screen_impl_debug"})
        public static final class NotFound extends ru.glassnekeep.title.TitleScreenViewModel.TitleState {
            @org.jetbrains.annotations.NotNull()
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleState.NotFound INSTANCE = null;
            
            private NotFound() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleState$Error;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleState;", "exception", "", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "getException", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "title_screen_impl_debug"})
        public static final class Error extends ru.glassnekeep.title.TitleScreenViewModel.TitleState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.Throwable exception = null;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            @org.jetbrains.annotations.NotNull()
            public final ru.glassnekeep.title.TitleScreenViewModel.TitleState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable exception, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.Throwable exception, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.Throwable getException() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Event;", "", "()V", "Load", "Refresh", "ShowDetails", "Lru/glassnekeep/title/TitleScreenViewModel$Event$Load;", "Lru/glassnekeep/title/TitleScreenViewModel$Event$Refresh;", "Lru/glassnekeep/title/TitleScreenViewModel$Event$ShowDetails;", "title_screen_impl_debug"})
    public static abstract class Event {
        
        private Event() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Event$Load;", "Lru/glassnekeep/title/TitleScreenViewModel$Event;", "()V", "title_screen_impl_debug"})
        public static final class Load extends ru.glassnekeep.title.TitleScreenViewModel.Event {
            @org.jetbrains.annotations.NotNull()
            public static final ru.glassnekeep.title.TitleScreenViewModel.Event.Load INSTANCE = null;
            
            private Load() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Event$Refresh;", "Lru/glassnekeep/title/TitleScreenViewModel$Event;", "()V", "title_screen_impl_debug"})
        public static final class Refresh extends ru.glassnekeep.title.TitleScreenViewModel.Event {
            @org.jetbrains.annotations.NotNull()
            public static final ru.glassnekeep.title.TitleScreenViewModel.Event.Refresh INSTANCE = null;
            
            private Refresh() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Event$ShowDetails;", "Lru/glassnekeep/title/TitleScreenViewModel$Event;", "()V", "title_screen_impl_debug"})
        public static final class ShowDetails extends ru.glassnekeep.title.TitleScreenViewModel.Event {
            @org.jetbrains.annotations.NotNull()
            public static final ru.glassnekeep.title.TitleScreenViewModel.Event.ShowDetails INSTANCE = null;
            
            private ShowDetails() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Companion;", "", "()V", "DEFAULT_ERROR_MSG", "", "title_screen_impl_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}