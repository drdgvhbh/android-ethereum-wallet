package drdgvhbh.com.github.ethwallet

import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

private const val WALLET_CHANNEL = "drdgvhbh.com.ethwallet.wallet"

class MainActivity: FlutterActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)

    MethodChannel(flutterView, WALLET_CHANNEL).setMethodCallHandler{ call, result ->
      when(call.method) {
        "createWallet" -> result.success(Unit)
        else -> result.notImplemented()
      }
    }
  }
}
