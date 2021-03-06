package com.example.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class recycler constructor(private val emelyst: List<datos> ):
RecyclerView.Adapter<recycler.MyViewHolder>(){
    private var clickListener:ClickListener<datos>?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: recycler.MyViewHolder, position: Int) {
    val amy=emelyst[position]
        holder.nombre.text=amy.name
        holder.imagen.setBackgroundResource(amy.image)
        holder.cardView.setOnClickListener { clickListener!!.onItemClick(amy) }
        holder.descripcion.text="${amy.descrip}"
    }
    override fun getItemCount(): Int {
        return emelyst.size
    }
    fun setOnItemClickListener(emiClickListener:ClickListener<datos>?){
        clickListener = emiClickListener
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       //aqui se declaran variables a la cuales les damos que datos contendran
       val nombre: TextView = itemView.findViewById(R.id.name)
        val imagen: ImageView= itemView.findViewById(R.id.maje)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val descripcion: TextView = itemView.findViewById(R.id.caracter)
    }

}
interface ClickListener<T> {
    fun onItemClick(data: T)
}