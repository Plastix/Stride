package io.github.plastix.stride.data.sensor

import android.app.Service
import android.content.Intent
import timber.log.Timber

class SensorService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Timber.d("service started!")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("service destroyed!")
    }

    // Not a bound service, return null
    override fun onBind(p0: Intent) = null
}