package com.grjt.introduccionajetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {

        }*/

        setContentView(R.layout.activity_second)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, FirstFragment())
            commit()
        }
    }
}