package drdgvhbh.com.github.ethwallet.persistence

import android.content.Context
import drdgvhbh.com.github.ethwallet.service.WalletRepository
import org.web3j.crypto.Bip39Wallet

class Bip44WalletRepository(
        private val context: Context,
        private val walletGenerator: WalletGenerator
) : WalletRepository {
    override fun create(password: String): Bip39Wallet {
        return walletGenerator.generateWallet(password, context.filesDir)
    }
}