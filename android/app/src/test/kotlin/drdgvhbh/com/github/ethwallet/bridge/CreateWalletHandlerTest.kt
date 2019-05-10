package drdgvhbh.com.github.ethwallet.bridge

import com.nhaarman.mockitokotlin2.*
import drdgvhbh.com.github.ethwallet.service.WalletFactory
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import org.junit.Before
import org.junit.Test

private const val password = "securePassword123"
private const val mnemonic = "neglect stay end angry track act garage donate tell annual wage pledge acid vibrant turn"


class CreateWalletHandlerTest {
    private lateinit var mockWalletFactory: WalletFactory

    private lateinit var methodChannelResult: MethodChannel.Result

    @Before
    fun init() {
        mockWalletFactory = mock {}
        methodChannelResult = mock {}
    }

    @Test
    fun `should respond with an error when password is not defined`() {
        val methodCall = MethodCall("createWallet", null)
        val createWalletHandler = CreateWalletHandler(mockWalletFactory)

        createWalletHandler.onMethodCall(methodCall, methodChannelResult)

        verify(methodChannelResult, times(1)).error(
                "400", "Password is required", null)
    }

    @Test
    fun `should respond with the wallet mnemonic upon success`() {
        val args = hashMapOf("password" to password)
        val methodCall = MethodCall("createWallet", args)
        val createWalletHandler = CreateWalletHandler(mockWalletFactory)
        given(mockWalletFactory.createWallet(password)).willReturn(mnemonic)

        createWalletHandler.onMethodCall(methodCall, methodChannelResult)

        verify(methodChannelResult, times(1)).success(mnemonic)


    }
}