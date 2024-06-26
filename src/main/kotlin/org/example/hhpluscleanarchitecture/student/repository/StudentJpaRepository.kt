package org.example.hhpluscleanarchitecture.student.repository

import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRepository : JpaRepository<StudentEntity, Long>