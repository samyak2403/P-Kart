package com.arrowwould.pkart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.arrowwould.pkart.activity.ProductDetailsActivity
import com.arrowwould.pkart.databinding.LayoutProductItemBinding
import com.arrowwould.pkart.model.AddProductModel
import com.bumptech.glide.Glide

class ProductAdapter(val context: Context, val list: ArrayList<AddProductModel>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: LayoutProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = LayoutProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        Glide.with(context).load(data.productCoverImg).into(holder.binding.imageView2)
        holder.binding.textView.text = data.productName
        holder.binding.textView3.text = data.productCategory
        holder.binding.textView4.text = data.productMrp

        holder.binding.button.text = data.productSp

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("id", list[position].productId)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}