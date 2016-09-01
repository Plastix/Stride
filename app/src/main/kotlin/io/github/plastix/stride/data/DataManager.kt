package io.github.plastix.stride.data

import android.content.Context
import android.content.Intent
import io.github.plastix.stride.ApplicationQualifier
import io.github.plastix.stride.data.sensor.SensorService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(@ApplicationQualifier var context: Context) {

    init {
        context.startService(Intent(context, SensorService::class.java))
    }

}