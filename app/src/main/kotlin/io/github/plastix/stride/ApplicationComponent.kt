package io.github.plastix.stride

import dagger.Component
import io.github.plastix.stride.ui.main.MainComponent
import io.github.plastix.stride.ui.main.MainModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class
))
interface ApplicationComponent {

    // Injectors
    fun injectTo(app: StrideApp)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: MainModule): MainComponent
}