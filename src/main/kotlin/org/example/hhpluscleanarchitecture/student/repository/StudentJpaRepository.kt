package org.example.hhpluscleanarchitecture.student.repository

import org.example.hhpluscleanarchitecture.student.repository.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRepository : JpaRepository<StudentEntity, Long>