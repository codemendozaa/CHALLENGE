package com.example.challengedesarrolladormobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.challengedesarrolladormobile.data.DataSource
import com.example.challengedesarrolladormobile.domain.Repo
import com.example.challengedesarrolladormobile.domain.RepoImpl
import com.example.challengedesarrolladormobile.ui.viewModel.MainViewModel
import com.example.challengedesarrolladormobile.ui.viewModel.VMFactory

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}