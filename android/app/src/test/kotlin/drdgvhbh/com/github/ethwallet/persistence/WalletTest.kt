package drdgvhbh.com.github.ethwallet.persistence

import android.content.Context
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.web3j.crypto.Bip39Wallet
import java.io.File

private const val password = "securePassword123"

class Bip44WalletRepositoryTests {
    @Test
    fun `create should generate a wallet in the context files directory`() {
        val directoryStub = "drdgvhbh.com.github.ethwallet.files"
        val fileStub = File(directoryStub)
        val mockContext = mock<Context> {
            given(mock.filesDir).willReturn(fileStub)
        }
        val wallet = mock<Bip39Wallet> {}
        val mockGenerator = mock<WalletGenerator> {
            given(mock.generateWallet(password, fileStub)).willReturn(wallet)
        }

        val repository = Bip44WalletRepository(mockContext, mockGenerator)
        val createdWallet = repository.create(password)

        verify(mockContext, atLeastOnce()).filesDir
        verify(mockGenerator, atLeastOnce()).generateWallet(password, fileStub)
        assertThat(createdWallet).isEqualTo(wallet)
    }
}

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