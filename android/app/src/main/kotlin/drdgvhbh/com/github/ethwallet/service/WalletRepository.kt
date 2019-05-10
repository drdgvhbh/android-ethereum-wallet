package drdgvhbh.com.github.ethwallet.service

import org.web3j.crypto.Bip39Wallet

interface WalletRepository {
    suspend fun create(password: String): Bip39Wallet
}