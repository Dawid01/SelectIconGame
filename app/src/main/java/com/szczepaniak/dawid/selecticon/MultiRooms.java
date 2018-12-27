package com.szczepaniak.dawid.selecticon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiRooms extends AppCompatActivity {


    private Button createRoomBtm;
    private LinearLayout roomsLayout;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_rooms);

        firestore = FirebaseFirestore.getInstance();
        createRoomBtm =  findViewById(R.id.CreateRoom);
        roomsLayout = findViewById(R.id.RoomsLayout);
        loadRooms();
        createRoomBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createRoom();
            }
        });
    }


    void loadRooms(){

        firestore.collection("Games").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot document : task.getResult()) {
                        final View room = getLayoutInflater().inflate(R.layout.room_layout, null, false);
                        final TextView name = room.findViewById(R.id.Name);
                        name.setText(document.getId());
                        room.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                joinToRoom(name.getText().toString());
                            }
                        });
                        roomsLayout.addView(room);
                    }
                } else {
                }
            }
        });

    }

    void createRoom(){

        final View popUpView = getLayoutInflater().inflate(R.layout.create_room,
                null);
        final PopupWindow mpopup = new PopupWindow(popUpView, GridLayout.LayoutParams.FILL_PARENT,
                GridLayout.LayoutParams.WRAP_CONTENT, true);
        mpopup.setAnimationStyle(android.R.style.Animation_Dialog);
        mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);

        final EditText roomNameText =  popUpView.findViewById(R.id.RoomName);
        final EditText passwordText =  popUpView.findViewById(R.id.Password);
        final EditText playerNameText =  popUpView.findViewById(R.id.PlayerNick);
        Button createBtm = popUpView.findViewById(R.id.Create);

        createBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String roomName = roomNameText.getText().toString();
                String password = passwordText.getText().toString();
                final String playerName = playerNameText.getText().toString();

                if(roomName != "" && password != "" && playerName != ""){

                    Map<String, Object>  gamers = new HashMap<>();
                    gamers.put(playerName, new ArrayList<Integer>());
                    Map<String, Object> gameRoom = new HashMap<>();
                    gameRoom.put("RoomName", roomName);
                    gameRoom.put("Password", password);
                    gameRoom.put("GameAdministrator", playerName);
                    gameRoom.put("Gamers", gamers);

                    firestore.collection("Games").document(roomName)
                            .set(gameRoom)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    mpopup.dismiss();
                                    Intent multiIntent =  new Intent(MultiRooms.this, MultiGameActivity.class);
                                    multiIntent.putExtra("RoomName", roomName);
                                    multiIntent.putExtra("PlayerName", playerName);
                                    MultiRooms.this.startActivity(multiIntent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                }

            }
        });
    }


    void joinToRoom(String roomName){


    }
}
