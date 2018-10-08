package com.example.babin.swag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.babin.swag.R
import com.example.babin.swag.model.Category

class CategoryRecycleAdaper(val context : Context, val categories : List<Category>,
                            val itemClick : (Category) -> Unit) :
        RecyclerView.Adapter<CategoryRecycleAdaper.Holder>(){

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder?.bindcategory(categories[position],context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.category_demo,
                parent,false)
        return Holder(view , itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    inner class Holder(itemView: View?,
                       val itemClick : (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        
        val categImage = itemView?.findViewById<ImageView>(R.id.categoryimage)
        val catetext = itemView?.findViewById<TextView>(R.id.categorytext)

        fun bindcategory(category : Category , context : Context){

            val resourceid = context.resources.getIdentifier(category.image,
                    "drawable", context.packageName)

            categImage?.setImageResource(resourceid)
            catetext?.text = category.title

            itemView.setOnClickListener { itemClick(category) }
        }
    }
}