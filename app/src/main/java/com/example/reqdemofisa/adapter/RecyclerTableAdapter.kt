package com.example.reqdemofisa.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.TableModel
import kotlinx.android.synthetic.main.row_table.view.*

class RecyclerTableAdapter: RecyclerView.Adapter<RecyclerTableAdapter.TableAdapterViewHolder> {

    var tableModelList: ArrayList<TableModel> = arrayListOf()
    var typeTable: String = ""
    val FIRS_PAGE = "first_page"
    val SECOND_PAGE = "second_page"

    constructor(tableModelList: ArrayList<TableModel>
                , typeTable: String) : super(){
        this.tableModelList = tableModelList
        this.typeTable = typeTable
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TableAdapterViewHolder {
        return TableAdapterViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_table, p0, false))
    }

    override fun getItemCount(): Int {
        return tableModelList.size
    }

    override fun onBindViewHolder(p0: TableAdapterViewHolder, p1: Int) {
        when(typeTable) {
            FIRS_PAGE -> p0.firstTableBindView(tableModelList[p1])
            SECOND_PAGE -> p0.secondTableBindView(tableModelList[p1])
        }
    }

    //inner class
    class TableAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun firstTableBindView(model: TableModel) {
            itemView.row_table_name.text = model.name
            itemView.row_table_actual.text = model.actual.toString()
            itemView.row_table_proyection.text = model.proy.toString()
            itemView.row_table_meta.text = model.meta.toString()
            itemView.row_table_rank.text = model.meta.toString()
            itemView.row_table_taso.text = model.taso.toString()
        }

        fun secondTableBindView(model: TableModel) {
            itemView.row_table_name.text = model.name
            itemView.row_table_actual.text = model.actual.toString()
            itemView.row_table_proyection.text = model.proy.toString()
            itemView.row_table_meta.text = model.meta.toString()
            itemView.row_table_rank.text = model.meta.toString()
            itemView.row_table_taso.text = model.taso.toString()
        }
    }

}