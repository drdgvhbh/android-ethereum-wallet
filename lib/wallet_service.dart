import 'dart:collection';

import 'package:flutter/services.dart';

MethodChannel walletChannel =
    const MethodChannel('drdgvhbh.com.ethwallet.wallet');

class WalletService {
  Stream<String> createWallet(String password) {
    return walletChannel
        .invokeMethod<String>('createWallet',
            HashMap.fromEntries([MapEntry("password", password)]))
        .asStream();
  }
}
