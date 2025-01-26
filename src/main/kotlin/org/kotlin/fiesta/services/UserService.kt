package org.kotlin.fiesta.services

import io.github.oshai.kotlinlogging.KotlinLogging
import org.kotlin.fiesta.domain.Role
import org.kotlin.fiesta.domain.UserEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class UserService {
    private val logger = KotlinLogging.logger{}

    fun getAll(): List<UserEntity> {
        return list
    }

    fun getById(id: UUID): UserEntity? {
        val user = getAll().find { it.id == id }
        if (user == null) {
            throw NoSuchElementException("User with id = '$id' not found.")
        }
        return user
    }

    fun create(user: UserEntity): UserEntity {
        list.add(user)
        logger.info { "User with name = '${user.username}' added." }
        return user
    }

    fun delete(id: UUID): String {
        val user: UserEntity = getById(id)!!
        list.remove(user)
        return "{\"message\": \"User with id = '$id' deleted.\"}"
    }

    fun modify(id: UUID, updatedUser: UserEntity): UserEntity {
        val user = getById(id)!!
        list.remove(user)
        user.id = updatedUser.id
        user.username = updatedUser.username
        user.pass = updatedUser.pass
        user.role = updatedUser.role
        list.add(user)
        logger.info { "User with id = '$id' updated." }
        return user
    }

    private val list = mutableListOf(
        UserEntity(UUID.randomUUID(), "username-1", "passwd", Role.USER),
        UserEntity(UUID.randomUUID(), "username-2", "passwd", Role.ADMIN),
        UserEntity(UUID.randomUUID(), "username-3", "passwd", Role.USER),
        UserEntity(UUID.randomUUID(), "username-4", "passwd", Role.ADMIN),
        UserEntity(UUID.randomUUID(), "username-5", "passwd", Role.USER),
        UserEntity(UUID.randomUUID(), "username-6", "passwd", Role.ADMIN),
    )
}