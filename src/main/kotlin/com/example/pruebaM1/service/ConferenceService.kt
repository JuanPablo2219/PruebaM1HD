package com.example.pruebaM1.service

import com.example.pruebaM1.model.Conference
import com.example.pruebaM1.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list(): List<Conference> {
        return conferenceRepository.findAll()
    }

    fun save(conference: Conference): Conference {
        try {
            return conferenceRepository.save(conference)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(conference: Conference): Conference{
        try {
            conferenceRepository.findById(conference.id)
                ?: throw Exception("ID no existe")

            return conferenceRepository.save(conference)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(conference: Conference): Conference {
        //try {
        conferenceRepository.findById(conference.id)
            ?: throw Exception("ID no existe")
        return conferenceRepository.save(conference)
        //} catch (ex: Exception) {
        //   throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        //  }
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = conferenceRepository.findById(id)
                ?: throw Exception("ID no existe")
            conferenceRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Conference? {
        return conferenceRepository.findById(id)
    }
}