package com.example.reqdemofisa


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.adapter.RecyclerViewPagerAdapter
import com.example.reqdemofisa.model.SiteModel
import kotlinx.android.synthetic.main.fragment_nothing_do.*


class NothingDoFragment : Fragment() {

 //numberColumns
 var numberColumns = 0
 var titlesList  : ArrayList<String> = arrayListOf()
 val defaultTitles = arrayListOf("EPRC", "0-14", "1-29", "30-59", "60-89")
 var objectsList: ArrayList<SiteModel> = arrayListOf(SiteModel(),SiteModel(),SiteModel(),SiteModel(),SiteModel(), SiteModel())
 var typeAdapter = 1

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)

  //getBundle
  numberColumns = arguments?.getInt("number_column") ?: 5
  titlesList = arguments?.getStringArrayList("titles") ?: defaultTitles
  objectsList = arguments!!.getParcelableArrayList("objects")
  typeAdapter = arguments?.getInt("type_fragment") ?: 1

 }

 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  // Inflate the layout for this fragment
  return inflater.inflate(R.layout.fragment_nothing_do, container, false)
 }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  //setNumberColumns
  setTitles(numberColumns)

  //setDataTable
  dataRecycler.adapter = RecyclerViewPagerAdapter(objectsList,typeAdapter)

 }

 //companion
 companion object {
  fun newInstance(bundle : Bundle) : NothingDoFragment{
   var fragment = NothingDoFragment()
   if(bundle != null){
    fragment.arguments = bundle
   }
   return fragment
  }
 }

 //gral methods
 fun setTitles(numberColumns : Int){


  //columns titles
  if(numberColumns != 5){
   fifthColumn.visibility = View.GONE
   firstColumn.text = titlesList[0]
   secondColumn.text = titlesList[1]
   thirdColumn.text = titlesList[2]
   fourthColumn.text = titlesList[3]
  }else{
   firstColumn.text = titlesList[0]
   secondColumn.text = titlesList[1]
   thirdColumn.text = titlesList[2]
   fourthColumn.text = titlesList[3]
   fifthColumn.text = titlesList[4]
  }
 }
}
