package com.example.bocmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdPartyTransactions extends AppCompatActivity {

    Button OneTimeTransfer,regBeneficiaries,manageBeneficiaries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_transactions);

        OneTimeTransfer = findViewById(R.id.btn_oneTime);
        regBeneficiaries = findViewById(R.id.btn_regBenefic);
        manageBeneficiaries = findViewById(R.id.btn_manageBenefic);

        OneTimeTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOneTimeActivity();
            }
        });

        regBeneficiaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegBeneficActivity();
            }
        });

    }

    private void  goToOneTimeActivity(){
        Intent intent = new Intent(this, one_time_transfer.class);
        startActivity(intent);
    }

    private void  goToRegBeneficActivity(){
        Intent intent = new Intent(this, registered_benefic_transfer.class);
        startActivity(intent);
    }


}