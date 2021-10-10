package com.example.bocmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class confirm_transfer_details extends AppCompatActivity {

    Button payNow,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_transfer_details);

        //get the intent in the target activity
            Intent intent = getIntent();

        //get the attached bundle from the intent
            Bundle extras = intent.getExtras();

        //Extracting the stored data from the bundle

            String account = extras.getString("ACCOUNT");
            String beneficName = extras.getString("BENEFIC_NAME");
            String beneficAccount = extras.getString("BENEFIC_ACC");
            String bank= extras.getString("BANK");
            String branch = extras.getString("BRANCH");
            String transAmount = extras.getString("TRANS_AMOUNT");
            String transDate= extras.getString("TRANS_DATE");
            String transDesc = extras.getString("TRANS_DESC");

            TextView tv_account = findViewById(R.id.tv_account);
            TextView tv_beneficName = findViewById(R.id.tv_beneficiaryName);
            TextView tv_beneficAccount = findViewById(R.id.tv_beneficiaryAccount);
            TextView tv_bank= findViewById(R.id.tv_bank);
            TextView tv_branch = findViewById(R.id.tv_branch);
            TextView tv_transAmount = findViewById(R.id.tv_transferAmount);
            TextView tv_transDate = findViewById(R.id.tv_transDate);
            TextView tv_transDesc = findViewById(R.id.tv_transDesc);

            tv_account.setText(account);
            tv_beneficName.setText(beneficName);
            tv_beneficAccount.setText(beneficAccount);
            tv_bank.setText(bank);
            tv_branch .setText(branch);
            tv_transAmount.setText(transAmount);
            tv_transDate.setText(transDate);
            tv_transDesc.setText(transDesc);

            addListenerOnButtonPayNow();
            addListenerOnButtonCancel();

    }

    public void addListenerOnButtonPayNow(){
        payNow = findViewById(R.id.pay_now_transfer);

        payNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(confirm_transfer_details.this, "Transaction processing..", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(confirm_transfer_details.this,ThirdPartyTransactions.class);
                startActivity(intent);
            }
        });

    }

    public void addListenerOnButtonCancel(){
        cancel = findViewById(R.id.cancel_transfer);

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(confirm_transfer_details.this, "Transaction cancelled..", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(confirm_transfer_details.this,ThirdPartyTransactions.class);
                startActivity(intent);
            }
        });


    }
}