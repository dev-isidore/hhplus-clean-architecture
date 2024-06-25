package org.example.hhpluscleanarchitecture.user.repository

import org.example.hhpluscleanarchitecture.user.domain.User
import org.example.hhpluscleanarchitecture.user.service.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class UserRepositoryImpl(@Autowired private val userJpaRepository: UserJpaRepository): UserRepository {
    override fun findById(id: Long): User? {
        return userJpaRepository.findById(id).getOrNull()?.toDomainModel()
    }
}