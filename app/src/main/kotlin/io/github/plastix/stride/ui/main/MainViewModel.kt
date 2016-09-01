package io.github.plastix.stride.ui.main

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import io.github.plastix.stride.BR
import io.github.plastix.stride.data.DataManager
import io.github.plastix.stride.ui.ActivityScope
import rx.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(@ActivityScope val context: Context, val dataManager: DataManager) : BaseObservable() {

    var steps: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.steps)
        }


    init {
        Observable.interval(1, TimeUnit.SECONDS)
                .map { it.toString() }
                .subscribe { steps = it }
    }


}