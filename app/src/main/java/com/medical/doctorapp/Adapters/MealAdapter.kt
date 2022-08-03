package com.medical.doctorapp.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.FoodDetails
import com.medical.doctorapp.Models.MealModel
import com.medical.doctorapp.R
import com.medical.doctorapp.SelectVitamins
import com.medical.doctorapp.SelectedMealPlan
import kotlin.math.acos

class MealAdapter(var meallist : ArrayList<MealModel>,var activity: Activity) : RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAdapter.ViewHolder {

       val view: View = LayoutInflater.from(parent.context).inflate(R.layout.mealslist,parent,false)
       return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MealAdapter.ViewHolder, position: Int) {

        holder.mealimg.setImageResource(meallist[position].mealimg)
        holder.mealtitle.text = ""+meallist[position].mealtitle
        holder.mealdesc.text = ""+meallist[position].mealdesc


        holder.itemView.setOnClickListener(View.OnClickListener {
            val i = Intent(activity, FoodDetails::class.java)
            i.putExtra("title", meallist[position].mealtitle)
            activity.startActivity(i)
        })

    }

    override fun getItemCount(): Int {

       return meallist.size

    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        lateinit var mealimg : ImageView
        lateinit var mealtitle : TextView
        lateinit var mealdesc : TextView

        init {

            mealdesc = itemview.findViewById(R.id.mealdesc)
            mealimg = itemview.findViewById(R.id.mealimg)
            mealtitle = itemview.findViewById(R.id.mealtitle)

        }

    }

}