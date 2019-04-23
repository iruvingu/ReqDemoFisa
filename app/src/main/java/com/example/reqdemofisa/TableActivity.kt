package com.example.reqdemofisa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import com.example.reqdemofisa.model.TableModel
import kotlinx.android.synthetic.main.activity_pager.*
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

        table_view_pager.adapter = PagerAdapter(supportFragmentManager, arrayList, page_number)

        table_view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> tv_title.setText("Pagina 1")
                    1 -> tv_title.setText("Pagina 2")
                }
            }

        })
    }

    //inner class
    class PagerAdapter(fm: FragmentManager, val arrayList: ArrayList<TableModel>, val page_number: Int) : FragmentStatePagerAdapter(fm){

        val TYPE_RECYCLER = "type_recycler"
        val LIST = "array_list"
        val FIRS_PAGE = "first_page"
        val SECOND_PAGE = "second_page"

        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> firstFragment()
                1 -> secondFragment()
                else -> firstFragment()
            }
        }

        fun firstFragment() : Fragment{
            val bundle = Bundle()
            bundle.putString(TYPE_RECYCLER, FIRS_PAGE)
            bundle.putParcelableArrayList(LIST, arrayList)
            return RecyclerTableFragment.newInstance(bundle)
        }

        fun secondFragment() : Fragment{
            val bundle = Bundle()
            bundle.putString(TYPE_RECYCLER, SECOND_PAGE)
            bundle.putParcelableArrayList(LIST, arrayList)
            return RecyclerTableFragment.newInstance(bundle)
        }

        override fun getCount(): Int {
            return page_number
        }

    }
}
