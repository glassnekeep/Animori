package ru.glassnekeep.anilist.api.di

import android.accounts.NetworkErrorException
import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.api.di.AnilistClient
import ru.glassnekeep.core.di.AppScope

@Module
object AniListModule {
    @AppScope
    @AnilistClient
    @Provides
    fun provideAniListApiClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
            defaultRequest {
                url("https://graphql.anilist.co/")
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15000
            }
            install(HttpRequestRetry) {
                maxRetries = 5
                exponentialDelay()
                retryIf { httpRequest, httpResponse ->
                    !httpResponse.status.isSuccess()
                }
                retryOnExceptionIf { httpRequestBuilder, throwable ->
                    throwable is ServerResponseException || throwable is NetworkErrorException
                }
                retryOnServerErrors(maxRetries)
                modifyRequest { request ->

                }
            }
            HttpResponseValidator {
                validateResponse { response ->

                }
            }
            install(HttpCache)
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }
            //expectSuccess = true
        }
    }

    @Provides
    @AppScope
    fun providePageSizes() = PageSizes

}