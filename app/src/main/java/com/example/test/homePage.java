package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class homePage extends AppCompatActivity {

    EditText enterEMail1;
    EditText enterEMail2;
    EditText enterEMail3;
    EditText enterEMail4;
    EditText enterEMail5;
    EditText enterEMail6;
    TextView timer;
    int code=111111;

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        enterEMail1 = findViewById(R.id.enterEMail1);
        enterEMail2 = findViewById(R.id.enterEMail2);
        enterEMail3 = findViewById(R.id.enterEMail3);
        enterEMail4 = findViewById(R.id.enterEMail4);
        enterEMail5 = findViewById(R.id.enterEMail5);
        enterEMail6 = findViewById(R.id.enterEMail6);
        timer = findViewById(R.id.timer);

        btn = findViewById(R.id.buttonVer);

        enterEMail1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((s.length()>0)){
                    enterEMail2.requestFocus();
                }
            }
        });
        enterEMail2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((s.length()>0)){
                    enterEMail3.requestFocus();
                }
            }
        });
        enterEMail3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((s.length()>0)){
                    enterEMail4.requestFocus();
                }
            }
        });
        enterEMail4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((s.length()>0)){
                    enterEMail5.requestFocus();
                }
            }
        });
        enterEMail5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((s.length()>0)){
                    enterEMail6.requestFocus();
                }
            }
        });


    }

    public void checkCode(View view){
        String inputCode;
        inputCode=enterEMail1.getText().toString()+enterEMail2.getText()+enterEMail3.getText()+enterEMail4.getText()+enterEMail5.getText()+enterEMail6.getText();

        if(inputCode.equals(String.valueOf(code))){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( homePage.this, newPassword.class);
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();
        }
    }

}