package com.szczepaniak.dawid.selecticon;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.util.ExecutorEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MultiGameActivity extends AppCompatActivity {

    private String roomName;
    private String playerName;

    private String players;

    private TextView playersListText;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);
        firestore =  FirebaseFirestore.getInstance();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            roomName = extras.getString("RoomName");
            playerName = extras.getString("PlayerName");
        }

        playersListText =  findViewById(R.id.PlayerList);
        players = "Room name: " + roomName + "\n" + "Players: " + "\n";
        playersListText.setText(players);
        updatePlayersList();

    }

    void updatePlayersList(){

        firestore.collection("Games")
                .document(roomName)
                .addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                Map<String, Object> gamers = ( Map<String, Object>) documentSnapshot.get("Gamers");
                String playerList = players;
                for(String player : gamers.keySet()){

                    playerList = playerList + "\n" + player;
                }

                playersListText.setText(playerList);

            }
        });
    }


}
