package glasnekeep.models

import kotlinx.serialization.Serializable

@Serializable
enum class VipStatus {
    NO, FIRST_LEVEL, SECOND_LEVEL, THIRD_LEVEL, VIP_LEVEL
}