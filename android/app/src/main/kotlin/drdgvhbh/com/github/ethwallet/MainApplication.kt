package drdgvhbh.com.github.ethwallet

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import drdgvhbh.com.github.ethwallet.di.component.DaggerAppComponent
import io.flutter.view.FlutterMain

class MainApplication : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder()
            .application(this)
            .build()

    var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        FlutterMain.startInitialization(this)

    }

    override fun applicationInjector(): AndroidInjector<DaggerApplication> = applicationInjector
}