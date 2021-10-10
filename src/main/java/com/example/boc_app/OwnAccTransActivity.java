package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

public class OwnAccTransActivity extends AppCompatActivity {
    private Button PayNow,Cancel;
    private ImageView backhome,profile;
    Spinner spinner1,spinner2,spinner3;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_acc_trans);

        //From account spinner1
        spinner1 = (Spinner)findViewById(R.id.spinnerFA);
        adapter = ArrayAdapter.createFromResource(this,R.array.Accounts,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);

        //To account spinner2
        spinner2 = (Spinner)findViewById(R.id.spinnerTA);
        adapter = ArrayAdapter.createFromResource(this,R.array.Accounts,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);

        //Transfer Type spinner3
        spinner3 = (Spinner)findViewById(R.id.spinnerTT);
        adapter = ArrayAdapter.createFromResource(this,R.array.TransferTypes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter);


        //Navigate to Otp
        PayNow = (Button) findViewById(R.id.paynowButton);
        PayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Otp2Activity.class);
                startActivity(intent);
            }
        });

        //Navigate to profile
        Cancel = (Button) findViewById(R.id.CancleOwnButton);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });

        //Navigate to profile
        profile = (ImageView) findViewById(R.id.OWprofile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                startActivity(intent);
            }
        });

        //Navigate to dashboard
        backhome = (ImageView) findViewById(R.id.OWback_home);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}