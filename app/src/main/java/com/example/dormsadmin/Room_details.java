package com.example.dormsadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Room_details extends AppCompatActivity {
    EditText mroom_name,mrent;
    Button maddroom_det;

    String[] items = {"2","3","4","5","6"};

    AutoCompleteTextView mbeds;
    ArrayAdapter<String> adapterItem;

    FirebaseFirestore firestore;

    String bedsSt = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        mroom_name = findViewById(R.id.room_name);
        mrent = findViewById(R.id.rent);
        maddroom_det = findViewById(R.id.addroom_det);

        mbeds = findViewById(R.id.beds);

        firestore = FirebaseFirestore.getInstance();

        adapterItem = new ArrayAdapter<String>(this,R.layout.list_item,items);
        mbeds.setAdapter(adapterItem);

        mbeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Room_details.this, "Selected "+items[i], Toast.LENGTH_SHORT).show();
                bedsSt = items[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        maddroom_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Toast.makeText(Room_details.this, "Clicked", Toast.LENGTH_SHORT).show();
                    Rooms_data rooms_data = new Rooms_data();
                    rooms_data.setName(mroom_name.getText().toString());
                    rooms_data.setRent(mrent.getText().toString());
                    rooms_data.setBeds(mbeds.getText().toString());
                    rooms_data.setRoomId(System.currentTimeMillis() + "");

                    firestore.collection("Room").document(rooms_data.getRoomId())
                            .set(rooms_data)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Room_details.this, " Room added successfully", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(Room_details.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }catch (Exception e){
                    Log.e("555", "onClick: ",e );
                }
            }

        });


    }

}