package drdgvhbh.com.github.ethwallet.bridge

import drdgvhbh.com.github.ethwallet.service.WalletFactory
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class CreateWalletHandler(
        private val walletFactory: WalletFactory
): MethodChannel.MethodCallHandler  {
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        val password = call.argument<String>("password")
                ?: return result.error("400", "Password is required", null)
        val mnemonic = walletFactory.createWallet(password)
        result.success(mnemonic)
    }
}