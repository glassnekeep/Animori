package ru.glassnekeep.network

import android.accounts.NetworkErrorException
import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import ru.glassnekeep.core.di.AppScope

@Module
object NetworkModule {
    @Provides
    @AppScope
    fun provideKtorClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                json()
            }
            defaultRequest {
                url("https://google.com")
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15000
            }
            install(HttpRequestRetry) {
                maxRetries = 10
                retryIf { httpRequest, httpResponse ->
                    !httpResponse.status.isSuccess()
                }
                retryOnExceptionIf { httpRequestBuilder, throwable ->
                    throwable is ServerResponseException || throwable is NetworkErrorException
                }
                retryOnServerErrors(maxRetries)
            }
            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }
            expectSuccess = true
        }
    }
}
