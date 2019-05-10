package drdgvhbh.com.github.ethwallet.service

interface WalletFactory {
    suspend fun createWallet(password: String): Mnemonic
}