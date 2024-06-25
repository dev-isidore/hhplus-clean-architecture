package org.example.hhpluscleanarchitecture.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) {
    fun checkUserExists(id: Long): Boolean {
        return userRepository.findById(id) != null
    }
}