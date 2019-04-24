package com.example.reqdemofisa.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.widget.TextView
import com.example.reqdemofisa.R
import com.example.reqdemofisa.adapter.NameAdapter
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : AppCompatActivity() {

 //values
 public val PAGE_NUMBER = 4

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_pager)

  //setDataRecycler
  setData()

  //setViewPager
  viewPager.adapter =
      PagerAdapter(supportFragmentManager, PAGE_NUMBER, titlePager)
  pageIndicator.setViewPager(viewPager)

  viewPager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
   override fun onPageScrollStateChanged(p0: Int) {
   }

   override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
   }

   override fun onPageSelected(p0: Int) {
    when(p0){
     0 -> titlePager.setText("Proyección")
     1 -> titlePager.setText("Proyección")
     2 -> titlePager.setText("Alcance TASO")
     3 -> titlePager.setText("Rank")
    }
   }

  })


 }

 //fun gral
 fun createRowsFake(): ArrayList<SiteModel>{
  return arrayListOf(
   SiteModel("NORTE"),
   SiteModel("SUR"),
   SiteModel("OCCIDENTE"),
   SiteModel("NORESTE"),
   SiteModel("NOROESTE"),
   SiteModel("CENTRO")
  )
 }

 fun setData(){
  nameList.adapter = NameAdapter(createRowsFake())
 }


 //inner classes
 class PagerAdapter(fm: FragmentManager?,private val pageNumber : Int, var titlePager : TextView) : FragmentStatePagerAdapter(fm) {

  //fun override
  override fun getItem(p0: Int): Fragment {
   return when (p0){
    0 -> firtsFragment()
    1 -> secondFragment()
    2 -> thirdFragment()
    3 -> fourthFragment()
    else -> {
     firtsFragment()
    }
   }
  }


  override fun getCount(): Int {
   return pageNumber
  }

  fun firtsFragment() : Fragment{
   val bundle = Bundle()
   val titlesList = arrayListOf("EPRC", "0 - 14", "1 - 29", "30 - 59", "60 - 89")
   val objectsList: ArrayList<SiteModel> = arrayListOf(SiteModel(),SiteModel(),SiteModel(),SiteModel(),SiteModel(), SiteModel())
   bundle.putInt("number_column", 5)
   bundle.putInt("type_fragment", 1)
   bundle.putParcelableArrayList("objects", objectsList)
   bundle.putStringArrayList("titles",titlesList)
   return NothingDoFragment.newInstance(bundle)
  }

  fun secondFragment() : Fragment{
   val bundle = Bundle()
   val titlesList = arrayListOf("0 - 119", "120 - 149", "150 - 179", "90 +", "TASO")
   val objectsList: ArrayList<SiteModel> = arrayListOf(SiteModel(),SiteModel(),SiteModel(),SiteModel(),SiteModel(), SiteModel())
   bundle.putInt("number_column", 5)
   bundle.putInt("type_fragment", 2)
   bundle.putParcelableArrayList("objects", objectsList)
   bundle.putStringArrayList("titles",titlesList)
   return NothingDoFragment.newInstance(bundle)
  }

  fun thirdFragment() : Fragment{
   val bundle = Bundle()
   val titlesList = arrayListOf("EPRC", "0 - 14", "30 - 59", "90 +")
   val objectsList: ArrayList<SiteModel> = arrayListOf(SiteModel(),SiteModel(),SiteModel(),SiteModel(),SiteModel(), SiteModel())
   bundle.putInt("number_column", 4)
   bundle.putInt("type_fragment", 3)
   bundle.putParcelableArrayList("objects", objectsList)
   bundle.putStringArrayList("titles",titlesList)
   return NothingDoFragment.newInstance(bundle)
  }

  fun fourthFragment() : Fragment{
   val bundle = Bundle()
   val titlesList = arrayListOf("EPRC", "0 - 14", "30 - 59", "90 +")
   val objectsList: ArrayList<SiteModel> = arrayListOf(SiteModel(),SiteModel(),SiteModel(),SiteModel(),SiteModel(), SiteModel())
   bundle.putInt("number_column", 4)
   bundle.putInt("type_fragment", 4)
   bundle.putParcelableArrayList("objects", objectsList)
   bundle.putStringArrayList("titles",titlesList)
   return NothingDoFragment.newInstance(bundle)
  }


 }

}
