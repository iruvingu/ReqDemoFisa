package com.example.reqdemofisa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.reqdemofisa.model.TableModel

class TableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
    }

    //inner class
    class PagerAdapter(val fm: FragmentManager, val arrayList: ArrayList<TableModel>, val page_number: Int) : FragmentStatePagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> firstFragment()
                1 -> secondFragment()
                else -> firstFragment()
            }
        }

        fun firstFragment() : Fragment{
            val bundle: Bundle()

        }

        override fun getCount(): Int {
            return page_number
        }

    }
}
