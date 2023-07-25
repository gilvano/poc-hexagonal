package com.gbtech.pochexagonal.application.resquest

data class CreateLegalRequest(
    val name: String,
    val documentNumber: String,
    val email: String,
    val legalRepresentativeId: String
)
