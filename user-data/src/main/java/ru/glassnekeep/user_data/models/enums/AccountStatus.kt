package glasnekeep.models

import kotlinx.serialization.Serializable

@Serializable
enum class AccountStatus {
    ACTIVE, BANNED, DELETED
}