package io.github.plastix.stride.data

import android.content.Context
import android.hardware.SensorManager
import dagger.Module
import dagger.Provides
import io.github.plastix.stride.ApplicationQualifier
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideSensorManager(@ApplicationQualifier context: Context) = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
}