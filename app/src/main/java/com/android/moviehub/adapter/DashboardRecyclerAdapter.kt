package com.android.moviehub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.moviehub.model.movie
import moviehub.R
import org.w3c.dom.Text

class DashboardRecyclerAdapter(val context:Context,val itemList : ArrayList<movie>):RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtMovieName:TextView = view.findViewById(R.id.txtMovieName)
        val txtMovieDirector:TextView = view.findViewById(R.id.txtMovieDirector)
        val txtMovieRating:TextView = view.findViewById(R.id.txtMovieRating)
        val llContent : LinearLayout = view.findViewById(R.id.recyclerDashboard_linear_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)

        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val movie = itemList[position]
        holder.txtMovieName.text = movie.movieName
        holder.txtMovieDirector.text = movie.movieDirector
        holder.txtMovieRating.text = movie.movieRating.toString()

        holder.llContent.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.txtMovieName.text}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}