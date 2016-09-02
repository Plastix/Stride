package io.github.plastix.stride.data.sensor

import rx.AsyncEmitter
import rx.Observable
import javax.inject.Provider

class SensorInteractorImpl(private val asyncProvider: Provider<StepAsyncEmitter>): SensorInteractor {

    override fun getRawStepCount(): Observable<Float> = Observable.fromAsync(asyncProvider.get(), AsyncEmitter.BackpressureMode.LATEST)
}