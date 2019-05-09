package drdgvhbh.com.github.ethwallet

import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
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
        "createWallet" -> result.success(Unit)
        else -> result.notImplemented()
      }
    }
  }
}
