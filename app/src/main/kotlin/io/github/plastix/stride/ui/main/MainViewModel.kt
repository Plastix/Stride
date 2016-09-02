package io.github.plastix.stride.ui.main

import android.content.Context
import android.databinding.Bindable
import io.github.plastix.stride.BR
import io.github.plastix.stride.data.DataManager
import io.github.plastix.stride.ui.ActivityScope
import io.github.plastix.stride.ui.base.RxViewModel
import rx.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(@ActivityScope val context: Context, val dataManager: DataManager) : RxViewModel() {

    var steps: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.steps)
        }


    override fun bind() {
        addSubscription(
                Observable.interval(1, TimeUnit.SECONDS)
                        .map { it.toString() }
                        .doOnNext { Timber.d(it) }
                        .subscribe { steps = it }

        )
    }


}