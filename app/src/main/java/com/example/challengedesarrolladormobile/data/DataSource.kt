package com.example.challengedesarrolladormobile.data

import com.example.challengedesarrolladormobile.data.model.Product
import com.example.challengedesarrolladormobile.vo.Resource

class DataSource {
     val  generateProductList = Resource.Success(listOf(
        Product("http://mla-s1-p.mlstatic.com/685061-MLA31003463570_062019-I.jpg","Motorola G6 32 Gb Plata",30) ,
        Product("http://mla-s1-p.mlstatic.com/685061-MLA31003463570_062019-I.jpg","Motorola G6 32 Gb Plata",40) ,
        Product("http://mla-s1-p.mlstatic.com/685061-MLA31003463570_062019-I.jpg","Motorola G6 32 Gb Plata",10) ,
        Product("http://mla-s1-p.mlstatic.com/685061-MLA31003463570_062019-I.jpg","Motorola G6 32 Gb Plata",100) ,

    ))

}