package org.example.hhpluscleanarchitecture.lecture.domain

import org.example.hhpluscleanarchitecture.student.domain.Student

class LectureApplication(
    val id: Long?,
    val student: Student,
    val lecture: Lecture?,
    val schedule: Schedule,
) {
    constructor(student: Student, schedule: Schedule) : this(null, student, null, schedule)
    constructor(student: Student, lecture: Lecture, schedule: Schedule) : this(null, student, lecture, schedule)
}