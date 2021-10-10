package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.boc_app.DataBase.DBHelperContactUsMessage;

public class ContactUsMessageActivity extends AppCompatActivity {

    ImageView call, message, location, atm, home;
    EditText username,email,messagecon,datecon;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_message);

        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        location = findViewById(R.id.location);
        atm = findViewById(R.id.atm);
        home = findViewById(R.id.home);
        send = findViewById(R.id.sendcon);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        messagecon = findViewById(R.id.messagecon);
        datecon = findViewById(R.id.datecon);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsMessageActivity.this, DashboardActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsMessageActivity.this, ContactUsCallActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsMessageActivity.this, ContactUsMessageActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsMessageActivity.this, ContactUsLocationActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsMessageActivity.this, ContactUsNearestAtmActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelperContactUsMessage dbHelper = new DBHelperContactUsMessage(getApplicationContext());
                long newID = dbHelper.addInfo(username.getText().toString(), email.getText().toString(), messagecon.getText().toString(), datecon.getText().toString());
                Toast.makeText(ContactUsMessageActivity.this, "User Successfully Added..Hospital ID is " + newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), ContactUsMessageActivity.class);
                startActivity(i);

                username.setText(null);
                email.setText(null);
                messagecon.setText(null);
                datecon.setText(null);
            }
        });


    }
}