package org.example.hhpluscleanarchitecture.lecture.repository.entity

import jakarta.persistence.ConstraintMode
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import org.example.hhpluscleanarchitecture.lecture.domain.LectureApplication
import org.example.hhpluscleanarchitecture.student.repository.entity.StudentEntity

@Entity(name = "lecture_application")
class LectureApplicationEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "student_id",
        nullable = false,
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT, name = "none")
    )
    val studentEntity: StudentEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "lecture_id",
        nullable = false,
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT, name = "none")
    )
    val lectureEntity: LectureEntity?,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "schedule_id",
        nullable = false,
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT, name = "none")
    )
    val scheduleEntity: ScheduleEntity,
) {
    companion object {
        fun fromLectureApplication(lectureApplication: LectureApplication): LectureApplicationEntity {
            return LectureApplicationEntity(
                lectureApplication.id,
                StudentEntity.fromStudent(lectureApplication.student),
                null,
                ScheduleEntity.fromSchedule(lectureApplication.schedule)
            )
        }
    }

    fun toDomain(lectureEntity: LectureEntity): LectureApplication {
        return LectureApplication(
            id!!,
            studentEntity.toDomain(),
            null,
            scheduleEntity.toDomain()
        )
    }
}