package com.don.bottomsheetonfragment.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.don.bottomsheetonfragment.MainAdapter
import com.don.bottomsheetonfragment.MdlExample
import com.don.bottomsheetonfragment.R
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.fragment_right.*


class RightFragment : Fragment(), MainAdapter.OnClickItem {

    var dataList: MutableList<MdlExample> = mutableListOf()
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

        dataList.add(0, MdlExample(R.drawable.ic_mtrl_chip_checked_circle, "Benar"))
        dataList.add(0, MdlExample(R.drawable.ic_mtrl_chip_close_circle, "Salah"))

        val linearLayoutManager = LinearLayoutManager(context)
        rv_example.layoutManager = linearLayoutManager
        rv_example.setHasFixedSize(true)
        adapter = MainAdapter(this.context!!, dataList, this)
        rv_example.adapter = adapter

    }


    override fun onClickCard(position: Int) {
//        Toast.makeText(activity, dataList[position].name, Toast.LENGTH_SHORT).show()

        val dialog = BottomSheetDialog(this.activity!!)
        val bottomSheet = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        bottomSheet.btn_dialog.setOnClickListener { dialog.dismiss() }
        bottomSheet.tv_dialog.text =
                String.format(resources.getString(R.string.label_choose), dataList[position].name)
        dialog.setContentView(bottomSheet)
        dialog.show()
    }
}
