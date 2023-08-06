package ru.glassnekeep.title;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "getAnimeUseCase", "Lru/glassnekeep/media_data/use_cases/GetAnimeUseCase;", "mediaId", "", "(Lru/glassnekeep/media_data/use_cases/GetAnimeUseCase;I)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState$title_screen_impl_debug", "()Lkotlinx/coroutines/flow/StateFlow;", "loadMedia", "", "reduce", "event", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "Companion", "TitleEvent", "TitleScreenState", "title_screen_impl_debug"})
public final class TitleScreenViewModel extends androidx.lifecycle.ViewModel {
    private final ru.glassnekeep.media_data.use_cases.GetAnimeUseCase getAnimeUseCase = null;
    private final int mediaId = 0;
    private kotlinx.coroutines.flow.MutableStateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState> _state;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState> state = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    @org.jetbrains.annotations.NotNull
    private static final ru.glassnekeep.title.TitleScreenViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    @java.lang.Deprecated
    public static final java.lang.String DEFAULT_ERROR_MSG = "Error occurred";
    @org.jetbrains.annotations.NotNull
    @java.lang.Deprecated
    public static final java.lang.String TAG = "Get anime";
    
    @javax.inject.Inject
    public TitleScreenViewModel(@org.jetbrains.annotations.NotNull
    ru.glassnekeep.media_data.use_cases.GetAnimeUseCase getAnimeUseCase, @ru.glassnekeep.title.di.MediaId
    int mediaId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState> getState$title_screen_impl_debug() {
        return null;
    }
    
    private final void loadMedia() {
    }
    
    private final void reduce(ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState state, ru.glassnekeep.title.TitleScreenViewModel.TitleEvent event) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "Lru/glassnekeep/core/mvi/State;", "()V", "Data", "Error", "Loading", "NotFound", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Data;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Error;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Loading;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$NotFound;", "title_screen_impl_debug"})
    public static abstract class TitleScreenState implements ru.glassnekeep.core.mvi.State {
        
        private TitleScreenState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Loading;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "()V", "title_screen_impl_debug"})
        public static final class Loading extends ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState {
            @org.jetbrains.annotations.NotNull
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState.Loading INSTANCE = null;
            
            private Loading() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Data;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "data", "Lru/glassnekeep/media_data/models/AnimeDetail;", "(Lru/glassnekeep/media_data/models/AnimeDetail;)V", "getData", "()Lru/glassnekeep/media_data/models/AnimeDetail;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "title_screen_impl_debug"})
        public static final class Data extends ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState {
            @org.jetbrains.annotations.NotNull
            private final ru.glassnekeep.media_data.models.AnimeDetail data = null;
            
            @org.jetbrains.annotations.NotNull
            public final ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState.Data copy(@org.jetbrains.annotations.NotNull
            ru.glassnekeep.media_data.models.AnimeDetail data) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public Data(@org.jetbrains.annotations.NotNull
            ru.glassnekeep.media_data.models.AnimeDetail data) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final ru.glassnekeep.media_data.models.AnimeDetail component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final ru.glassnekeep.media_data.models.AnimeDetail getData() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$NotFound;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "()V", "title_screen_impl_debug"})
        public static final class NotFound extends ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState {
            @org.jetbrains.annotations.NotNull
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState.NotFound INSTANCE = null;
            
            private NotFound() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState$Error;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleScreenState;", "exception", "", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "getException", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "title_screen_impl_debug"})
        public static final class Error extends ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState {
            @org.jetbrains.annotations.NotNull
            private final java.lang.Throwable exception = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String message = null;
            
            @org.jetbrains.annotations.NotNull
            public final ru.glassnekeep.title.TitleScreenViewModel.TitleScreenState.Error copy(@org.jetbrains.annotations.NotNull
            java.lang.Throwable exception, @org.jetbrains.annotations.NotNull
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public Error(@org.jetbrains.annotations.NotNull
            java.lang.Throwable exception, @org.jetbrains.annotations.NotNull
            java.lang.String message) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.Throwable component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.Throwable getException() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMessage() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "Lru/glassnekeep/core/mvi/Event;", "()V", "Load", "NavigateToCharacter", "Refresh", "ShowDetails", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$Load;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$NavigateToCharacter;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$Refresh;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$ShowDetails;", "title_screen_impl_debug"})
    static abstract class TitleEvent implements ru.glassnekeep.core.mvi.Event {
        
        private TitleEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$Load;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "()V", "title_screen_impl_debug"})
        public static final class Load extends ru.glassnekeep.title.TitleScreenViewModel.TitleEvent {
            @org.jetbrains.annotations.NotNull
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleEvent.Load INSTANCE = null;
            
            private Load() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$Refresh;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "()V", "title_screen_impl_debug"})
        public static final class Refresh extends ru.glassnekeep.title.TitleScreenViewModel.TitleEvent {
            @org.jetbrains.annotations.NotNull
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleEvent.Refresh INSTANCE = null;
            
            private Refresh() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$ShowDetails;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "()V", "title_screen_impl_debug"})
        public static final class ShowDetails extends ru.glassnekeep.title.TitleScreenViewModel.TitleEvent {
            @org.jetbrains.annotations.NotNull
            public static final ru.glassnekeep.title.TitleScreenViewModel.TitleEvent.ShowDetails INSTANCE = null;
            
            private ShowDetails() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent$NavigateToCharacter;", "Lru/glassnekeep/title/TitleScreenViewModel$TitleEvent;", "id", "", "(I)V", "title_screen_impl_debug"})
        public static final class NavigateToCharacter extends ru.glassnekeep.title.TitleScreenViewModel.TitleEvent {
            
            public NavigateToCharacter(int id) {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lru/glassnekeep/title/TitleScreenViewModel$Companion;", "", "()V", "DEFAULT_ERROR_MSG", "", "TAG", "title_screen_impl_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}