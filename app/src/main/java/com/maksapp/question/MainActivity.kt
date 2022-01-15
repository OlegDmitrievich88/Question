package com.maksapp.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maksapp.question.FragmentForStart.Companion.newInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
}