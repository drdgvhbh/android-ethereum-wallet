package drdgvhbh.com.github.ethwallet.persistence

import org.web3j.crypto.Bip39Wallet
import java.io.File

interface WalletGenerator {
    fun generateWallet(password: String, dir: File): Bip39Wallet;
}

