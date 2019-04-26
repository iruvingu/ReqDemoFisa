package com.example.reqdemofisa.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.DataCell
import ph.ingenuity.tableview.adapter.AbstractTableAdapter
import ph.ingenuity.tableview.adapter.recyclerview.holder.AbstractViewHolder

class DataTableViewAdapter(private val context: Context): AbstractTableAdapter(context) {

    override fun getColumnHeaderItemViewType(column: Int): Int = 0

    override fun getRowHeaderItemViewType(row: Int): Int = 0

    override fun getCellItemViewType(column: Int): Int = 0

    override fun onCreateCellViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val cellView = LayoutInflater.from(context).inflate(
            // Replace this with your cell view layout
            R.layout.table_cell_text_data,
            parent,
            false
        )

        return DataCellViewHolder(cellView)
    }

    override fun onBindCellViewHolder(
        holder: AbstractViewHolder,
        cellItem: Any,
        column: Int,
        row: Int
    ) {
        val cell = cellItem as DataCell
        val cellViewHolder = holder as DataCellViewHolder
        cellViewHolder.cellTextView.text = cell.content.toString()
    }

    override fun onCreateColumnHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val columnHeaderView = LayoutInflater.from(context).inflate(
            // Replace this with your column header view layout
            R.layout.table_column_header_text_data,
            parent,
            false
        )

        return DataColumnHeaderViewHolder(columnHeaderView)
    }

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder,
        columnHeaderItem: Any,
        column: Int

    ) {
        val columnHeaderCell = columnHeaderItem
        val columnHeaderViewHolder = holder as DataColumnHeaderViewHolder
        columnHeaderViewHolder.cellTextView.text = columnHeaderCell.toString()
    }

    override fun onCreateRowHeaderViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val rowHeaderView = LayoutInflater.from(context).inflate(
            // Replace this with your row header view layout
            R.layout.table_row_header_text_data,
            parent,
            false
        )

        return DataRowHeaderViewHolder(rowHeaderView)
    }

    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder,
        rowHeaderItem: Any,
        row: Int
    ) {
        val rowHeaderCell = rowHeaderItem
        val rowHeaderViewHolder = holder as DataRowHeaderViewHolder
        rowHeaderViewHolder.cellTextView.text = rowHeaderCell.toString()
    }

    override fun onCreateCornerView(): View? {
        // Replace this with your corner view layout
        val cornerView = LayoutInflater.from(context).inflate(R.layout.table_corner_view, null)
        cornerView.setOnClickListener {
            Toast.makeText(context, "CornerView has been clicked.", Toast.LENGTH_SHORT).show()
        }

        return cornerView
    }



    class DataCellViewHolder(itemView: View) : AbstractViewHolder(itemView) {
        val cellTextView: TextView
            get() = itemView.findViewById(R.id.data_cell_data)
    }

    class DataColumnHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
        val cellTextView: TextView
            get() = itemView.findViewById(R.id.column_header_text)
    }

    class DataRowHeaderViewHolder(itemView: View) : AbstractViewHolder(itemView) {
        val cellTextView: TextView
            get() = itemView.findViewById(R.id.row_header_text)
    }
}