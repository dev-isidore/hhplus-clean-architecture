package org.example.hhpluscleanarchitecture.lecture.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.example.hhpluscleanarchitecture.lecture.domain.Lecture

@Entity(name = "lecture")
class LectureEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val maximumNumberOfParticipants: Int,

    @OneToMany(mappedBy = "lectureEntity")
    val lectureSchedules: List<ScheduleEntity> = mutableListOf(),
) {
    companion object {
        fun fromLecture(lecture: Lecture): LectureEntity {
            return LectureEntity(
                lecture.id,
                lecture.maximumNumberOfParticipants,
                lecture.schedules.map { ScheduleEntity.fromSchedule(it) }
            )
        }
    }

    fun toDomain(): Lecture {
        return Lecture(
            id!!,
            maximumNumberOfParticipants,
            lectureSchedules.map { it.toDomain() })
    }
}