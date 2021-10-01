package com.android.moviehub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.moviehub.adapter.DashboardRecyclerAdapter
import com.android.moviehub.model.movie
import com.android.moviehub.util.ConnectionManager
import moviehub.R

class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard:RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var btnCheckInternet:Button

    lateinit var  recyclerAdapter: DashboardRecyclerAdapter

    val movieInfoList = arrayListOf<movie>(
        movie("Casino Royale","Martin Campbell",8.0),
        movie("Spectre","Sam Mendes",6.8),
        movie("Skyfall","Sam Mendes",7.7),
        movie("No Time to Die","Cary Joji Fukunaga",8.0),
        movie("Mission Impossible","Brian De Palma",7.1),
        movie("Avengers","Joss Whedon",8.0),
        movie("Justice League","Zack Snyder",6.1),
        movie("The Dark Knight","Christopher Nolan",9.1),
        movie("Man of Steel","Zack Snyder",7.0),
        movie("Doctor Strange","Scott Derrickson",7.5)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)

        btnCheckInternet =view.findViewById(R.id.btnCheckInternet)
        btnCheckInternet.setOnClickListener{
            if(ConnectionManager().checkConnectivity(activity as Context)){
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet Connection Found")
                dialog.setPositiveButton("Ok"){text,listener ->}
                dialog.setNegativeButton("Cancel"){text,listener->}
                dialog.create()
                dialog.show()
            }else{
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection not Found")
                dialog.setPositiveButton("Ok"){text,listener ->}
                dialog.setNegativeButton("Cancel"){text,listener->}
                dialog.create()
                dialog.show()
            }

        }

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdapter(activity as Context,movieInfoList)

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager
        recyclerDashboard.addItemDecoration(DividerItemDecoration(recyclerDashboard.context,(layoutManager as LinearLayoutManager).orientation))

        return view
    }

}