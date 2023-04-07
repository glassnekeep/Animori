package ru.glassnekeep.user_data.models

import glasnekeep.models.AccountStatus
import glasnekeep.models.AdminStatus
import glasnekeep.models.Sex
import glasnekeep.models.VipStatus
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long? = null,
    val username: String,
    val password: String,
    val email: String,
    val firstname: String? = null,
    val lastname: String? = null,
    val age: Int? = null,
    val birthDate: String? = null,
    val reputation: Int,
    val accountStatus: AccountStatus,
    val phoneNumber: String? = null,
    val status: String? = null,
    val vipStatus: VipStatus,
    val profileImage: String? = null,
    val sex: Sex? = null,
    val adminStatus: AdminStatus,
)