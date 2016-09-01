package io.github.plastix.stride.ui.main

import android.content.Context
import io.github.plastix.stride.data.DataManager
import io.github.plastix.stride.ui.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(@ActivityScope val context: Context, val dataManager: DataManager) {
}