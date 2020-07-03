package com.fernandomoraes.lesson_07_labrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fernandomoraes.lesson_07_labrecyclerview.data.PlaceListAdapter
import com.fernandomoraes.lesson_07_labrecyclerview.model.Place
import kotlinx.android.synthetic.main.activity_main.*

private var adapter: PlaceListAdapter? = null
private var countryList: ArrayList<Place>? = null
private var layoutManager: RecyclerView.LayoutManager? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList = ArrayList<Place>()
        layoutManager = LinearLayoutManager(this)
        //(!!) significa que ele não aceita valor nulo
        adapter = PlaceListAdapter(countryList!!,this)

        myRecicleView.layoutManager = layoutManager
        myRecicleView.adapter = adapter

        //-------------------------------------------
        var countryNameList:Array<String> = arrayOf("Brazil", "Canada","USA","Mexico","Columbia"
            ,"Malaysia","Singapore","Turkey","Nicaragua","India","Italy","Tunisia","Chile","Argentina"
            ,"Spain","Peru")

        var cityNameList: Array<String> = arrayOf("Brasilia", "Ottawa","Washington, D.C.","Mexico City","Bogotá"
            ,"Kuala Lumpur","Singapore","Ankara","Managua","New Delhi","Rome","Tunis","Santiago","Buenos Aires"
            ,"Madrid","Lima")

        for (posicao in 0..15) {
            var place = Place()
            place.CountryName = countryNameList[posicao]
            place.CityName = cityNameList[posicao]
            countryList?.add(place)
        }
        adapter!!.notifyDataSetChanged()
    }
}