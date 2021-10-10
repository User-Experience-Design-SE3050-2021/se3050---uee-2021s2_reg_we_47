package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContactUsNearestAtmActivity extends AppCompatActivity {

    ImageView call, message, location, atm, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_nearest_atm);

        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        location = findViewById(R.id.location);
        atm = findViewById(R.id.atm);
        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsNearestAtmActivity.this, DashboardActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsNearestAtmActivity.this, ContactUsCallActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsNearestAtmActivity.this, ContactUsMessageActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsNearestAtmActivity.this, ContactUsLocationActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsNearestAtmActivity.this, ContactUsNearestAtmActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
    }
}