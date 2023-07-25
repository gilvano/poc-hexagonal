package com.gbtech.pochexagonal.application.response

class CreateLegalResponse(
    val id: String,
    val name: String,
    val documentNumber: String,
    val email: String,
    val legalRepresentative: LegalRepresentativeResponse
)
