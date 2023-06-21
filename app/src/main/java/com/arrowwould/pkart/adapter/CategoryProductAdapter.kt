package com.arrowwould.pkart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arrowwould.pkart.databinding.ItemCategoryProductLayoutBinding
import com.arrowwould.pkart.databinding.LayoutProductItemBinding
import com.arrowwould.pkart.model.AddProductModel
import com.bumptech.glide.Glide

class CategoryProductAdapter(val context: Context, val list: ArrayList<AddProductModel>) :
    RecyclerView.Adapter<CategoryProductAdapter.CategoryProductViewHolder>() {

    inner class CategoryProductViewHolder(val binding: ItemCategoryProductLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryProductViewHolder {
        val binding =
            ItemCategoryProductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoryProductViewHolder, position: Int) {
        Glide.with(context).load(list[position].productCoverImg).into(holder.binding.imageView3)

        holder.binding.textView5.text = list[position].productName
        holder.binding.textView6.text = list[position].productSp
    }

    override fun getItemCount(): Int {
        return list.size
    }
}