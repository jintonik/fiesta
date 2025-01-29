package org.kotlin.fiesta.domain.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "USERS")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "ID") var id: UUID?,
    @Column(name = "USERNAME") var username: String,
    @Column(name = "PASSWORD") var pass: String,
    @Enumerated(EnumType.STRING) @Column(name = "ROLE") var role: Role
)