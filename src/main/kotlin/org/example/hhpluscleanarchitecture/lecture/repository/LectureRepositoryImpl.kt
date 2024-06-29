package org.example.hhpluscleanarchitecture.lecture.repository

import org.example.hhpluscleanarchitecture.lecture.domain.Lecture
import org.example.hhpluscleanarchitecture.lecture.service.LectureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class LectureRepositoryImpl(@Autowired private val lectureJpaRepository: LectureJpaRepository) : LectureRepository {

    override fun findByIdAndScheduleId(id: Long, scheduleId: Long): Lecture? {
        return lectureJpaRepository.findByIdAndLectureSchedules_Id(id, scheduleId)?.toDomain()
    }
}