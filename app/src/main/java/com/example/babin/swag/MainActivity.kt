package com.example.babin.swag

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.babin.swag.adapters.CategoryRecycleAdaper
import com.example.babin.swag.adapters.Categoryadapter
import com.example.babin.swag.services.DataService
import com.example.babin.swag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // lateinit var arrayAdapter: ArrayAdapter<Category>
    lateinit var arrayAdapter : CategoryRecycleAdaper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* arrayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                DataService.category)*/
       // arrayAdapter = CategoryRecycleAdaper(this, DataService.category)

        arrayAdapter = CategoryRecycleAdaper(this,DataService.category) {category ->

          //  Toast.makeText(this,"you clicked on ${category.title}",
              //      Toast.LENGTH_SHORT).show()

            val intent = Intent(applicationContext,ProductActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(intent)
        }

        listview.adapter = arrayAdapter

        //introducing  on item click in Kotlin
      /*  listview.setOnItemClickListener{ adaperview,view,i,l ->
            val catregory = DataService.category[i]
            Toast.makeText(this,"you clicked on ${catregory.title}",
                    Toast.LENGTH_SHORT).show() *

        }*/

        val layoutmanager = LinearLayoutManager(this)
        listview.layoutManager = layoutmanager
        listview.setHasFixedSize(true)
    }
}
