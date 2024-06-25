package org.example.hhpluscleanarchitecture.user.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.hhpluscleanarchitecture.user.domain.User

@Entity(name = "user")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    @Column(nullable = false) var name: String,
) {
    companion object {
        fun fromUser(user: User): UserEntity {
            return UserEntity(user.id, user.name)
        }
    }

    fun toDomainModel(): User {
        return User(id, name)
    }
}