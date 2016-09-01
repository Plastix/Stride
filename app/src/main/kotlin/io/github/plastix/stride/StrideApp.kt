package io.github.plastix.stride

import android.app.Application
import dagger.Lazy
import timber.log.Timber
import javax.inject.Inject

class StrideApp : Application() {

    @Inject
    lateinit var debugTree: Lazy<Timber.DebugTree>

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDependencyGraph()

        if (BuildConfig.DEBUG) {
            Timber.plant(debugTree.get())
        }
    }

    private fun initDependencyGraph() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        graph.injectTo(this)
    }
}