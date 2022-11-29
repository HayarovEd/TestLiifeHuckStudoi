package com.edurda77.testliifehuckstudoi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.testliifehuckstudoi.R
import com.edurda77.testliifehuckstudoi.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}