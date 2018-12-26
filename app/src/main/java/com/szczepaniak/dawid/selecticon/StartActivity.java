package com.szczepaniak.dawid.selecticon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button singlePlayerBtm;
    private Button multiplayerBtm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        singlePlayerBtm = findViewById(R.id.SingleplayerBtm);
        multiplayerBtm = findViewById(R.id.MultiplayerBtm);

        singlePlayerBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent singleIntent =  new Intent(StartActivity.this, MainActivity.class);
                StartActivity.this.startActivity(singleIntent);
            }
        });

        multiplayerBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent multiIntent =  new Intent(StartActivity.this, MultiRooms.class);
                StartActivity.this.startActivity(multiIntent);
            }
        });

    }
}
