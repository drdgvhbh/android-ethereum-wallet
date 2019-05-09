package drdgvhbh.com.github.ethwallet.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import drdgvhbh.com.github.ethwallet.di.context.ApplicationContext
import drdgvhbh.com.github.ethwallet.persistence.*
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
            walletGenerator: WalletGenerator
    ): WalletRepository = Bip44WalletRepository(context, walletGenerator)

    @Provides
    @Singleton
    fun provideWalletService(
            walletRepository: WalletRepository
    ) = WalletService(walletRepository)
}