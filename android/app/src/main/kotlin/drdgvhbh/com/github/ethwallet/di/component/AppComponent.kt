package drdgvhbh.com.github.ethwallet.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import drdgvhbh.com.github.ethwallet.MainActivity
import drdgvhbh.com.github.ethwallet.di.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    PersistenceModule::class,
    ActivityModule::class,
    BridgeModule::class,
    DispatcherModule::class
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