package org.example.hhpluscleanarchitecture.lecture.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.example.hhpluscleanarchitecture.lecture.domain.Schedule
import java.time.LocalDate

@Entity(name = "schedule")
class ScheduleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false, unique = true)
    val date: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "lecture_id",
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT, name = "none")
    )
    val lectureEntity: LectureEntity?,
) {
    companion object {
        fun fromSchedule(schedule: Schedule): ScheduleEntity {
            return ScheduleEntity(
                schedule.id,
                schedule.date,
                null
            )
        }
    }

    fun toDomain(): Schedule = Schedule(id!!, date)
}