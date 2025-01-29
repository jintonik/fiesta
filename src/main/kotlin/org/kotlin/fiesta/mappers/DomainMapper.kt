package org.kotlin.fiesta.mappers

import org.kotlin.fiesta.api.dto.UserRequestDto
import org.kotlin.fiesta.domain.data.UserEntity
import org.springframework.stereotype.Service

@Service
class DomainMapper {
    fun toDomain(user: UserRequestDto): UserEntity =
        UserEntity(null, user.username, user.pass, user.role)
}