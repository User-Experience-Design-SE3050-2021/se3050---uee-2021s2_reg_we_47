package com.example.bocmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnThirdParty,btnBudgetCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThirdParty = findViewById(R.id.btn_thirdParty);
        btnBudgetCalc = findViewById(R.id.btn_Budget);

        btnThirdParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdPartyActivity();
            }
        });

        btnBudgetCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBudgetCalcActivity();
            }
        });
    }

    private void  goToThirdPartyActivity() {
        Intent intent = new Intent(this, ThirdPartyTransactions.class);
        startActivity(intent);
    }

    private void  goToBudgetCalcActivity() {
        Intent intent = new Intent(this, budget_calculator.class);
        startActivity(intent);
    }
}