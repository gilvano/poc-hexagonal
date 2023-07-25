package com.gbtech.pochexagonal.application.repository

import com.gbtech.pochexagonal.domain.entity.LegalRepresentative

interface LegalRepresentativeRepository {
    fun findById(id: String): LegalRepresentative?
}
