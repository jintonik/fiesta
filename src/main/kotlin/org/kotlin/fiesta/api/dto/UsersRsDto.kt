package org.kotlin.fiesta.api.dto

data class UsersRsDto(var items: List<UserResponseDto>,  var count: Int = items.size)