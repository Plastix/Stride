package io.github.plastix.stride.data

import android.content.*
import android.os.IBinder
import android.preference.PreferenceManager
import io.github.plastix.stride.ApplicationQualifier
import io.github.plastix.stride.data.sensor.SensorService
import rx.AsyncEmitter
import rx.Observable
import rx.Subscription
import rx.functions.Action1
import rx.subscriptions.Subscriptions
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(@ApplicationQualifier var context: Context) : ServiceConnection {

    companion object {
        const val PREF_STEP_COUNT = "STEP_COUNT"
    }

    var subscription: Subscription = Subscriptions.unsubscribed()

    var preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    init {
        val intent = Intent(context, SensorService::class.java)
        context.startService(intent)
        context.bindService(intent, this, Context.BIND_NOT_FOREGROUND)
    }

    override fun onServiceConnected(name: ComponentName, service: IBinder) {
        val binder = service as SensorService.LocalBinder
        val sensorService = binder.getService()

        subscription = sensorService.getRawStepCount()
                .map(Float::toInt)
                .subscribe({
                    saveStepCount(it)
                }) {
                    Timber.d(it, "unexpected error!")
                }
    }

    private fun saveStepCount(steps: Int) {
        preferences.edit().putInt(PREF_STEP_COUNT, steps).apply()
    }

    fun getStepCountToday(): Observable<Int> {
        return Observable.fromAsync(Emitter(), AsyncEmitter.BackpressureMode.LATEST)
    }


    override fun onServiceDisconnected(name: ComponentName) {
        subscription.unsubscribe()
    }

    inner class Emitter : Action1<AsyncEmitter<Int>> {
        override fun call(emitter: AsyncEmitter<Int>) {

            val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
                emitter.onNext(sharedPreferences.getInt(key, 0))
            }

            preferences.registerOnSharedPreferenceChangeListener(listener)

            emitter.setCancellation { preferences.unregisterOnSharedPreferenceChangeListener(listener) }
        }
    }
}