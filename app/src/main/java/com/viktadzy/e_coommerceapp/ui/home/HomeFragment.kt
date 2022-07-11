package com.viktadzy.e_coommerceapp.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.viktadzy.e_coommerceapp.R
import com.viktadzy.e_coommerceapp.databinding.FragmentHomeBinding
import com.viktadzy.e_coommerceapp.ui.ProductDetails

class HomeFragment : AppCompatActivity() {

    var adapter: ProductAdapter? = null
    val listOfProducts = ArrayList<Products>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        //load products
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        listOfProducts.add(
            Products(
                "Chicken",
                "Chicken is dip fried..................",
                R.drawable.icon
            )
        )
        adapter = ProductAdapter(this, listOfProducts)
        //assign our list to our gridview id
        findViewById<GridView>(R.id.productlist).adapter = adapter

    }

    class ProductAdapter : BaseAdapter {
        var listOfProducts = ArrayList<Products>()
        var context: Context? = null

        constructor(context: Context, listOfProducts: ArrayList<Products>) : super() {


            this.context = context
            this.listOfProducts = listOfProducts
        }

        override fun getCount(): Int {
            return listOfProducts.size
        }

        override fun getItem(p0: Int): Any {
            return listOfProducts[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val product = this.listOfProducts[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var productView = inflator.inflate(R.layout.product_ticket, null)
            productView.findViewById<ImageView>(R.id.ticket_image).setImageResource(product.image!!)
            productView.setOnClickListener {
                val intent = Intent(context, ProductDetails::class.java)
                intent.putExtra("name", product.name!!)
                intent.putExtra("des", product.des!!)
                intent.putExtra("image", product.image!!)
                context!!.startActivity(intent)


            }
            productView.findViewById<TextView>(R.id.foodticket).text = product.name!!
            return productView
        }
    }
}