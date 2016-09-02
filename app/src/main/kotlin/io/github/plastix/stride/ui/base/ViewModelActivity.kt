package io.github.plastix.stride.ui.base

import android.databinding.ViewDataBinding
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
        viewModel.unbind()
    }
}