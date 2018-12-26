package com.szczepaniak.dawid.selecticon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.PopupWindow;

public class MultiRooms extends AppCompatActivity {


    private Button createRoomBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_rooms);

        createRoomBtm =  findViewById(R.id.CreateRoom);

        createRoomBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View popUpView = getLayoutInflater().inflate(R.layout.create_room,
                        null);
                PopupWindow mpopup = new PopupWindow(popUpView, GridLayout.LayoutParams.FILL_PARENT,
                        GridLayout.LayoutParams.WRAP_CONTENT, true);
                mpopup.setAnimationStyle(android.R.style.Animation_Dialog);
                mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);


            }
        });
    }
}
