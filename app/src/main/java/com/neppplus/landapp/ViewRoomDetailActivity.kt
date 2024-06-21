package com.neppplus.landapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.neppplus.landapp.datas.Room

class ViewRoomDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_room_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val roomData = intent.getSerializableExtra("room") as Room

//        val priceTxt = LayoutInflater.from(this).inflate(R.layout.activity_view_room_detail, null).findViewById<TextView>(R.id.priceTxt)
//        val decriptionTxt = LayoutInflater.from(this).inflate(R.layout.activity_view_room_detail, null).findViewById<TextView>(R.id.descriptionTxt)
//        val addressTxt = LayoutInflater.from(this).inflate(R.layout.activity_view_room_detail, null).findViewById<TextView>(R.id.addressTxt)
//        val floorTxt = LayoutInflater.from(this).inflate(R.layout.activity_view_room_detail, null).findViewById<TextView>(R.id.floorTxt)

        val priceTxt = findViewById<TextView>(R.id.priceTxt)
        val decriptionTxt = findViewById<TextView>(R.id.descriptionTxt)
        val addressTxt = findViewById<TextView>(R.id.addressTxt)
        val floorTxt = findViewById<TextView>(R.id.floorTxt)


        priceTxt.text = roomData.getFormattedPrice()
        decriptionTxt.text = roomData.description
        addressTxt.text = roomData.address
        floorTxt.text = roomData.getFormattedFloor()
    }
}