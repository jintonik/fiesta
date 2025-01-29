package org.kotlin.fiesta.api.controller

import org.kotlin.fiesta.api.dto.UserRequestDto
import org.kotlin.fiesta.api.dto.UserResponseDto
import org.kotlin.fiesta.api.dto.UsersRsDto
import org.kotlin.fiesta.domain.data.UserEntity
import org.kotlin.fiesta.services.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAll(): UsersRsDto {
        return userService.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): UserEntity {
        return userService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody user: UserRequestDto): UserResponseDto {
        return userService.create(user)
    }

    @PutMapping("/{id}")
    fun modify(@PathVariable id: UUID, @RequestBody user: UserEntity): UserEntity {
        return userService.modify(id, user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): String {
        return userService.delete(id)
    }
}