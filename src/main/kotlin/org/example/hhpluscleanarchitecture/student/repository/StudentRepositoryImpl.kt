package org.example.hhpluscleanarchitecture.student.repository

import org.example.hhpluscleanarchitecture.student.domain.Student
import org.example.hhpluscleanarchitecture.student.service.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class StudentRepositoryImpl(@Autowired private val studentJpaRepository: StudentJpaRepository): StudentRepository {
    override fun findById(id: Long): Student? {
        return studentJpaRepository.findById(id).getOrNull()?.toDomainModel()
    }
}