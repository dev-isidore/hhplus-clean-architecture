package org.example.hhpluscleanarchitecture.user.repository

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserEntity, Long>