package drdgvhbh.com.github.ethwallet.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import drdgvhbh.com.github.ethwallet.MainActivity
import drdgvhbh.com.github.ethwallet.di.module.ActivityModule
import drdgvhbh.com.github.ethwallet.di.module.ApplicationModule
import drdgvhbh.com.github.ethwallet.di.module.BridgeModule
import drdgvhbh.com.github.ethwallet.di.module.PersistenceModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    PersistenceModule::class,
    ActivityModule::class,
    BridgeModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DaggerApplication): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder

        fun build(): AppComponent
    }
}