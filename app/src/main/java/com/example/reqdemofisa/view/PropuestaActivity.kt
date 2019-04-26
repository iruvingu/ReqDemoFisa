package com.example.reqdemofisa.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.reqdemofisa.R
import com.example.reqdemofisa.adapter.ExapandableAdapter
import com.example.reqdemofisa.model.SiteModel
import com.example.reqdemofisa.model.TitlesModel
import kotlinx.android.synthetic.main.activity_propuesta.*

class PropuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propuesta)

        val adapater = ExapandableAdapter(createListTitle(), createRowHeaders(), createColumnHeaders(), createRowHeadersReal())

        propuesta_recycler_view.layoutManager = LinearLayoutManager(this)
        propuesta_recycler_view.adapter = adapater
        propuesta_recycler_view.setHasFixedSize(true)

    }

    fun createListTitle(): MutableList<TitlesModel> {
        return mutableListOf(
            TitlesModel("Proyection",1),
            TitlesModel("Alcance Taso", 2),
            TitlesModel("Rank", 3)
        )
    }

    fun createColumnHeaders(): MutableList<Any> {
      return mutableListOf(
        getString(R.string.projection1)
      , getString(R.string.projection2)
      , getString(R.string.projection3)
      , getString(R.string.projection4)
      , getString(R.string.projection5)
      , getString(R.string.projection6)
      , getString(R.string.projection7)
      , getString(R.string.projection8)
      , getString(R.string.projection9)
      , getString(R.string.projection10)
      , getString(R.string.taso1)
      , getString(R.string.taso2)
      , getString(R.string.taso3)
      , getString(R.string.taso4)
      , getString(R.string.rank1)
      , getString(R.string.rank2)
      , getString(R.string.rank3)
      , getString(R.string.rank4)
      )
    }

    fun createRowHeaders(): MutableList<SiteModel> {
        return mutableListOf(
            SiteModel("NORTE"),
            SiteModel("SUR"),
            SiteModel("OCCIDENTE"),
            SiteModel("NORESTE"),
            SiteModel("NOROESTE"),
            SiteModel("CENTRO")
        )
    }

    fun createRowHeadersReal(): MutableList<Any> {
      return mutableListOf(
        "NORTE"
        ,"SUR"
        ,"OCCIDENTE"
        ,"NORESTE"
        ,"NOROESTE"
        ,"CENTRO"
      )
    }
}
