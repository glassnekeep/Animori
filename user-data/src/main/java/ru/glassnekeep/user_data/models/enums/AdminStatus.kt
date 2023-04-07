package glasnekeep.models

import kotlinx.serialization.Serializable

@Serializable
enum class AdminStatus {
    SIMPLE, MODERATOR, ADMIN
}