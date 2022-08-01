package com.medical.doctorapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Models.AppointedModel
import com.medical.doctorapp.R

class AppointedAdapter(var patientlist: ArrayList<AppointedModel>) : RecyclerView.Adapter<AppointedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointedAdapter.ViewHolder {

        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.patientappointedlist,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: AppointedAdapter.ViewHolder, position: Int) {

        holder.desc.text = ""+patientlist[position].desc
        holder.name.text = ""+patientlist[position].name

    }

    override fun getItemCount(): Int {

        return patientlist.size

    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        lateinit var name: TextView
        lateinit var desc: TextView

        init {

            name = itemview.findViewById(R.id.name)
            desc = itemview.findViewById(R.id.desc)

        }

    }

}