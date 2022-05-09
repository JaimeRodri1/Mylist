package com.example.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private  var recyclerView:RecyclerView?=null
    private var recyclerViewAdapter:recycler?=null
    private  var emelyst= mutableListOf<datos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    emelyst= ArrayList()
        recyclerView= findViewById(R.id.lista) as RecyclerView
        recyclerViewAdapter= recycler(emelyst)
        val layoutManager: RecyclerView.LayoutManager=LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<datos>{
            override fun onItemClick(data: datos) {
                Toast.makeText(this@MainActivity,data.name,Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        bro()
    }
    private fun bro(){
        var amigos= datos("Gabriel",R.drawable.bro,"Mi hermano de otra madre, tremendo hijueputa")
        emelyst.add(amigos)
        amigos= datos("Chamba",R.drawable.bro,"tu no mete cabra saramabiche")
        emelyst.add(amigos)

        recyclerViewAdapter?.notifyDataSetChanged()

    }
}