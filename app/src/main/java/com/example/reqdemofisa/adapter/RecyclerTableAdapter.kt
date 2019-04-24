package com.example.reqdemofisa.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.row_second_table.view.*
import kotlinx.android.synthetic.main.row_table.view.*
import kotlinx.android.synthetic.main.row_table.view.eightColumn
import kotlinx.android.synthetic.main.row_table.view.fifthColumn
import kotlinx.android.synthetic.main.row_table.view.firstColumn
import kotlinx.android.synthetic.main.row_table.view.fourthColumn
import kotlinx.android.synthetic.main.row_table.view.nameColumn
import kotlinx.android.synthetic.main.row_table.view.secondColumn
import kotlinx.android.synthetic.main.row_table.view.seventhColumn
import kotlinx.android.synthetic.main.row_table.view.sixthColumn
import kotlinx.android.synthetic.main.row_table.view.thirdColumn

class RecyclerTableAdapter: RecyclerView.Adapter<RecyclerTableAdapter.TableAdapterViewHolder> {

    var tableModelList: ArrayList<SiteModel> = arrayListOf()
    var typeTable: String = ""
    val FIRST_PAGE = "first_page"
    val SECOND_PAGE = "second_page"

    constructor(tableModelList: ArrayList<SiteModel>
                , typeTable: String) : super(){
        this.tableModelList = tableModelList
        this.typeTable = typeTable
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TableAdapterViewHolder {
        when(typeTable){
            FIRST_PAGE -> return TableAdapterViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_table, p0, false))
            SECOND_PAGE -> return TableAdapterViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_second_table, p0, false))
            else -> return TableAdapterViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_table, p0, false))
        }

    }

    override fun getItemCount(): Int {
        return tableModelList.size
    }

    override fun onBindViewHolder(p0: TableAdapterViewHolder, p1: Int) {
        when(typeTable) {
            FIRST_PAGE -> p0.firstTableBindView(tableModelList[p1])
            SECOND_PAGE -> p0.secondTableBindView(tableModelList[p1])
        }
    }

    //inner class
    class TableAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun firstTableBindView(model: SiteModel) {
            itemView.nameColumn.text = model.name
            itemView.firstColumn.text = model.projectionEPRC.toString()
            itemView.secondColumn.text = model.projection_0_14.toString()
            itemView.thirdColumn.text = model.projection_1_29.toString()
            itemView.fourthColumn.text = model.projection30_59.toString()
            itemView.fifthColumn.text = model.projection_60_89.toString()
            itemView.sixthColumn.text = model.projection_90_119.toString()
            itemView.seventhColumn.text = model.projection_120_149.toString()
            itemView.eightColumn.text = model.projection_150_179.toString()
            itemView.ninthColumn.text = model.projection_90_plus.toString()
            itemView.tenthColumn.text = model.projectionTaso.toString()
        }

        fun secondTableBindView(model: SiteModel) {
            itemView.snameColumn.text = model.name
            itemView.sfirstColumn.text = model.tasoEprc.toString()
            itemView.ssecondColumn.text = model.taso_0_14.toString()
            itemView.sthirdColumn.text = model.taso_30_59.toString()
            itemView.sfourthColumn.text = model.taso_90_plus.toString()
            itemView.sfifthColumn.text = model.rankEprc.toString()
            itemView.ssixthColumn.text = model.rank_0_14.toString()
            itemView.sseventhColumn.text = model.rank_30_59.toString()
            itemView.seightColumn.text = model.rank_90_plus.toString()

        }

    }

}