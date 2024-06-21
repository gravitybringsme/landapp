package com.neppplus.landapp

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.neppplus.landapp.adapters.RoomAdapter
import com.neppplus.landapp.datas.Room

class MainActivity : AppCompatActivity() {

    val mRoomList= ArrayList<Room>()

    lateinit var mRoomAdapter : RoomAdapter

    //https://trello.com/b/gpMbw16H/%EC%BD%94%EB%94%A9%ED%8B%B0%EC%B2%98-%EC%A7%80%EB%8B%88-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mRoomList.add( Room(7500, "서울시 동대문구", 8, "동대문구의 8층 7500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구", 0, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구2", 1, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구3", 2, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구4", 3, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구5", 4, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구6", 5, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구7", 6, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구8", 7, "서대문구의 반지하 2억 4500만원 방입니다."))
        mRoomList.add( Room(24500, "서울시 서대문구9", 8, "서대문구의 반지하 2억 4500만원 방입니다."))

        mRoomAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)

        val roomListView = findViewById<ListView>(R.id.roomListView)
        roomListView.adapter = mRoomAdapter
        roomListView.setOnItemClickListener { parent, view, position, id ->

            val clickedRoom = mRoomList[position]
            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)

            myIntent.putExtra("room", clickedRoom)
            startActivity(myIntent)

        }
    }
}