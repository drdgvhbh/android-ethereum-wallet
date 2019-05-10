package drdgvhbh.com.github.ethwallet.persistence

import android.content.Context
import drdgvhbh.com.github.ethwallet.service.WalletRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.web3j.crypto.Bip39Wallet
import javax.inject.Named

class Bip44WalletRepository(
        private val context: Context,
        private val walletGenerator: WalletGenerator,
        private val dispatcher: CoroutineDispatcher
) : WalletRepository {
    override suspend fun create(password: String): Bip39Wallet {
        return withContext(dispatcher) {
            walletGenerator.generateWallet(password, context.filesDir)
        }
    }
}