package org.kotlin.fiesta.mappers

import org.kotlin.fiesta.api.dto.UserResponseDto
import org.kotlin.fiesta.domain.data.UserEntity
import org.springframework.stereotype.Service


@Service
class ViewMapper {
    fun domainToView(user: UserEntity): UserResponseDto =
        UserResponseDto(user.id!!, user.username, user.pass, user.role)

    fun userEntitiesToUserRsDTOs(userEntities: List<UserEntity>): List<UserResponseDto> {
        return userEntities.map { UserResponseDto(it.id!!, it.username, it.pass, it.role) }.toList()
    }
}