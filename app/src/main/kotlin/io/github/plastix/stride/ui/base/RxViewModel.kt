package io.github.plastix.stride.ui.base

import android.support.annotation.CallSuper
import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class RxViewModel : AbstractViewModel() {

    protected val subscriptions: CompositeSubscription = CompositeSubscription()

    fun addSubscription(subscription: Subscription) {
        subscriptions.add(subscription)
    }

    @CallSuper
    override fun unbind() {
        super.unbind()
        subscriptions.clear()
    }
}