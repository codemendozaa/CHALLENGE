package com.example.challengedesarrolladormobile.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challengedesarrolladormobile.data.model.Product
import com.example.challengedesarrolladormobile.databinding.ProductsRowBinding


class MainAdapter(private val context: Context, private val productList: List<Product>,private val itemClickListener:OnProductClickListener ) :
    RecyclerView.Adapter<MainAdapter.ProductViewHolder>() {


    interface OnProductClickListener{
        fun onProductClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        with(holder){
            with(productList[position]) {
                Glide.with(context).load(holder.itemView.context).centerCrop().into(binding.imgProducts)
                holder.binding.txtTitulo.text = name
                holder.binding.txtDescripcion.text = price.toString()


            }


            }
    }

    override fun getItemCount(): Int {
        return productList.size
    }



    inner class ProductViewHolder(val binding: ProductsRowBinding)
        :RecyclerView.ViewHolder(binding.root)


}