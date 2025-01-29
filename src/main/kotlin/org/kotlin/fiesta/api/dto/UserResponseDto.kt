package org.kotlin.fiesta.api.dto

import org.kotlin.fiesta.domain.data.Role
import java.util.UUID

data class UserResponseDto(var id: UUID, var username: String, var pass: String, var role: Role)