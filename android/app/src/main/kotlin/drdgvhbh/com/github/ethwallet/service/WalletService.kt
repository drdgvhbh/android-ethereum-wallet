package drdgvhbh.com.github.ethwallet.service

import org.web3j.crypto.Bip39Wallet

interface WalletRepository {
    fun create(password: String): Bip39Wallet
}typealias Mnemonic = String

class WalletService(
        private val walletRepository: WalletRepository
) {
    fun createWallet(password: String): Mnemonic {
        return walletRepository.create(password).mnemonic
    }
}