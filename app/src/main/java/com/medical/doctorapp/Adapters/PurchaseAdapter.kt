package com.medical.doctorapp.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.CallbackInterface
import com.medical.doctorapp.Category2Activity
import com.medical.doctorapp.Models.PurchaseModel
import com.medical.doctorapp.R


class PurchaseAdapter(var arrayList: ArrayList<PurchaseModel>, private val callbackInterface: CallbackInterface): RecyclerView.Adapter<PurchaseAdapter.ViewHolder>() {
    var totalprice = 0
    var totalquantity = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.purchaseitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (arrayList[position].quantity == 0){
            holder.addbtn.visibility = View.VISIBLE
            holder.layout2.visibility = View.GONE

        }else{
            holder.addbtn.visibility = View.GONE
            holder.layout2.visibility = View.VISIBLE


        }

        holder.itemimg.setImageResource(arrayList[position].image)
        holder.title.text = ""+arrayList[position].title
        holder.itemdesc.text = ""+arrayList[position].desc
        holder.price.text = "$"+arrayList[position].price
        holder.quantity.text = ""+arrayList[position].quantity
        holder.addbtn.setOnClickListener(View.OnClickListener {
            addfun(position, arrayList[position].price, arrayList[position].quantity)
        })
        holder.addimg.setOnClickListener(View.OnClickListener {

            addfun(position, arrayList[position].price, arrayList[position].quantity)
        })

        holder.removeimg.setOnClickListener(View.OnClickListener {
            removefun(position, arrayList[position].price, arrayList[position].quantity)
        })


    }

//    fun tempfun(){
//
//    }
//    fun updatefun(position: Int) {
//        Toast.makeText(activity, "I am update "+position, Toast.LENGTH_SHORT).show()
//
//    }
//
//    fun foo(msg: String, bar: () -> String) {
//        bar()
//        Toast.makeText(activity, "from adapter", Toast.LENGTH_SHORT).show()
//    }

    fun addfun(position: Int, price: Int, quantity: Int ){
        arrayList[position].quantity = arrayList[position].quantity.plus(1)
        totalprice = totalprice + price
        totalquantity = totalquantity + 1

        callbackInterface.passResultCallback(totalprice, totalquantity)
        notifyDataSetChanged()
    }

    fun removefun(position: Int, price: Int, quantity: Int){
        totalprice = totalprice - price
        totalquantity = totalquantity - 1
        arrayList[position].quantity = arrayList[position].quantity.minus(1)
        callbackInterface.passResultCallback(totalprice, totalquantity)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }


    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)  {

         var quantity: TextView
         var addimg: ImageView
         var removeimg: ImageView
         var price: TextView
         var title: TextView
         var addbtn: Button
         var layout2: LinearLayout
         var itemdesc: TextView
         var itemimg: ImageView



        init {

            quantity =  itemview.findViewById(R.id.quantity)
            addimg = itemview.findViewById(R.id.addimg)
            removeimg = itemview.findViewById(R.id.removeimg)
            price = itemview.findViewById(R.id.itemprice)
            title  = itemview.findViewById(R.id.itemtitle)
            addbtn = itemview.findViewById(R.id.addbtn)
            itemdesc = itemview.findViewById(R.id.itemdesc)
            itemimg = itemview.findViewById(R.id.itemimg)
            layout2 = itemview.findViewById(R.id.layout2)

        }

    }
}