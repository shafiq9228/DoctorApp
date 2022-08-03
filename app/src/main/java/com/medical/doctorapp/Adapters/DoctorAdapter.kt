package com.medical.doctorapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Models.DoctorModel
import com.medical.doctorapp.R

class DoctorAdapter(var arrayList: ArrayList<DoctorModel>) : RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorAdapter.ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.doctoritem, parent, false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorAdapter.ViewHolder, position: Int) {

        holder.doctorname.text = ""+arrayList[position].name
        holder.doctorstatus.text = ""+arrayList[position].status
        holder.doctortype.text = ""+arrayList[position].type
        holder.doctordate.text = ""+arrayList[position].date
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }



    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var doctorname: TextView
        var doctorstatus: TextView
        var doctortype: TextView
        var doctordate: TextView
        init {
            doctordate = itemview.findViewById(R.id.doctordate)
            doctorstatus = itemview.findViewById(R.id.doctorstatus)
            doctortype = itemview.findViewById(R.id.doctortype)
            doctorname = itemview.findViewById(R.id.doctorname)
        }


    }

}