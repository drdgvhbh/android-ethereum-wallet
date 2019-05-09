package drdgvhbh.com.github.ethwallet.persistence

import org.web3j.crypto.Bip39Wallet
import org.web3j.crypto.Bip44WalletUtils
import java.io.File

class Bip44WalletGenerator : WalletGenerator {
    override fun generateWallet(password: String, dir: File): Bip39Wallet =
            Bip44WalletUtils.generateBip44Wallet(password, dir)
}