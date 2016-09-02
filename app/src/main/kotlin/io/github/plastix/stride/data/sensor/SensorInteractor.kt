package io.github.plastix.stride.data.sensor

import rx.Observable

interface SensorInteractor {

    fun getRawStepCount(): Observable<Float>
}