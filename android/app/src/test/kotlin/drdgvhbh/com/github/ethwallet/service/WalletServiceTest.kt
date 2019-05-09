package drdgvhbh.com.github.ethwallet.service

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.web3j.crypto.Bip39Wallet

private const val password = "securePassword123"

class WalletServiceTest {
    @Test
    fun `should create a wallet with a mnemonic`() {
        val mnemonic = "neglect stay end angry track act garage donate tell annual wage pledge acid vibrant turn"
        val mockWallet = mock<Bip39Wallet> {
            given(mock.mnemonic).willReturn(mnemonic)
        }
        val mockWalletRepository = mock<WalletRepository> {
            given(mock.create(password)).willReturn(mockWallet)
        }

        val walletService = WalletService(mockWalletRepository)

        assertThat(walletService.createWallet(password)).isEqualTo(mnemonic)
    }
}