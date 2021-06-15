package com.example.challengedesarrolladormobile.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.challengedesarrolladormobile.domain.Repo
import com.example.challengedesarrolladormobile.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo):ViewModel() {

    val fetchProductList = liveData(Dispatchers.IO){
      //  emit(Resource.Loading())
        try {
            emit(repo.getProductList())
        }catch (e:Exception){
           emit(Resource.Failure(e))
        }
    }
}