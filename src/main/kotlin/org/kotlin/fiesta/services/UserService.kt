package org.kotlin.fiesta.services

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.persistence.EntityNotFoundException
import org.kotlin.fiesta.api.dto.UserRequestDto
import org.kotlin.fiesta.api.dto.UserResponseDto
import org.kotlin.fiesta.api.dto.UsersRsDto
import org.kotlin.fiesta.domain.data.UserEntity
import org.kotlin.fiesta.domain.repository.UserRepository
import org.kotlin.fiesta.mappers.DomainMapper
import org.kotlin.fiesta.mappers.UsersRsViewMapper
import org.kotlin.fiesta.mappers.ViewMapper
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(
    val repository: UserRepository,
    val domainMapper: DomainMapper,
    val viewMapper: ViewMapper,
    val usersRsViewMapper: UsersRsViewMapper

) {
    private val logger = KotlinLogging.logger {}

    fun getAll(): UsersRsDto {
        val userEntities = repository.findAll()
        return usersRsViewMapper.mapUsers(viewMapper.userEntitiesToUserRsDTOs(userEntities))
    }

    fun getById(id: UUID): UserEntity {
        return repository.findById(id).orElseThrow { EntityNotFoundException("User with ID = '$id' was not found.") }
    }

    fun create(user: UserRequestDto): UserResponseDto {

        logger.info { "Add user with name = '${user.username}'." }
        val userEntity = repository.saveAndFlush(domainMapper.toDomain(user))
        return viewMapper.domainToView(userEntity)
    }

    fun delete(id: UUID): String {
        val user = getById(id)
        repository.delete(user)
        return "{\"message\": \"User with id = '$id' deleted.\"}"
    }

    fun modify(id: UUID, updatedUser: UserEntity): UserEntity {
        val user = getById(id)
        logger.info { "Update user with id = '$id'." }
        return repository.saveAndFlush(user)
    }
}