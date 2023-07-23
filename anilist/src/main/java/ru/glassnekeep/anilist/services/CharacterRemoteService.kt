package ru.glassnekeep.anilist.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.AnilistRequest
import ru.glassnekeep.anilist.api.MockedResponses
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.api.enums.CharacterSort
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.ResponseSingleRaw
import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.api.models.domain.mapToResponseSingle
import ru.glassnekeep.anilist.api.models.query.CharacterQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class CharacterRemoteService @Inject constructor(
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
            query = characterQuery,
            response = MockedResponses.characterResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = MockedResponses.emptyVariables
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

    suspend fun getCharacterWithId(id: Int): Character {
        val characterQuery = CharacterQuery(id = id)
        val query = formGetCharacterRequest(characterQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body<ResponseSingleRaw>().mapToResponseSingle().data.character!!
        }
    }

    suspend fun getCharacterListWithMediaId(mediaId: Int) : List<Character> {
        val characterQuery = formGetCharacterRequest(CharacterQuery())
        val pageQuery = PageQuery(page = 1, perPage = pageSize.large)
        val query = formGetCharacterRequest(CharacterQuery(), pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getSortedCharacterList(sort: List<CharacterSort>): List<Character> {
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