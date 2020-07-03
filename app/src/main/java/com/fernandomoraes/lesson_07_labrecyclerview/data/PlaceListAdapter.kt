package com.fernandomoraes.lesson_07_labrecyclerview.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.fernandomoraes.lesson_07_labrecyclerview.R
import com.fernandomoraes.lesson_07_labrecyclerview.model.Place

class PlaceListAdapter(
    private val list: ArrayList<Place>,
    private val context: Context
) : RecyclerView.Adapter<PlaceListAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: PlaceListAdapter.ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(place: Place) {
            var country: TextView = itemView.findViewById(R.id.lblPais) as TextView
            var city: TextView = itemView.findViewById(R.id.lblCidade) as TextView
            country.text = place.CountryName
            city.text = place.CityName
            itemView.setOnClickListener { Toast.makeText(context, country.text, Toast.LENGTH_SHORT).show() }

        }
    }
}