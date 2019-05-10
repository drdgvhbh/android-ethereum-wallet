package drdgvhbh.com.github.ethwallet

import android.os.Bundle
import dagger.android.AndroidInjection
import drdgvhbh.com.github.ethwallet.bridge.CreateWalletHandler
import drdgvhbh.com.github.ethwallet.service.WalletService

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import javax.inject.Inject

private const val WALLET_CHANNEL = "drdgvhbh.com.ethwallet.wallet"

class MainActivity: FlutterActivity() {
  @Inject
  lateinit var createWalletHandler: CreateWalletHandler

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)
    AndroidInjection.inject(this)

    MethodChannel(flutterView, WALLET_CHANNEL).setMethodCallHandler{ call, result ->
      when(call.method) {
        "createWallet" -> createWalletHandler.onMethodCall(call, result)
        else -> result.notImplemented()
      }
    }
  }
}
