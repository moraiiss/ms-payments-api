package com.study.payments.seller.unit

import com.study.payments.seller.Seller
import com.study.payments.seller.SellerRepository
import com.study.payments.seller.SellerRequestDto
import com.study.payments.seller.SellerService
import com.study.payments.seller.mock.mock
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

class SellerServiceTest {
    private lateinit var repository: SellerRepository
    private lateinit var service: SellerService

    @BeforeEach
    fun setUp() {
        repository = mockk()
        service = SellerService(repository)
    }

    @Test
    fun `should return a paginated seller list`() {
        val pageable = mockk<Pageable>()
        val expected = mockk<Page<Seller>>()

        every { repository.findAllPaginate(pageable) } returns expected

        val actual = service.getAllSellers(pageable)

        assertThat(actual)
            .isNotNull()
            .isEqualTo(expected)

        verify(exactly = 1) { repository.findAllPaginate(pageable) }
    }

    @Test
    fun `should return a seller details when the ID is passed`() {
        val sellerId = "123e4567-e89b-12d3-a456-426614174000"
        val expected = Seller.mock()

        every { repository.findById(sellerId) } returns expected

        val actual = service.getSellerDetails(sellerId)

        assertThat(actual)
            .isNotNull()
            .isEqualTo(expected.get())

        verify(exactly = 1) { repository.findById(sellerId) }
    }

    @Test
    fun `should return exception when seller not found`() {
        every { repository.findById("") } returns Optional.empty()

        val exception = assertThrows<NoSuchElementException> {
            service.getSellerDetails("")
        }

        assertThat(exception)
            .isInstanceOf(NoSuchElementException::class.java)

        assertThat(exception.message)
            .isEqualTo("No value present")

        verify(exactly = 1) { repository.findById("") }
    }

    @Test
    fun `should create a new seller successfully`() {
        val dto = SellerRequestDto.mock()
        val seller = Seller.mock().get()

        every { repository.save(any()) } returns seller

        val actual = service.createSeller(dto)

        assertThat(actual)
            .isEqualTo(seller)

        verify(exactly = 1) { repository.save(any()) }
    }
}