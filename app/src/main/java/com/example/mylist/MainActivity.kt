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
        var amigos= datos("Gabriel",R.drawable.bro,"Es carismatico y muy sociable, le gusta conocer mucha gente. ")
        emelyst.add(amigos)
        amigos= datos("Salvador",R.drawable.bro,"Es muy amigable y tambien muy inteligente")
        emelyst.add(amigos)
        amigos= datos("Adiel",R.drawable.m2,"Es muy inteligente y gran amigo siempre te apoya")
        emelyst.add(amigos)
        amigos= datos("Melvin",R.drawable.m1,"Es muy amigable y tambien muy inteligente siempre te brinda apoyo")
        emelyst.add(amigos)
        amigos= datos("Melvin Perez",R.drawable.m3,"Es muy agradable y divritdo muy buen amigo")
        emelyst.add(amigos)

        recyclerViewAdapter?.notifyDataSetChanged()

    }
}