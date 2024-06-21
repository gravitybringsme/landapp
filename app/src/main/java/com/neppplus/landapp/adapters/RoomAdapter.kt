package com.neppplus.landapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.ActionBarContextView
import com.neppplus.landapp.R
import com.neppplus.landapp.datas.Room

class RoomAdapter(val mContext: Context,
                  val resId: Int,
                  val mList:ArrayList<Room>) : ArrayAdapter<Room>(mContext,resId,mList) {

                      val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null){
            tempRow = inflater.inflate(R.layout.room_list_item, null)
        }

        val row = tempRow!!

        val roomData = mList[position]

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

        descriptionTxt.text = roomData.description
        addressAndFloorTxt.text = roomData.address

        return row
    }
}