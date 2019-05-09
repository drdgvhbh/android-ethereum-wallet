package drdgvhbh.com.github.ethwallet.service

interface WalletFactory {
    fun createWallet(password: String): Mnemonic
}