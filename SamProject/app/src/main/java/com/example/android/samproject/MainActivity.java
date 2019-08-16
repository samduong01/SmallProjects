package com.example.android.samproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    public static ArrayList<String> items = new ArrayList<>();

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("Users");

    public static int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
        Button request = (Button) findViewById(R.id.buttonPlay);

        request.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bool
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);

                String text = editText.getText().toString();

                items.add(text);
                if(count==1){
                    editText.setHint("Enter Name");
                    editText.setText("");
                }else if(count==2){
                    editText.setHint("Enter email");
                    editText.setText("");
                }else if(count==3){
                    writeNewUser(items.get(0),items.get(1),items.get(2));
                    items.removeAll(items);
                    editText.setText("");
                    editText.setHint("Enter ID");
                    count=0;
                }
                count++;
            }
        });


//        myRef.setValue("classical");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        myRef.child("users").child(userId).setValue(user);
    }
}
