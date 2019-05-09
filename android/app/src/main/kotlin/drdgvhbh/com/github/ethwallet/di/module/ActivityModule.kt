package drdgvhbh.com.github.ethwallet.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import drdgvhbh.com.github.ethwallet.MainActivity

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}