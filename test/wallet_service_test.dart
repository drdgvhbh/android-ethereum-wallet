import 'package:ethwallet/wallet_service.dart';
import 'package:flutter/services.dart';
import 'package:test/test.dart';
import 'package:mockito/mockito.dart';

abstract class MethodCallHandler {
  Future<dynamic> handle(MethodCall call);
}

class MockMethodCallHandler extends Mock implements MethodCallHandler {}

void main() {
  test("adds a wallet using the add wallet method channel", () {
    final repo = new WalletService();
    final walletChannel = const MethodChannel('drdgvhbh.com.ethwallet.wallet');
    final mock = new MockMethodCallHandler();
    walletChannel.setMockMethodCallHandler(mock.handle);

    final password = "myPassword";
    logInvocations([mock]);
    when(mock.handle(argThat(new TypeMatcher<MethodCall>())))
        .thenAnswer((something) async {
      final methodCall = something.positionalArguments[0] as MethodCall;
      expect(
          methodCall.method,
          equals(
            'createWallet',
          ));
      expect(methodCall.arguments, equals(password));
      return Future.value('Stub');
    });
    repo.createWallet(password).listen(expectAsync1((_) {
          verify(mock.handle(any)).called(1);
        }, count: 1));
  });
}
