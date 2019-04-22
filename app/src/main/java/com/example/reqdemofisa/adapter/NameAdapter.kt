package com.example.reqdemofisa.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.row_name.view.*

class NameAdapter : RecyclerView.Adapter<NameAdapter.NameViewHolder>{

 //attributes
 var sitelist: ArrayList<SiteModel> = arrayListOf()


 //constructor
 constructor(sitelist: ArrayList<SiteModel>) : super() {
  this.sitelist = sitelist
 }

 //fun override
 override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NameViewHolder {
  return NameViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_name,p0, false))
 }

 override fun getItemCount(): Int {
  return sitelist.size
 }

 override fun onBindViewHolder(p0: NameViewHolder, p1: Int) {
  p0.bindView(sitelist[p1])
 }


 //inner classes
 class NameViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

  fun bindView(model : SiteModel){
   itemView.nameSite.text = model.name
  }
 }
}