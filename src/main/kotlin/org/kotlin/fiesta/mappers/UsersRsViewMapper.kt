package org.kotlin.fiesta.mappers

import org.kotlin.fiesta.api.dto.UserResponseDto
import org.kotlin.fiesta.api.dto.UsersRsDto
import org.springframework.stereotype.Service

@Service
class UsersRsViewMapper {
    fun mapUsers(users: List<UserResponseDto>): UsersRsDto {
        return UsersRsDto(users)
    }
}