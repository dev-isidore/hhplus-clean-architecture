package org.example.hhpluscleanarchitecture.lecture.service

import org.example.hhpluscleanarchitecture.student.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LectureService(
    @Autowired private val lectureRepository: LectureRepository,
    @Autowired private val studentService: StudentService,
) {
//    @Transactional
//    fun signIn(studentId: Long, lectureId: Long, scheduleId: Long): LectureApplication {
//        val student = studentService.getStudent(studentId)
//        val lecture = lectureRepository.findByIdAndScheduleId(lectureId, scheduleId)
//            ?: throw LectureNotFoundException("lecture:$lectureId scheduleId:$scheduleId not found")
//
//        val lectureApplication = lecture.signin(student, scheduleId)
//
//        lectureRepository.save(lecture)
//
//        return lectureApplication
//    }
}