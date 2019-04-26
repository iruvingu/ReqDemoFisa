package com.example.reqdemofisa.model

import ph.ingenuity.tableview.feature.sort.Sortable

class DataCell(_data: Any
               , _id: String = _data.hashCode().toString()
): Sortable {

    override var content: Any = _data

    override var id: String = _id

}