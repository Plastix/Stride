package io.github.plastix.stride.data

import dagger.Module
import dagger.Provides
import io.github.plastix.stride.data.sensor.SensorInteractor
import javax.inject.Singleton

@Module
class DataModule {

    @Provides @Singleton
    fun provideSensorInteractor(): SensorInteractor {
        return MockSensorInteractor()
    }
}