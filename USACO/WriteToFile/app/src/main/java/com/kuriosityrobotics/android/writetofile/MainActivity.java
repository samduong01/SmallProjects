package com.kuriosityrobotics.android.writetofile;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private TextView statusLabel;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusLabel = (TextView) findViewById(R.id.status);
        editText = (EditText) findViewById(R.id.editText);

    }

    public void submitData(View view){
        String data = editText.getText().toString();

        String fileName = "testFile.txt";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName , Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void extractData(){
        String fileName = "myFile";
        Context context = getApplicationContext();

        String data = "";

        try{
            FileInputStream fileInputStream = context.openFileInput(fileName);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lineData = bufferedReader.readLine();

            statusLabel.setText(lineData);
        }catch(Exception e){

        }

        if(data.length() == 0){
            Log.e("Error","No Data..");
        }
    }
}
