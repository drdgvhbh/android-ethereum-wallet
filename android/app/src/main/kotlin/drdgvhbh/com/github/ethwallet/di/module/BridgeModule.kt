package drdgvhbh.com.github.ethwallet.di.module

import dagger.Module
import dagger.Provides
import drdgvhbh.com.github.ethwallet.bridge.CreateWalletHandler
import drdgvhbh.com.github.ethwallet.service.WalletFactory
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named

@Module
class BridgeModule {
    @Provides
    fun provideCreateWalletHandler(
            walletFactory: WalletFactory,
            @Named("Default") defaultDispatcher: CoroutineDispatcher
    ) = CreateWalletHandler(walletFactory, defaultDispatcher)
}