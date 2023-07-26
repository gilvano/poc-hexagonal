package com.gbtech.pochexagonal.application.repository

import com.gbtech.pochexagonal.domain.entity.Legal

interface LegalRepository {
    fun save(legal: Legal): Legal

}
