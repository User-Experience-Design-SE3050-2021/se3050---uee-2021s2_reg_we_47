package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BillPaymentHomeActivity extends AppCompatActivity {

    ImageView home, addbiller, mobitelbill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_payment_home);

        home = findViewById(R.id.home);
        addbiller = findViewById(R.id.addbiller);
        mobitelbill = findViewById(R.id.mobitelbill);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });
        addbiller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddNewBillerActivity.class);
                startActivity(intent);
            }
        });
        mobitelbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BillPaymentFormActivity.class);
                startActivity(intent);
            }
        });
    }
}