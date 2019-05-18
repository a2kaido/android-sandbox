package io.github.a2kaido.sandbox.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.github.a2kaido.sandbox.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewType.observe(this, Observer {
            it?.let { viewType ->
                navigateTo(viewType)
            }
        })
    }

    private fun navigateTo(viewType: MainViewModel.ViewType) {
        navigateTo(when (viewType) {
            MainViewModel.ViewType.WALK_THROUGH -> WalkThroughFragment()
            MainViewModel.ViewType.HOME -> HomeFragment()
        })
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
