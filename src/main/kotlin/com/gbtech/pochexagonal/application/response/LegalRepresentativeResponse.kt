package com.gbtech.pochexagonal.application.response

import com.gbtech.pochexagonal.domain.entity.LegalRepresentative

data class LegalRepresentativeResponse(
    val id: String,
    val name: String,
    val documentNumber: String
) {
    constructor(legalRepresentative: LegalRepresentative) : this(
        id = legalRepresentative.id,
        name = legalRepresentative.name,
        documentNumber = legalRepresentative.documentNumber
    )
}
