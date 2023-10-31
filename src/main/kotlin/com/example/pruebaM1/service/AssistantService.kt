package com.example.pruebaM1.service

import com.example.pruebaM1.model.Assistant
import com.example.pruebaM1.repository.AssistantRepository
import com.example.pruebaM1.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AssistantService {
    @Autowired
    lateinit var assistantRepository: AssistantRepository

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository


    fun list ():List<Assistant>{
        return assistantRepository.findAll()
    }

    fun save(assistant: Assistant): Assistant {
        try{
            conferenceRepository.findById(assistant.conferenceId)
                ?: throw Exception("Id del cliente no encontrada")
            return assistantRepository.save(assistant)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(assistant: Assistant): Assistant{
        try {
            assistantRepository.findById(assistant.id)
                ?: throw Exception("ID no existe")

            return assistantRepository.save(assistant)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(assistant: Assistant): Assistant{
        try{
            val response = assistantRepository.findById(assistant.id)
                ?: throw Exception("ID no existe")
            response.apply {
                fullName=assistant.fullName
            }
            return assistantRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = assistantRepository.findById(id)
                ?: throw Exception("ID no existe")
            assistantRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Assistant?{
        return assistantRepository.findById(id)
    }
}

