package org.example.hhpluscleanarchitecture.user.service

import org.example.hhpluscleanarchitecture.user.domain.User

interface UserRepository {
    fun findById(id: Long): User?
}