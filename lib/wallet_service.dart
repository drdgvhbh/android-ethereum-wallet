import 'package:flutter/services.dart';

MethodChannel walletChannel =
    const MethodChannel('drdgvhbh.com.ethwallet.wallet');

class WalletService {
  Stream<void> createWallet(String password) {
    return walletChannel.invokeMethod('createWallet', password).asStream();
  }
}
