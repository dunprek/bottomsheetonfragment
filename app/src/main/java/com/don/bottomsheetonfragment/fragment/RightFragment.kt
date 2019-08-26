package com.don.bottomsheetonfragment.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.don.bottomsheetonfragment.MainAdapter
import com.don.bottomsheetonfragment.R
import com.don.bottomsheetonfragment.mdl.ItemsItem
import kotlinx.android.synthetic.main.fragment_right.*


@SuppressLint("ValidFragment")
class RightFragment(items: List<ItemsItem>?) : Fragment(), MainAdapter.OnClickItem {


    var dataList: MutableList<ItemsItem> = items as MutableList<ItemsItem>

    lateinit var adapter: MainAdapter


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false)
    }

    @SuppressLint("PrivateResource")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dataList.add(0, MdlExample(R.drawable.ic_mtrl_chip_checked_circle, "Benar"))
//        dataList.add(0, MdlExample(R.drawable.ic_mtrl_chip_close_circle, "Salah"))


        val linearLayoutManager = LinearLayoutManager(context)
        rv_example.layoutManager = linearLayoutManager
        rv_example.setHasFixedSize(true)
        adapter = MainAdapter(this.context!!, dataList, this)
        rv_example.adapter = adapter

    }


    override fun onClickCard(position: Int) {
//
    }
}
