package org.example.hhpluscleanarchitecture.lecture.controller

import org.example.hhpluscleanarchitecture.lecture.dto.request.ApplyRequest
import org.example.hhpluscleanarchitecture.lecture.dto.response.ApplyResponse
import org.example.hhpluscleanarchitecture.lecture.service.LectureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(
    @Autowired private val lectureService: LectureService
) {
    @PostMapping("lectures/apply")
    fun applyLecture(@RequestBody applyRequest: ApplyRequest): ApplyResponse {
//        val lectureApplication =
//            lectureService.signIn(applyRequest.studentId, applyRequest.lectureId, applyRequest.scheduleId)
        return ApplyResponse()
    }

    @GetMapping("lectures")
    fun test(): String {
        return "OK"
    }
}