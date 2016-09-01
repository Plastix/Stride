package io.github.plastix.stride.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import io.github.plastix.stride.ApplicationComponent
import io.github.plastix.stride.R
import io.github.plastix.stride.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
    }

    override fun injectDependencies(graph: ApplicationComponent) {
        graph.plus(MainModule(this))
                .injectTo(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Timber.d("Settings menu clicked!")
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
