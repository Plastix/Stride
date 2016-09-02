package io.github.plastix.stride

import dagger.Component
import io.github.plastix.stride.data.DataModule
import io.github.plastix.stride.data.sensor.SensorService
import io.github.plastix.stride.ui.main.MainComponent
import io.github.plastix.stride.ui.main.MainModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class
))
interface ApplicationComponent {

    // Injectors
    fun injectTo(app: StrideApp)

    fun injectTo(service: SensorService)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: MainModule): MainComponent
}