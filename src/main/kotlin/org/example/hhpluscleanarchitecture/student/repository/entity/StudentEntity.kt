package org.example.hhpluscleanarchitecture.student.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.hhpluscleanarchitecture.student.domain.Student

@Entity(name = "student")
class StudentEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val name: String,
) {
    companion object {
        fun fromStudent(student: Student): StudentEntity {
            return StudentEntity(student.id, student.name)
        }
    }

    fun toDomain(): Student {
        return Student(id!!, name)
    }
}