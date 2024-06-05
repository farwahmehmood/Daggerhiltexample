package com.farwah.daggerhiltexample.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farwah.daggerhiltexample.databinding.ProductItemBinding
import com.farwah.daggerhiltexample.model.ProductItem

class ProductListAdaptor( private val productList: List<ProductItem>) : RecyclerView.Adapter<ProductListAdaptor.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding= ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder){
            with(productList[position]){
                binding.productItemTitleTv.text= this.title
                binding.productItemAmtTv.text=this.price.toString()
                Glide.with(itemView).load(this.image).into(binding.productItemIv)
            }
        }
    }


}