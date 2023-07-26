package com.gbtech.pochexagonal.domain.entity

data class Legal(
    val id: String,
    val name: String,
    val documentNumber: String,
    val email: String,
    val legalRepresentative: LegalRepresentative
)
