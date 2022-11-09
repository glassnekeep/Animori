package ru.glassnekeep.shikimori

import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import ru.glassnekeep.core.di.AppScope

@Module
object ShikimoriModule {
    @AppScope
    @Provides
    @ShikimoriClient
    fun provideShikimoriClient(): HttpClient =
        HttpClient(Android) {
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
                url("")
            }
        }
}