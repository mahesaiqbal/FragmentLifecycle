package com.mahesaiqbal.fragmentlifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isOneFragmentLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change = findViewById<Button>(R.id.btn_change)

        showOneFragment()

        change.setOnClickListener {
            if (isOneFragmentLoaded) {
                showTwoFragment()
            } else {
                showOneFragment()
            }
        }
    }

    fun showOneFragment() {
        val fragment = OneFragment()
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isOneFragmentLoaded = true
    }

    fun showTwoFragment() {
        val fragment = TwoFragment()
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isOneFragmentLoaded = false
    }
}
