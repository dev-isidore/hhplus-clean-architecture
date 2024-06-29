package org.example.hhpluscleanarchitecture.lecture.domain

class Lecture(
    val id: Long,
    val maximumNumberOfParticipants: Int,
    val schedules: List<Schedule> = mutableListOf(),
)