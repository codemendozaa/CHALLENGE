package com.example.challengedesarrolladormobile.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challengedesarrolladormobile.domain.Repo

class VMFactory(private val repo: Repo) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}