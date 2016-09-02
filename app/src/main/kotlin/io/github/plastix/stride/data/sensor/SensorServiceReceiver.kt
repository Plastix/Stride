package io.github.plastix.stride.data.sensor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * A Broadcast receiver which will start the SensorService
 */
class SensorServiceReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, SensorService::class.java))
    }
}