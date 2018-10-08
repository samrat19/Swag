package com.example.babin.swag.adapters

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.babin.swag.R
import com.example.babin.swag.model.Product
import kotlinx.android.synthetic.main.product_demo.view.*

class Productadapter(val context: Context , val products : List<Product>) :
        RecyclerView.Adapter<Productadapter.ProductHolder>() {

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder?.bindProduct(products[position],context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        val proView = LayoutInflater.from(context).inflate(R.layout.product_demo,
                parent,false)

        return ProductHolder(proView)
     }

    override fun getItemCount(): Int {

        return products.count()
    }

    inner class ProductHolder ( itemView: View ?) : RecyclerView.ViewHolder(itemView) {

        val proImage = itemView?.findViewById<ImageView>(R.id.proimage)
        val proName = itemView?.findViewById<TextView>(R.id.proname)
        val proPrice = itemView?.findViewById<TextView>(R.id.proprice)

        fun bindProduct (products: Product , context: Context){

            val resourceId = context.resources.getIdentifier(products.image,
                    "drawable",context.packageName)

            proImage?.setImageResource(resourceId)
            proName?.text = products.title
            proPrice?.text = products.price
        }
    }
}