import 'package:ethwallet/wallet_service.dart';
import 'package:kiwi/kiwi.dart';

part 'bridge_module.g.dart';

abstract class BridgeInjector {
  @Register.singleton(WalletService)
  void configure();
}

void setup() {
  var injector = _$BridgeInjector();
  injector.configure();
}
