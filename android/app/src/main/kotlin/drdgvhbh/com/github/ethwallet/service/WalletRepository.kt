package drdgvhbh.com.github.ethwallet.service

import org.web3j.crypto.Bip39Wallet

interface WalletRepository {
    fun create(password: String): Bip39Wallet
}