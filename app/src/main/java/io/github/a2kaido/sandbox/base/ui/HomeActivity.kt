package io.github.a2kaido.sandbox.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.a2kaido.sandbox.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
}