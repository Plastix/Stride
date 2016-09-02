package io.github.plastix.stride.data

import io.github.plastix.stride.data.sensor.SensorInteractor
import rx.Observable
import java.util.concurrent.TimeUnit

class MockSensorInteractor : SensorInteractor {

    override fun getRawStepCount(): Observable<Float> = Observable.interval(1, TimeUnit.SECONDS).map { it.toFloat() }
}