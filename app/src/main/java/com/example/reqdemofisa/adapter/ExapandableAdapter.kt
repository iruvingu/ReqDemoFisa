package com.example.reqdemofisa.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.DataCell
import com.example.reqdemofisa.model.SiteModel
import com.example.reqdemofisa.model.TitlesModel
import kotlinx.android.synthetic.main.lst_parent.view.*
import kotlin.math.exp

class ExapandableAdapter: RecyclerView.Adapter<ExapandableAdapter.TitleViewHolder> {

    private var listTitles: MutableList<TitlesModel> = mutableListOf()
    private var siteModel : MutableList<SiteModel> = mutableListOf()
    private var columnList: MutableList<Any> = mutableListOf()
    private var columnList1: MutableList<Any> = mutableListOf()
    private var columnList2: MutableList<Any> = mutableListOf()
    private var columnList3: MutableList<Any> = mutableListOf()
    private var rowHeadersList: MutableList<Any> = mutableListOf()
    private var cellList1: MutableList<MutableList<Any>> = mutableListOf()
    private var cellList2: MutableList<MutableList<Any>> = mutableListOf()
    private var cellList3: MutableList<MutableList<Any>> = mutableListOf()

    constructor(listTitles: MutableList<TitlesModel>
                , siteModel: MutableList<SiteModel>
                , columnList: MutableList<Any>
                , rowHeadersList: MutableList<Any>) : super() {
        this.listTitles = listTitles
        this.siteModel = siteModel
        this.columnList = columnList
        this.rowHeadersList = rowHeadersList

      (0 until columnList.size).forEach { column ->
        when (column) {
          in 0..9 -> columnList1.add(columnList[column])
          in 10..13 -> columnList2.add(columnList[column])
          in 14..17 -> columnList3.add(columnList[column])
        }
      }

      (0 until rowHeadersList.size).forEach { row ->
        var cellListProjection = mutableListOf<Any>()
        var cellListTaso = mutableListOf<Any>()
        var cellListRank = mutableListOf<Any>()
        (0 until columnList.size).forEach { column ->
          val dataProjection: Any
          dataProjection = when (column) {
            0 -> siteModel[row].projectionEPRC
            1 -> siteModel[row].projection_0_14
            2 -> siteModel[row].projection_1_29
            3 -> siteModel[row].projection30_59
            4 -> siteModel[row].projection_60_89
            5 -> siteModel[row].projection_90_119
            6 -> siteModel[row].projection_120_149
            7 -> siteModel[row].projection_150_179
            8 -> siteModel[row].projection_90_plus
            9 -> siteModel[row].projectionTaso
            else -> ""
          }

          if (!dataProjection.equals("")) {
            cellListProjection.add(DataCell(dataProjection, """$row-$column"""))
          }

          val dataTaso: Any
          dataTaso = when(column) {
            10 -> siteModel[row].tasoEprc
            11 -> siteModel[row].taso_0_14
            12 -> siteModel[row].taso_30_59
            13 -> siteModel[row].taso_90_plus
            else -> ""
          }

          if (!dataTaso.equals("")) {
            cellListTaso.add(DataCell(dataTaso, """$row-$column"""))
          }

          val dataRank: Any
          dataRank = when(column) {
            14 -> siteModel[row].rankEprc
            15 -> siteModel[row].rank_0_14
            16 -> siteModel[row].rank_30_59
            17 -> siteModel[row].rank_90_plus
            else -> ""
          }

          if (!dataRank.equals("")) {
            cellListRank.add(DataCell(dataRank, """$row-$column"""))
          }

        }

        this.cellList1.add(cellListProjection)
        this.cellList2.add(cellListTaso)
        this.cellList3.add(cellListRank)
      }

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TitleViewHolder {
        return TitleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lst_parent, parent, false))
    }

    override fun getItemCount(): Int {
        return listTitles.size
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        val titles: TitlesModel = listTitles.get(position)

        when (titles.id) {
          1 -> holder.bindTitle(titles.title, titles.expanded, cellList1, rowHeadersList, columnList1)
          2 -> holder.bindTitle(titles.title, titles.expanded, cellList2, rowHeadersList, columnList2)
          3 -> holder.bindTitle(titles.title, titles.expanded, cellList3, rowHeadersList, columnList3)
        }

        holder.itemView.setOnClickListener{
            var expanded = titles.expanded
            titles.expanded = !expanded
            notifyItemChanged(position)
        }

    }


    class TitleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindTitle(titles: String
                      , titleExpanded: Boolean
                      , cellsList: MutableList<MutableList<Any>>
                      , rowHeadersList: MutableList<Any>
                      , columnHeadersList: MutableList<Any>) {
            itemView.sub_item.showOrGone(titleExpanded)

            itemView.title_tv.text = titles

            // Retrieve your data from local storage or API

            // Create an instance of our custom TableViewAdapter
            val tableAdapter = DataTableViewAdapter(itemView!!.context)

            // Set the adapter to the created TableView
            itemView.table_view.adapter = tableAdapter

            val randomRowHeadersList = mutableListOf<Any>()

            (0 until rowHeadersList.size).forEach {
              Log.v("RowList", """Row $it""")
              randomRowHeadersList.add(DataCell("""Row $it"""))
            }

            // Set the data to the adapter
            tableAdapter.setAllItems(cellsList, columnHeadersList, rowHeadersList)

        }

        fun View.showOrGone(show: Boolean) {
            visibility = if(show) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

}