package com.example.reqdemofisa.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.row_table_pager.view.*

class RecyclerViewPagerAdapter : RecyclerView.Adapter<RecyclerViewPagerAdapter.TableViewHolder> {

 //attributes
 var siteModel : ArrayList<SiteModel> = arrayListOf()
 var typeTable : Int = 0

 //constructor
 constructor(siteModel: ArrayList<SiteModel>, typeTable: Int) : super() {
  this.siteModel = siteModel
  this.typeTable = typeTable
 }

 override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TableViewHolder {
  return TableViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_table_pager, p0, false))
 }

 override fun getItemCount(): Int {
  return siteModel.size
 }

 override fun onBindViewHolder(p0: TableViewHolder, p1: Int) {
  when (typeTable){
   1 -> p0.firstTableBindView(siteModel[p1])
   2 -> p0.secondTableBindView(siteModel[p1])
   3 -> p0.thirdTableBindView(siteModel[p1])
   4 -> p0.fourthTableBindView(siteModel[p1])
  }
 }

 //inner class
 class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  fun firstTableBindView(model : SiteModel){
   itemView.firstColumn.text = model.projectionEPRC.toString()
   itemView.secondColumn.text = model.projection_0_14.toString()
   itemView.thirdColumn.text = model.projection_1_29.toString()
   itemView.fourthColumn.text = model.projection30_59.toString()
   itemView.fifthColumn.text = model.projection_60_89.toString()
  }

  fun secondTableBindView(model : SiteModel){
   itemView.firstColumn.text = model.projection_90_119.toString()
   itemView.secondColumn.text = model.projection_120_149.toString()
   itemView.thirdColumn.text = model.projection_150_179.toString()
   itemView.fourthColumn.text = model.projection_90_plus.toString()
   itemView.fifthColumn.text = model.projectionTaso.toString()
  }

  fun thirdTableBindView(model : SiteModel){
   itemView.firstColumn.text = model.tasoEprc.toString()
   itemView.secondColumn.text = model.taso_0_14.toString()
   itemView.thirdColumn.text = model.taso_30_59.toString()
   itemView.fourthColumn.text = model.taso_90_plus.toString()
   itemView.fifthColumn.visibility = View.GONE
  }

  fun fourthTableBindView(model : SiteModel){
   itemView.firstColumn.text = model.rankEprc.toString()
   itemView.secondColumn.text = model.rank_0_14.toString()
   itemView.thirdColumn.text = model.rank_30_59.toString()
   itemView.fourthColumn.text = model.rank_90_plus.toString()
   itemView.fifthColumn.visibility = View.GONE
  }

 }
}