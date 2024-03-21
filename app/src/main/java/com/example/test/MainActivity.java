package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    CheckBox cb;
    Button btn;

    private EditText editTextFullName, editTextPhone, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);

        editTextFullName = findViewById(R.id.name);
        editTextPhone = findViewById(R.id.phone);
        editTextEmail = findViewById(R.id.mail);
        editTextPassword = findViewById(R.id.password);


        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    btn.setEnabled(true);
                    btn.setBackgroundColor(Color.rgb(5,96,250));

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sendData();
                            Intent intent = new Intent(MainActivity.this, homePage.class);
                            startActivity(intent);
                        }
                    });

                } else {
                    btn.setEnabled(false);
                    btn.setBackgroundColor(Color.rgb(167,167,167));
                }
            }
        });

    }


    public void sendData(){
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");

                String jsonBody = "{\n" +
                        "  \"full_name\": \"" + editTextFullName.getText().toString() + "\",\n" +
                        "  \"email\": \"" + editTextEmail.getText().toString() + "\",\n" +
                        "  \"phone\": \"" + editTextPhone.getText().toString() + "\",\n" +
                        "  \"password\": \"" + editTextPassword.getText().toString() + "\"\n" +
                        "}";

                RequestBody requestBody = RequestBody.create(mediaType, jsonBody);

                String BAseURL = "https://lljhicvcfhuosyshhzam.supabase.co/rest/v1/";

                String apikey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImxsamhpY3ZjZmh1b3N5c2hoemFtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg2MDYxNjYsImV4cCI6MjAyNDE4MjE2Nn0.Q0kY_4TLumR8nzwfY4dvzRYHnL995hVmUjs5R_aBXls";

                Request request = new Request.Builder()
                        .url(BAseURL + "users")
                        .header("apikey", apikey)
                        .post(requestBody)
                        .build();

                try {
                    client.newCall(request).execute();
                    finish(); // Закрыть активность после добавления пользователя
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}