package drdgvhbh.com.github.ethwallet.bridge

import drdgvhbh.com.github.ethwallet.service.WalletFactory
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import kotlinx.coroutines.*
import javax.inject.Named

class CreateWalletHandler(
        private val walletFactory: WalletFactory,
        @Named("Default") private val defaultDispatcher: CoroutineDispatcher
): MethodChannel.MethodCallHandler  {
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        val password = call.argument<String>("password")
                ?: return result.error("400", "Password is required", null)
        runBlocking {
            launch(defaultDispatcher) {
                val mnemonic = walletFactory.createWallet(password)
                result.success(mnemonic)
            }
        }
    }
}