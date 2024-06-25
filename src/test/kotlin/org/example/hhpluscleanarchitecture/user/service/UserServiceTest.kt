package org.example.hhpluscleanarchitecture.user.service

import org.assertj.core.api.Assertions.assertThat
import org.example.hhpluscleanarchitecture.user.domain.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class UserServiceTest {
    companion object {
        const val USER_ID : Long = 1
        const val USER_NAME = "John Doe"
        val USER = User(id = USER_ID, name = USER_NAME)
    }

    @Mock
    private lateinit var userRepository: UserRepository

    @InjectMocks
    private lateinit var userService: UserService

    @Test
    fun `유저가 있는 경우 true를 반환한다`() {
        `when`(userRepository.findById(eq(USER_ID))).thenReturn(USER)

        val result = userService.checkUserExists(USER_ID)

        assertThat(result).isTrue()
    }

    @Test
    fun `유저가 없는 경우 false를 반환한다`() {
        `when`(userRepository.findById(eq(USER_ID))).thenReturn(null)

        val result = userService.checkUserExists(USER_ID)

        assertThat(result).isFalse()
    }
}