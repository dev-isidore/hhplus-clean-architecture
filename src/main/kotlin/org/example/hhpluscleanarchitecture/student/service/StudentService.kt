package org.example.hhpluscleanarchitecture.student.service

import org.example.hhpluscleanarchitecture.student.domain.Student
import org.example.hhpluscleanarchitecture.student.exception.StudentNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(@Autowired private val studentRepository: StudentRepository) {
    fun checkUserExists(id: Long): Boolean {
        return studentRepository.findById(id) != null
    }

    fun getStudent(id: Long): Student {
        return studentRepository.findById(id) ?: throw StudentNotFoundException("student:$id not found")
    }
}