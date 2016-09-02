package io.github.plastix.stride.data.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import rx.AsyncEmitter
import rx.functions.Action1
import javax.inject.Inject

class StepAsyncEmitter @Inject constructor(private val sensorManager: SensorManager) : Action1<AsyncEmitter<Float>> {

    override fun call(emitter: AsyncEmitter<Float>) {
        val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        val sensorListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                emitter.onNext(event.values[0])
            }

            override fun onAccuracyChanged(event: Sensor, p1: Int) {
                // Not called for step sensors
            }
        }

        sensorManager.registerListener(sensorListener, stepSensor, SensorManager.SENSOR_DELAY_UI)

        emitter.setCancellation {
            sensorManager.unregisterListener(sensorListener)
        }

    }
}