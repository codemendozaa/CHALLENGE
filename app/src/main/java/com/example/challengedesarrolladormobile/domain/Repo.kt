package com.example.challengedesarrolladormobile.domain

import com.example.challengedesarrolladormobile.data.model.Product
import com.example.challengedesarrolladormobile.vo.Resource

interface Repo {
    fun getProductList(): Resource<List<Product>>
}