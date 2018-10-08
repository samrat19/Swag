package com.example.babin.swag.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.babin.swag.R
import com.example.babin.swag.model.Category

class Categoryadapter (val context: Context, val categories: List<Category>): BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryview : View

        val holder : ViewHolder

        if(convertView == null){

            categoryview = LayoutInflater.from(context).inflate(R.layout.category_demo,null)

            holder = ViewHolder()

            holder.cimage = categoryview.findViewById(R.id.categoryimage)
            holder.ctext = categoryview.findViewById(R.id.categorytext);

            categoryview.tag = holder

        }else{
            holder = convertView.tag as ViewHolder
            categoryview = convertView
        }

     /*   categoryview = LayoutInflater.from(context).inflate(R.layout.category_demo,null)

        val cateimage : ImageView = categoryview.findViewById(R.id.categoryimage)
        val catetext : TextView = categoryview.findViewById(R.id.categorytext); */

      //  val category = categories[position]
       // catetext.text = category.title

        val category = categories[position]
        holder.ctext?.text = category.title

        val resoureid = context.resources.getIdentifier(category.image,
                "drawable",context.packageName)

        //cateimage.setImageResource(resoureid)
        holder.cimage?.setImageResource(resoureid)
        return  categoryview
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {

        return  0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder{

        var cimage : ImageView? = null
        var ctext : TextView? = null
    }
}