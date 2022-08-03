package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.PurchaseAdapter
import com.medical.doctorapp.Models.MealModel
import com.medical.doctorapp.Models.PurchaseModel

class Category2Activity :AppCompatActivity() , CallbackInterface {

    lateinit var bck: ImageView
    lateinit var myproductlist: RecyclerView
    lateinit var  arraylist: ArrayList<PurchaseModel>;
    lateinit var type: String
    lateinit var ptitle: TextView
    lateinit var purchaseAdapter: PurchaseAdapter
    lateinit var price: TextView
     var i1: Int = 0
    lateinit var ordernow: Button
    lateinit var quantity: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category2)

        ptitle = findViewById(R.id.ptitle)
        type = intent.getStringExtra("type").toString();

        ptitle.text = type
        bck = findViewById(R.id.bck)
        arraylist = ArrayList()


        price = findViewById(R.id.price)
        quantity = findViewById(R.id.quantity)
        ordernow = findViewById(R.id.ordernow)
        myproductlist = findViewById(R.id.myproductlist)

        myproductlist.layoutManager = LinearLayoutManager(this)


        bck.setOnClickListener(View.OnClickListener {
            finish()
        })

        ordernow.setOnClickListener(View.OnClickListener {

            if (!quantity.text.toString().equals("0")){
                val i = Intent(this@Category2Activity, PaymentDetails::class.java)
                startActivity(i)
            }else{
                Toast.makeText(applicationContext, "Please Choose a product", Toast.LENGTH_SHORT).show()
            }

        })
        if (type.lowercase().equals("syrups")){
            addsyrups()
        }else if (type.lowercase().equals("tablets")){
          addtables()
        }else if(type.lowercase().equals("vitamins")){
            addvitamins()
        }else if (type.lowercase().contains("blood")){
            addblood()
        }else if (type.lowercase().contains("covid")){
            addcovid()
        }else if (type.lowercase().contains("capsules")){
            addcapsules()
        }



    }

    fun addsyrups(){

        val pruchaseModel = PurchaseModel("KOFOL COUGH SYRUP","this is good", 100, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("SBL STOBAL COUGH SYRUP","nice medicine", 120, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("HIMALAYA KOFLET SYRUP","nice medicine", 110, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist,this )
        myproductlist.adapter =  purchaseAdapter
    }

    fun addtables(){
        val pruchaseModel = PurchaseModel("Doxorubicin","this is good", 100, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("fenofibrate","nice medicine", 100, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("haloperidol tablet","nice medicine", 120, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist, this)
        myproductlist.adapter =  purchaseAdapter
    }

    fun addvitamins(){
        val pruchaseModel = PurchaseModel("Deplin","this is good", 120, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("Decara","nice medicine", 120, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("ColoMist","nice medicine", 120, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist, this)
        myproductlist.adapter =  purchaseAdapter



    }

    fun addblood(){
        val pruchaseModel = PurchaseModel("glucometer device,","this is good", 100, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("lancets","nice medicine", 190, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("carry pouch.","nice medicine", 135, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist, this)
        myproductlist.adapter =  purchaseAdapter
    }

    fun addcovid(){
        val pruchaseModel = PurchaseModel("Masks,","this is good", 40, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("Spirometer","nice medicine", 180, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("Steam Vaporiser","nice medicine", 350, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist, this)
        myproductlist.adapter =  purchaseAdapter
    }

    fun addcapsules(){
        val pruchaseModel = PurchaseModel("HPMC capsules,","this is good", 40, 0, R.drawable.ic_round_image_24);
        arraylist.add(pruchaseModel)

        val pruchaseModel2 = PurchaseModel("Hard gelatin capsules","nice medicine", 80, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel2)


        val pruchaseModel3 = PurchaseModel("Starch capsules","nice medicine", 100, 0, R.drawable.ic_round_medication_liquid_24);
        arraylist.add(pruchaseModel3)

        purchaseAdapter = PurchaseAdapter(arraylist, this)
        myproductlist.adapter =  purchaseAdapter
    }


    override fun passResultCallback(mprice: Int, mquantity: Int) {

        price.text = "$"+mprice
        quantity.text = ""+mquantity


    }
}