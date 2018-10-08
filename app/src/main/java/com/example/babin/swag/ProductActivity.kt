package com.example.babin.swag

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Adapter
import com.example.babin.swag.adapters.Productadapter
import com.example.babin.swag.services.DataService
import com.example.babin.swag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: Productadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categorytypes = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = Productadapter(this,DataService.getProduct(categorytypes))


        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layout  = GridLayoutManager(this,spanCount)
        prGridview.layoutManager = layout
        prGridview.adapter = adapter
    }
}
