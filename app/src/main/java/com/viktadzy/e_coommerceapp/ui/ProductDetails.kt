package com.viktadzy.e_coommerceapp.ui
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.viktadzy.e_coommerceapp.R

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        val bundle = intent.extras
        findViewById<ImageView>(R.id.productimage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.productname).text = bundle!!.getString("name")
        findViewById<TextView>(R.id.productdetails).text = bundle!!.getString("des")
    }
}