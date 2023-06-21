package com.arrowwould.pkart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.arrowwould.pkart.R
import com.arrowwould.pkart.activity.CategoryActivity
import com.arrowwould.pkart.databinding.LayotCategoryItemBinding
import com.arrowwould.pkart.model.CategoryModel


import com.bumptech.glide.Glide
import java.util.ArrayList

class CategoryAdapter(var context: Context, val list: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = LayotCategoryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layot_category_item, parent, false)
        )
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        holder.binding.textView2.text = list[position].cat
        Glide.with(context).load(list[position].img).into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CategoryActivity::class.java)
            intent.putExtra("cat", list[position].cat)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}