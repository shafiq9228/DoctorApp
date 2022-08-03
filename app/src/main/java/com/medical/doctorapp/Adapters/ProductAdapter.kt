package com.medical.doctorapp.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.*
import com.medical.doctorapp.Models.ProductModel

class ProductAdapter(var arraylist: ArrayList<ProductModel>, var activity: Activity) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.productslist, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {

        holder.productname.text = ""+arraylist[position].name
        holder.productimg.setImageResource(arraylist[position].img)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val i= Intent(activity, Category2Activity::class.java)
            i.putExtra("type", ""+arraylist[position].name)
            activity.startActivity(i)
        })



    }

    override fun getItemCount(): Int {

        return arraylist.size
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        lateinit var productimg: ImageView
        lateinit var productname: TextView

        init {
            productimg = itemview.findViewById(R.id.productimg)
            productname = itemview.findViewById(R.id.productname)
        }

    }
}