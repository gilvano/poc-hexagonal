package com.gbtech.pochexagonal.application.service

import com.gbtech.pochexagonal.application.repository.LegalRepresentativeRepository
import com.gbtech.pochexagonal.application.response.CreateLegalResponse
import com.gbtech.pochexagonal.application.response.LegalRepresentativeResponse
import com.gbtech.pochexagonal.application.resquest.CreateLegalRequest
import com.gbtech.pochexagonal.domain.entity.LegalRepresentative

class CreateLegalService(
    private val legalRepresentativeRepository: LegalRepresentativeRepository
) {
    fun create(createLegalRequest: CreateLegalRequest): CreateLegalResponse {
        val legalRepresentative = findLegalRepresentativeById(createLegalRequest.legalRepresentativeId)
        return CreateLegalResponse(
            id = "Valid id",
            name = createLegalRequest.name,
            documentNumber = createLegalRequest.documentNumber,
            email = createLegalRequest.email,
            legalRepresentative = LegalRepresentativeResponse(
                id = legalRepresentative.id,
                name = legalRepresentative.name,
                documentNumber = legalRepresentative.documentNumber
            )
        )
    }

    private fun findLegalRepresentativeById(legalRepresentativeId: String) =
        legalRepresentativeRepository.findById(legalRepresentativeId)
            ?: throw Exception("Legal representative not found")
}
