package org.kotlin.fiesta.api.dto

import org.kotlin.fiesta.domain.data.Role

data class UserRequestDto (var username: String, var pass: String, var role: Role)