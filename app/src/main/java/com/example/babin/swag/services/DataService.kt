package com.example.babin.swag.services

import com.example.babin.swag.model.Category
import com.example.babin.swag.model.Product
import java.util.*

object DataService {

    val category  = listOf(Category("Shirt","shirtimage"),
            Category("Hoodies","hoodieimage"),
            Category("hat","hatimage"),
            Category("digital","digitalgoodsimage"))
    val hats = listOf(
            Product("dev","18$","hat1"),
            Product("dev1","19$","hat2"),
            Product("dev2","17$","hat3"),
            Product("dev3","18$","hat4"))
    val hoodie = listOf(
            Product("dev","18$","hoodie1"),
            Product("dev1","19$","hoodie2"),
            Product("dev2","17$","hoodie3"),
            Product("dev3","18$","hoodie4"))
    val shirts = listOf(
            Product("dev","18$","shirt1"),
            Product("dev1","19$","shirt2"),
            Product("dev2","17$","shirt3"),
            Product("dev3","18$","shirt4"))
    val digital = listOf(
            Product("dev","18$","shirt1"),
            Product("dev1","19$","shirt2"),
            Product("dev2","17$","shirt3"),
            Product("dev3","18$","shirt4"))

    val digitalhood = listOf<Product>()

    fun getProduct(category: String) : List<Product> {

        return when (category){
            "Shirt" -> shirts
            "hat" -> hats
            "Hoodies" -> hoodie
            else -> {
                digitalhood
            }
        }
    }
}