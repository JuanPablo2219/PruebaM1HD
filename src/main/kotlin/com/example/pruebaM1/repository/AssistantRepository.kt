package com.example.pruebaM1.repository

import com.example.pruebaM1.model.Assistant
import com.example.pruebaM1.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssistantRepository : JpaRepository<Assistant, Long?> {

    fun findById (id: Long?): Assistant?
}

