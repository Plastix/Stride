package io.github.plastix.stride.ui.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import io.github.plastix.stride.ui.FragmentScope

@Module
abstract class FragmentModule(private val fragment: Fragment) {

    @Provides @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides @FragmentScope
    fun provideFragmentContext(): Context = fragment.context
}