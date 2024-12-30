package com.study.payments.seller.unit

import com.study.payments.seller.Seller
import com.study.payments.seller.SellerRepository
import com.study.payments.seller.mock.mock
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

class SellerRepositoryTest {
    private lateinit var repository: SellerRepository

    @BeforeEach
    fun setUp() {
        repository = mockk()
    }

    @Test
    fun `should return a seller when registered with successfully`() {
        val seller = mockk<Seller>()

         every { repository.save(seller) } returns seller

        val actual = repository.save(seller)

        assertThat(actual)
            .isNotNull()
            .isEqualTo(seller)

        verify { repository.save(any()) }
    }

    @Test
    fun `should return paginated seller list`() {
        val pageable = mockk<Pageable>()
        val expected = mockk<Page<Seller>>()

        every { repository.findAllPaginate(pageable) } returns expected

        val actual = repository.findAllPaginate(pageable)

        assertThat(actual)
            .isNotNull()
            .isEqualTo(expected)

        verify(exactly = 1) { repository.findAllPaginate(pageable) }
    }

    @Test
    fun `should return a seller details by id`() {
        val sellerId = "123e4567-e89b-12d3-a456-426614174000"
        val expected = Seller.mock()

        every { repository.findById(sellerId) } returns expected

        val actual = repository.findById(sellerId)

        assertThat(actual)
            .isNotNull()
            .isEqualTo(expected)

        verify(exactly = 1) { repository.findById(sellerId) }
    }
}