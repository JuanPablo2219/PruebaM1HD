package com.example.pruebaM1.repository

import com.example.pruebaM1.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository : JpaRepository<Conference, Long?> {

    fun findById (id: Long?): Conference?
}