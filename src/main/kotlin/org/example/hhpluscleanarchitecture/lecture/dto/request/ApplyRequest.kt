package org.example.hhpluscleanarchitecture.lecture.dto.request

data class ApplyRequest(
    val studentId: Long,
    val lectureId: Long,
    val scheduleId: Long,
) {

}