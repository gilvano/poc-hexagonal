package com.gbtech.pochexagonal.application

import assertk.assertThat
import assertk.assertions.isNotNull
import com.gbtech.pochexagonal.application.repository.LegalRepresentativeRepository
import com.gbtech.pochexagonal.application.resquest.CreateLegalRequest
import com.gbtech.pochexagonal.application.service.CreateLegalService
import com.gbtech.pochexagonal.domain.entity.LegalRepresentative
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateLegalServiceTest {

    private val legalRepresentativeRepository = mockk<LegalRepresentativeRepository>()

    private val createLegalService = CreateLegalService(legalRepresentativeRepository)

    @Test
    fun `should throw an exception when legal representative is not found`() {
        // given
        val createLegalRequest = CreateLegalRequest(
            name = "Valid name",
            documentNumber = "Valid documentNumber",
            email = "Valid email",
            legalRepresentativeId = "Invalid legalRepresentativeId"
        )
        every { legalRepresentativeRepository.findById(any()) } returns null

        // when
        val exception = assertThrows<Exception> {
            createLegalService.create(createLegalRequest)
        }

        // then
        assertEquals("Legal representative not found", exception.message)
        verify(exactly = 1) { legalRepresentativeRepository.findById("Invalid legalRepresentativeId") }
    }

    @Test
    fun `should save legal without exception`() {
        // given
        val createLegalRequest = CreateLegalRequest(
            name = "Valid name",
            documentNumber = "Valid documentNumber",
            email = "Valid email",
            legalRepresentativeId = "Valid legalRepresentativeId"
        )

        val legalRepresentative = LegalRepresentative(
            id = "Valid legalRepresentativeId",
            name = "Valid name",
            documentNumber = "Valid documentNumber"
        )

        every { legalRepresentativeRepository.findById(any()) } returns legalRepresentative
        // when
        val response = createLegalService.create(createLegalRequest)

        // then
        assertThat(response).isNotNull()
        assertEquals("Valid id", response.id)
        assertEquals("Valid name", response.name)
        assertEquals("Valid documentNumber", response.documentNumber)
        assertEquals("Valid email", response.email)
        assertEquals("Valid legalRepresentativeId", response.legalRepresentative.id)
        verify { legalRepresentativeRepository.findById("Valid legalRepresentativeId") }
    }
}