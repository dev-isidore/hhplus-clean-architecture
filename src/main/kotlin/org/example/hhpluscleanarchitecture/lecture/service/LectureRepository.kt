package org.example.hhpluscleanarchitecture.lecture.service

import org.example.hhpluscleanarchitecture.lecture.domain.Lecture

interface LectureRepository {
    fun findByIdAndScheduleId(id: Long, scheduleId: Long): Lecture?
}