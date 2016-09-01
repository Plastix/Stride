package io.github.plastix.stride.ui.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import io.github.plastix.stride.ApplicationComponent
import io.github.plastix.stride.StrideApp

abstract class BaseActivity: AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        injectDependencies(StrideApp.graph)
    }

    abstract fun injectDependencies(graph: ApplicationComponent)
}