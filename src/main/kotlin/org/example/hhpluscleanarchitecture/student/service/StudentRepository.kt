package org.example.hhpluscleanarchitecture.student.service

import org.example.hhpluscleanarchitecture.student.domain.Student

interface StudentRepository {
    fun findById(id: Long): Student?
}