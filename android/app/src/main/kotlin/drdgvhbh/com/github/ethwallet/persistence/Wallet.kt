package drdgvhbh.com.github.ethwallet.persistence

import android.content.Context
import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.Bip44WalletUtils
import java.io.File

interface WalletGenerator {
    fun generateWallet(password: String, dir: File): Bip39Wallet;
}

class Bip44WalletGenerator : WalletGenerator {
    override fun generateWallet(password: String, dir: File): Bip39Wallet =
            Bip44WalletUtils.generateBip44Wallet(password, dir)
}

interface WalletRepository {
    fun create(password: String): Bip39Wallet
}

class Bip44WalletRepository(
        private val context: Context,
        private val walletGenerator: WalletGenerator
) : WalletRepository {
    override fun create(password: String): Bip39Wallet {
        return walletGenerator.generateWallet(password, context.filesDir)
    }
}

typealias Mnemonic = String

class WalletService(
        private val walletRepository: WalletRepository
) {
    fun createWallet(password: String): Mnemonic {
        return walletRepository.create(password).mnemonic
    }
}