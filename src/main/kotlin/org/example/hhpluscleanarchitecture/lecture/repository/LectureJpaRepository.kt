package org.example.hhpluscleanarchitecture.lecture.repository

import org.example.hhpluscleanarchitecture.lecture.repository.entity.LectureEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LectureJpaRepository : JpaRepository<LectureEntity, Long> {
    fun findByIdAndLectureSchedules_Id(id: Long, scheduleId: Long): LectureEntity?
}