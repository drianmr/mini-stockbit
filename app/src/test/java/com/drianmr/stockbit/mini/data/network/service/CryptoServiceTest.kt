package com.drianmr.stockbit.mini.data.network.service

import com.drianmr.stockbit.mini.data.network.response.BaseResponse
import com.drianmr.stockbit.mini.model.Coin
import com.drianmr.stockbit.mini.model.CoinInfo
import com.drianmr.stockbit.mini.model.CoinRaw
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CryptoServiceTest {

    @MockK
    lateinit var cryptoService: CryptoService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `Test successful fetch list crypto`() = runBlockingTest {
        val response = createSuccessResponse()
        val params = mapOf("limit" to "50", "page" to "0")

        coEvery { cryptoService.listCrypto(params) } returns response
        val result = cryptoService.listCrypto(params)

        assertThat(result).isEqualTo(response)

        coVerify { cryptoService.listCrypto(params) }
        confirmVerified(cryptoService)
    }

    private fun createSuccessResponse(): BaseResponse =
        BaseResponse(
            message = "success",
            data = listOf(
                Coin(
                    info = CoinInfo("1", "ETH", "Ethereum"),
                    raw = CoinRaw(
                        idr = CoinRaw.Idr(92_151f, 122f)
                    )
                )
            )
        )
}
