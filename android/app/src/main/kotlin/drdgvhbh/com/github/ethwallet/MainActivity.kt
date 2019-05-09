package drdgvhbh.com.github.ethwallet

import android.os.Bundle
import dagger.android.AndroidInjection
import drdgvhbh.com.github.ethwallet.persistence.WalletService

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import javax.inject.Inject

private const val WALLET_CHANNEL = "drdgvhbh.com.ethwallet.wallet"

class MainActivity: FlutterActivity() {
  @Inject
  lateinit var walletService: WalletService

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)
    AndroidInjection.inject(this)

    MethodChannel(flutterView, WALLET_CHANNEL).setMethodCallHandler{ call, result ->
      when(call.method) {
        "createWallet" -> {
          val password = call.argument<String>("password")
                  ?: return@setMethodCallHandler result.error("400", "Password is required", null)
          val mnemonic = walletService.createWallet(password)
          result.success(mnemonic)
        }
        else -> result.notImplemented()
      }
    }
  }
}
