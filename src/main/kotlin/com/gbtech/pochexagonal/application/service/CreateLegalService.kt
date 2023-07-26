package com.gbtech.pochexagonal.application.service

import com.gbtech.pochexagonal.application.repository.LegalRepository
import com.gbtech.pochexagonal.application.repository.LegalRepresentativeRepository
import com.gbtech.pochexagonal.application.response.CreateLegalResponse
import com.gbtech.pochexagonal.application.response.LegalRepresentativeResponse
import com.gbtech.pochexagonal.application.resquest.CreateLegalRequest
import com.gbtech.pochexagonal.domain.entity.Legal
import com.gbtech.pochexagonal.domain.entity.LegalRepresentative

class CreateLegalService(
    private val legalRepository: LegalRepository,
    private val legalRepresentativeRepository: LegalRepresentativeRepository
) {
    fun create(createLegalRequest: CreateLegalRequest): CreateLegalResponse {
        val legalRepresentative = findLegalRepresentativeById(createLegalRequest.legalRepresentativeId)
        TODO()
//        return legalRepository.save(createLegalRequest.toLegal(legalRepresentative))
//            .let { CreateLegalResponse(it) }
    }

    private fun findLegalRepresentativeById(legalRepresentativeId: String) =
        legalRepresentativeRepository.findById(legalRepresentativeId)
            ?: throw Exception("Legal representative not found")
}
