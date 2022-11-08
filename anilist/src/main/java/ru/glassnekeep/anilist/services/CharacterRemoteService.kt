package ru.glassnekeep.anilist.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.*
import ru.glassnekeep.anilist.api.di.AnilistClient
import ru.glassnekeep.anilist.api.enums.CharacterSort
import ru.glassnekeep.anilist.api.models.query.CharacterQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject
import ru.glassnekeep.anilist.api.models.domain.character.Character

@AppScope
class CharacterRemoteService @Inject constructor(
    @AnilistClient
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSize: PageSizes,
    private val contentType: ContentType
) {
    private fun formGetCharacterRequest(
        characterQuery: CharacterQuery,
        pageQuery: PageQuery? = null
    ) : AnilistRequest {
        val requestString = makeRequestString(
            query = mediaQuery,
            response = MockedResponses.characterResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = ""
        )
    }

suspend fun getCharacter(characterQuery: CharacterQuery) : Character {
    val query = formGetCharacterRequest(characterQuery)
    return withContext(dispatchers.io) {
        client.post {
            contentType(contentType)
            setBody(query)
        }.body()
    }
}

    suspend fun getCharacterList(characterQuery: CharacterQuery) : List<Character> {
        val pageQuery = PageQuery(page = 1, perPage = pageSize.large)
        val query = formGetCharacterRequest(characterQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getSortedMediaList(sort: List<CharacterSort>): List<Character> {
        val characterQuery = CharacterQuery(
            sort = sort
        )
        val pageQuery = PageQuery(
            page = 1,
            perPage = pageSize.large
        )
        val query = formGetCharacterRequest(characterQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }
}