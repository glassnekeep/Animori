package ru.glassnekeep.title.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lru/glassnekeep/title/di/TitleScreenComponent;", "Lru/glassnekeep/title/TitleDataProvider;", "Lru/glassnekeep/media_data/MediaDataProvider;", "viewModel", "Lru/glassnekeep/title/TitleScreenViewModel;", "getViewModel", "()Lru/glassnekeep/title/TitleScreenViewModel;", "Factory", "title_screen_impl_debug"})
@dagger.Component(dependencies = {ru.glassnekeep.media_data.MediaDataProvider.class}, modules = {ru.glassnekeep.title.di.TitleModule.class})
public abstract interface TitleScreenComponent extends ru.glassnekeep.title.TitleDataProvider, ru.glassnekeep.media_data.MediaDataProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.glassnekeep.title.TitleScreenViewModel getViewModel();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lru/glassnekeep/title/di/TitleScreenComponent$Factory;", "", "create", "Lru/glassnekeep/title/di/TitleScreenComponent;", "mediaDataProvider", "Lru/glassnekeep/media_data/MediaDataProvider;", "mediaId", "", "title_screen_impl_debug"})
    @dagger.Component.Factory()
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract ru.glassnekeep.title.di.TitleScreenComponent create(@org.jetbrains.annotations.NotNull()
        ru.glassnekeep.media_data.MediaDataProvider mediaDataProvider, @MediaId()
        @dagger.BindsInstance()
        int mediaId);
    }
}