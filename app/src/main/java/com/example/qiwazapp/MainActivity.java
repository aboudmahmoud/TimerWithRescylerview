package com.example.qiwazapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //TextView tv_email, tv_passord;
    Button btnLogin;
    TextInputEditText tv_passord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_passord= findViewById(R.id.textField);

        btnLogin =(Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                String password =""+tv_passord.getText();
                if (password.equals("1234"))
                {
                    Intent i =new Intent(MainActivity.this,Winlattery.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "Password Is Worng"+ password,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}