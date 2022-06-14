package com.pharma.doctorapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pharma.doctorapp.R
import com.pharma.doctorapp.UploadActivity
import com.pharma.doctorapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var uploadprep: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        uploadprep = view.findViewById(R.id.uploadprep)
        uploadprep.setOnClickListener(View.OnClickListener {
            val i = Intent(activity, UploadActivity::class.java)
            startActivity(i)
        })

        return  view
    }
}