package io.github.plastix.stride.data.sensor

import rx.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class SensorInteractor @Inject constructor(private val asyncProvider: Provider<StepAsyncEmitter>) {

    fun getRawStepCount() = Observable.interval(1, TimeUnit.SECONDS)
            .map { it.toFloat() }

//    fun getRawStepCount() = Observable.fromAsync(asyncProvider.get(), AsyncEmitter.BackpressureMode.LATEST)
}