package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Otp2Activity extends AppCompatActivity {

    private Button Confirm,Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_2);

        //Navigate to Login
        Confirm = (Button) findViewById(R.id.confirmButton2);
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Otp2Activity.this, " Transaction Successful!", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        //Navigate to profile
        Cancel = (Button) findViewById(R.id.otp2CancleButton);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OwnAccTransActivity.class);
                startActivity(intent);
            }
        });
    }
}