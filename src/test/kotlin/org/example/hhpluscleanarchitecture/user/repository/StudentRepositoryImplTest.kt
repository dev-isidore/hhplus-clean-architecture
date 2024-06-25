package org.example.hhpluscleanarchitecture.user.repository

import org.assertj.core.api.Assertions.assertThat
import org.example.hhpluscleanarchitecture.student.domain.Student
import org.example.hhpluscleanarchitecture.student.repository.StudentEntity
import org.example.hhpluscleanarchitecture.student.repository.StudentJpaRepository
import org.example.hhpluscleanarchitecture.student.repository.StudentRepositoryImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.eq
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class StudentRepositoryImplTest {

    companion object {
        const val USER_ID : Long = 1
        const val USER_NAME = "John Doe"
        val USER_ENTITY = StudentEntity(USER_ID, USER_NAME)
        val Student = Student(id = USER_ID, name = USER_NAME)
    }

    @Mock
    private lateinit var studentJpaRepository: StudentJpaRepository

    @InjectMocks
    private lateinit var studentRepositoryImpl: StudentRepositoryImpl

    @Test
    fun `응답한 결과가 존재하면 도메인 객체로 전환하여 반환한다`() {
        `when`(studentJpaRepository.findById(eq(USER_ID))).thenReturn(Optional.of(USER_ENTITY))

        val result = studentRepositoryImpl.findById(USER_ID)

        assertThat(result!!).usingRecursiveComparison().isEqualTo(Student)
    }

    @Test
    fun `응답한 결과가 존재하지 않으면 null을 반환한다`() {
        `when`(studentJpaRepository.findById(eq(USER_ID))).thenReturn(Optional.empty())

        val result = studentRepositoryImpl.findById(USER_ID)

        assertThat(result).isNull()
    }
}