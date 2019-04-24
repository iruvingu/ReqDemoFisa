package com.example.reqdemofisa.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.reqdemofisa.R
import com.example.reqdemofisa.model.TableModel
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {

    val PAGES: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        //callViewPager
        initPagerAdapter(createRowsFake(), PAGES)

    }

    //fun gral
    fun createRowsFake(): ArrayList<TableModel>{
        return arrayListOf(
            TableModel("NORTE"),
            TableModel("SUR"),
            TableModel("OCCIDENTE"),
            TableModel("NORESTE"),
            TableModel("NOROESTE"),
            TableModel("CENTRO")
        )
    }
    //setViewPager
    fun initPagerAdapter(arrayList: ArrayList<TableModel>, page_number: Int) {

        tablePager.adapter =
            PagerAdapter(supportFragmentManager, arrayList, page_number)
        pageIndicator.setViewPager(tablePager)

    }

    //inner class
    class PagerAdapter(fm: FragmentManager, val arrayList: ArrayList<TableModel>, val page_number: Int) : FragmentStatePagerAdapter(fm){


        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> firstFragment()
                1 -> secondFragment()
                else -> firstFragment()
            }
        }

        fun firstFragment() : Fragment{
            return TableOneFragment()
        }

        fun secondFragment() : Fragment{
            return TableSecondFragment()
        }

        override fun getCount(): Int {
            return page_number
        }

    }
}
