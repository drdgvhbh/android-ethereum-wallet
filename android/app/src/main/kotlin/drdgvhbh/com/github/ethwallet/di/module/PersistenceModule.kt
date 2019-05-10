package drdgvhbh.com.github.ethwallet.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import drdgvhbh.com.github.ethwallet.di.context.ApplicationContext
import drdgvhbh.com.github.ethwallet.persistence.*
import drdgvhbh.com.github.ethwallet.service.WalletFactory
import drdgvhbh.com.github.ethwallet.service.WalletRepository
import drdgvhbh.com.github.ethwallet.service.WalletService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

@Module
class PersistenceModule {
    @Provides
    @Singleton
    fun provideWalletGenerator(): WalletGenerator = Bip44WalletGenerator()

    @Provides
    @Singleton
    fun provideWalletRepository(
            @ApplicationContext context: Context,
            walletGenerator: WalletGenerator,
            @Named("IO") dispatcher: CoroutineDispatcher
    ): WalletRepository = Bip44WalletRepository(context, walletGenerator, dispatcher)

    @Provides
    @Singleton
    fun provideWalletService(
            walletRepository: WalletRepository
    ) = WalletService(walletRepository)

    @Provides
    @Singleton
    fun provideWalletFactory(
            walletService: WalletService
    ): WalletFactory = walletService
}