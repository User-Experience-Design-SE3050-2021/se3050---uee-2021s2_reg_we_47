package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContactUsCallActivity extends AppCompatActivity {

    ImageView call, message, loc, atm, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us_call);

        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        loc = findViewById(R.id.location);
        atm = findViewById(R.id.atm);
        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsCallActivity.this, DashboardActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsCallActivity.this, ContactUsCallActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsCallActivity.this, ContactUsMessageActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsCallActivity.this, ContactUsLocationActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactUsCallActivity.this, ContactUsNearestAtmActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
    }
}