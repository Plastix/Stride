package io.github.plastix.stride.ui.main

import dagger.Subcomponent
import io.github.plastix.stride.ui.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(
        MainModule::class
))
interface MainComponent {

    fun injectTo(activity: MainActivity)
}