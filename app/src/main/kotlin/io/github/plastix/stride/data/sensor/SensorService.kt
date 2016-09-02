package io.github.plastix.stride.data.sensor

import android.app.Service
import android.content.Intent
import android.os.Binder
import io.github.plastix.stride.StrideApp
import rx.Observable
import rx.Subscription
import rx.lang.kotlin.BehaviorSubject
import rx.subscriptions.Subscriptions
import timber.log.Timber
import javax.inject.Inject

class SensorService : Service() {

    @Inject
    lateinit var sensorInteractor: SensorInteractor

    private var subscription: Subscription = Subscriptions.unsubscribed()

    private var subject = BehaviorSubject<Float>()

    private val binder = LocalBinder()

    override fun onCreate() {
        super.onCreate()
        Timber.d("service created!  ")
        StrideApp.graph.injectTo(this)
        subscribeToStepSensor()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.d("service started!")

        return START_STICKY
    }

    inner class LocalBinder : Binder() {

        fun getService() = this@SensorService
    }

    fun getRawStepCount(): Observable<Float> = subject.asObservable()

    /**
     * The hardware step sensor on Android will only keep counting steps if listeners are attached.
     * As long as we stay subscribed to sensorInteractor.getRawStepCount() we know that there is an
     * active listener and we will continue to get updates.
     *
     * See https://developer.android.com/reference/android/hardware/Sensor.html#TYPE_STEP_COUNTER
     */
    private fun subscribeToStepSensor() {
        subscription = sensorInteractor.getRawStepCount().subscribe({
            subject.onNext(it)
        }) {
            Timber.e(it, "Unexpected sensor error!")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("service destroyed!")
        subscription.unsubscribe()
    }

    override fun onBind(p0: Intent) = binder
}