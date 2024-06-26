package org.example.hhpluscleanarchitecture.user.service

import org.assertj.core.api.Assertions.assertThat
import org.example.hhpluscleanarchitecture.student.domain.Student
import org.example.hhpluscleanarchitecture.student.service.StudentRepository
import org.example.hhpluscleanarchitecture.student.service.StudentService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class StudentServiceTest {
    companion object {
        const val USER_ID : Long = 1
        const val USER_NAME = "John Doe"
        val Student = Student(id = USER_ID, name = USER_NAME)
    }

    @Mock
    private lateinit var studentRepository: StudentRepository

    @InjectMocks
    private lateinit var studentService: StudentService

    @Test
    fun `유저가 있는 경우 true를 반환한다`() {
        `when`(studentRepository.findById(eq(USER_ID))).thenReturn(Student)

        val result = studentService.checkUserExists(USER_ID)

        assertThat(result).isTrue()
    }

    @Test
    fun `유저가 없는 경우 false를 반환한다`() {
        `when`(studentRepository.findById(eq(USER_ID))).thenReturn(null)

        val result = studentService.checkUserExists(USER_ID)

        assertThat(result).isFalse()
    }
}