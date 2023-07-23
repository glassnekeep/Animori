package ru.glassnekeep.title.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bR\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lru/glassnekeep/title/di/TitleScreenComponent;", "Lru/glassnekeep/title/TitleDataProvider;", "Lru/glassnekeep/media_data/MediaDataProvider;", "Lru/glassnekeep/character_data/CharacterDataProvider;", "viewModel", "Lru/glassnekeep/title/TitleScreenViewModel;", "getViewModel", "()Lru/glassnekeep/title/TitleScreenViewModel;", "Factory", "title_screen_impl_debug"})
@dagger.Component(dependencies = {ru.glassnekeep.media_data.MediaDataProvider.class, ru.glassnekeep.character_data.CharacterDataProvider.class}, modules = {ru.glassnekeep.title.di.TitleModule.class})
public abstract interface TitleScreenComponent extends ru.glassnekeep.title.TitleDataProvider, ru.glassnekeep.media_data.MediaDataProvider, ru.glassnekeep.character_data.CharacterDataProvider {
    
    @org.jetbrains.annotations.NotNull
    public abstract ru.glassnekeep.title.TitleScreenViewModel getViewModel();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lru/glassnekeep/title/di/TitleScreenComponent$Factory;", "", "create", "Lru/glassnekeep/title/di/TitleScreenComponent;", "mediaDataProvider", "Lru/glassnekeep/media_data/MediaDataProvider;", "characterDataProvider", "Lru/glassnekeep/character_data/CharacterDataProvider;", "mediaId", "", "title_screen_impl_debug"})
    @dagger.Component.Factory
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract ru.glassnekeep.title.di.TitleScreenComponent create(@org.jetbrains.annotations.NotNull
        ru.glassnekeep.media_data.MediaDataProvider mediaDataProvider, @org.jetbrains.annotations.NotNull
        ru.glassnekeep.character_data.CharacterDataProvider characterDataProvider, @MediaId
        @dagger.BindsInstance
        int mediaId);
    }
}