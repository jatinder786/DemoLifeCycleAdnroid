package com.example.navgrpahdemo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navgrpahdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var  navController:NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.test.setOnClickListener(this)
        setContentView(binding.root)
        navController= findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
          R.id.test ->
          {
              navController.navigate(R.id.navigation_dashboard)
          }
        }
    }
}