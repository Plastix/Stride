package io.github.plastix.stride.ui.base

import android.databinding.ViewDataBinding
import android.os.Build
import javax.inject.Inject

abstract class ViewModelActivity<T : AbstractViewModel, out B : ViewDataBinding> : BaseActivity() {

    @Inject
    lateinit var viewModel: T

    protected val binding by lazy { getViewBinding() }

    protected abstract fun getViewBinding(): B

    override fun onStart() {
        super.onStart()
        viewModel.bind()
    }

    override fun onStop() {
        super.onStop()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            onHidden()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            onHidden()
        }
    }

    private fun onHidden() {
        viewModel.unbind()
    }
}