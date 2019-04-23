package com.example.reqdemofisa


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.reqdemofisa.adapter.RecyclerTableAdapter
import com.example.reqdemofisa.model.TableModel
import kotlinx.android.synthetic.main.fragment_recycler_table.*

/**
 * A simple [Fragment] subclass.
 *
 */
class RecyclerTableFragment : Fragment() {

    //variables
    var arrayList: ArrayList<TableModel> = arrayListOf()
    var typeView: String = ""

    val TYPE_RECYCLER = "type_recycler"
    val LIST = "array_list"
    val FIRS_PAGE = "first_page"
    val SECOND_PAGE = "second_page"

    companion object {
        fun newInstance(bundle: Bundle): RecyclerTableFragment{
            val fragment = RecyclerTableFragment()
            if (bundle != null){
                fragment.arguments = bundle
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //getBundle
        arrayList = arguments!!.getParcelableArrayList(LIST)
        typeView = arguments?.getString(TYPE_RECYCLER) ?: FIRS_PAGE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(typeView) {
            FIRS_PAGE -> table_recycler_view.adapter = RecyclerTableAdapter(arrayList, FIRS_PAGE)
            SECOND_PAGE -> table_recycler_view.adapter = RecyclerTableAdapter(arrayList, SECOND_PAGE)
        }

    }

}
