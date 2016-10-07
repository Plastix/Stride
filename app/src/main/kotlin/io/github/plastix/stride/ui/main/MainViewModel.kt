package io.github.plastix.stride.ui.main

import android.content.Context
import android.databinding.Bindable
import io.github.plastix.stride.BR
import io.github.plastix.stride.data.DataManager
import io.github.plastix.stride.ui.ActivityScope
import io.github.plastix.stride.ui.base.RxViewModel
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(@ActivityScope val context: Context, val dataManager: DataManager) : RxViewModel() {

    var steps: String = "0"
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.steps)
        }


    override fun bind() {
        addSubscription(
                dataManager.getStepCountToday()
                        .map(Int::toString)
                        .doOnNext {
                            Timber.d("Got step update! %s", it)
                        }
                        .subscribe { steps = it }

        )
    }


}