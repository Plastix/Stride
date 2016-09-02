package io.github.plastix.stride.data

import android.content.Context
import android.hardware.SensorManager
import io.github.plastix.stride.ApplicationQualifier
import io.github.plastix.stride.data.sensor.SensorInteractor
import io.github.plastix.stride.data.sensor.SensorInteractorImpl
import io.github.plastix.stride.data.sensor.StepAsyncEmitter
import javax.inject.Provider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideSensorManager(@ApplicationQualifier context: Context) = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    @Provides @Singleton
    fun provideSensorInteractor(asyncEmitter: Provider<StepAsyncEmitter>): SensorInteractor = SensorInteractorImpl(asyncEmitter)
}