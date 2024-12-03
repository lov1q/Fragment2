package com.example.fragment2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun b1Click(view: View){
        val firstFragment = FirstFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.host, firstFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun b2Click(view: View){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.host, GenericFragment.newInstance(0x99FF0000.toInt(), "Second"))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun b3Click(view: View){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.host, GenericFragment.newInstance(0x9900FF00.toInt(), "Третий"))
        transaction.addToBackStack(null)
        transaction.commit()
    }

}