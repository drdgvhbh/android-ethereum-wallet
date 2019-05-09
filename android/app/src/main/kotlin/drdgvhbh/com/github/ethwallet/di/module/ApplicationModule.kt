package drdgvhbh.com.github.ethwallet.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.DaggerApplication
import drdgvhbh.com.github.ethwallet.MainApplication
import drdgvhbh.com.github.ethwallet.di.context.ApplicationContext
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: DaggerApplication) {
    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = this.application
}