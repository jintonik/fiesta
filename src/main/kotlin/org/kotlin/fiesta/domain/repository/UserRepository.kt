package org.kotlin.fiesta.domain.repository

import org.kotlin.fiesta.domain.data.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID


interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun getByUsername(username: String): UserEntity
}