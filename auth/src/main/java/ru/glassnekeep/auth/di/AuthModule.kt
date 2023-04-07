package ru.glassnekeep.auth.di

import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.di.MediaRoute
import ru.glassnekeep.user_data.di.RegisterRoute
import ru.glassnekeep.user_data.di.UserRoute

@Module
object AuthModule {

    @AppScope
    @Provides
    fun provideContentType(): ContentType = ContentType.Application.Json

    @AppScope
    @Provides
    @UserRoute
    fun provideUserRoute(): String = "user"

    @AppScope
    @Provides
    @MediaRoute
    fun provideMediaRoute(): String = "media"

    @AppScope
    @Provides
    @RegisterRoute
    fun provideRegisterRoute(): String = "register"

    //@AuthClient
    @AppScope
    @Provides
    fun provideAuthClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
            install(Auth) {
                bearer {
                    loadTokens {
                        val accessToken = " "
                        val refreshToken = " "
                        BearerTokens(
                            accessToken = accessToken,
                            refreshToken = refreshToken
                        )
                    }
                    refreshTokens {
                        val accessToken = " "
                        val refreshToken = " "
                        BearerTokens(
                            accessToken = accessToken,
                            refreshToken = refreshToken
                        )
                    }
                    sendWithoutRequest { request ->
                        request.url.host == " "
                    }
                }
            }
            defaultRequest {
                url("https://google.com")
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10000
            }
            install(HttpRequestRetry) {
                retryOnExceptionOrServerErrors(3)
            }
        }
    }
}