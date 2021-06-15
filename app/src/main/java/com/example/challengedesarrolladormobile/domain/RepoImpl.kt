package com.example.challengedesarrolladormobile.domain

import com.example.challengedesarrolladormobile.data.DataSource
import com.example.challengedesarrolladormobile.data.model.Product
import com.example.challengedesarrolladormobile.vo.Resource

class RepoImpl(private val dataSource: DataSource ):Repo {
    override fun getProductList(): Resource<List<Product>> {
        return dataSource.generateProductList
    }
}