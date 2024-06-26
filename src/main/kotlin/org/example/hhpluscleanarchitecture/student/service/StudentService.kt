package org.example.hhpluscleanarchitecture.student.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(@Autowired private val studentRepository: StudentRepository) {
    fun checkUserExists(id: Long): Boolean {
        return studentRepository.findById(id) != null
    }
}