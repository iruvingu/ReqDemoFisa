package com.example.reqdemofisa.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.reqdemofisa.R
import com.example.reqdemofisa.adapter.RecyclerTableAdapter
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.fragment_table_second.*


class TableSecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler
        var sitesList = arrayListOf(
            SiteModel("NORTE"), SiteModel("SUR"), SiteModel("NORESTE"),
            SiteModel("OCCIDENTE"), SiteModel("CENTRO"), SiteModel("NOROESTE")
        )

        //recycler
        secondList.adapter = RecyclerTableAdapter(sitesList, "second_page")

    }

}
