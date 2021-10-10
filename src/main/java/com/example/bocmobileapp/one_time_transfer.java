package com.example.bocmobileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class one_time_transfer extends AppCompatActivity {
    Spinner spinnerAccounts;
    EditText beneficiaryName,beneficiaryAccNo,bank,branch,transferAmount,transferDate,transferDesc;
    Button next,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_transfer);

        addItemsOnSpinnerAccounts();
        addListenerOnButtonNext();
        addListenerOnButtonCancel();
    }

    public void addItemsOnSpinnerAccounts(){
        spinnerAccounts = (Spinner) findViewById(R.id.account_list_oneTime);
        List<String> list = new ArrayList<String>();
        list.add("Account 1");
        list.add("Account 2");
        list.add("Account 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAccounts.setAdapter(dataAdapter);
    }

    public void addListenerOnButtonNext(){
        spinnerAccounts = (Spinner) findViewById(R.id.account_list_oneTime);
        beneficiaryName = findViewById(R.id.en_beneficiary_name);
        beneficiaryAccNo=findViewById(R.id.en_beneficiary_account);
        bank=findViewById(R.id.en_bank_name);
        branch =findViewById(R.id.en_branch_name);
        transferAmount = findViewById(R.id.en_trans_amount);
        transferDate = findViewById(R.id.en_trans_date);
        transferDesc = findViewById(R.id.en_trans_desc);

        next = findViewById(R.id.btn_next_oneTime);

        next.setOnClickListener(new View.OnClickListener() {

            String Account= spinnerAccounts.getSelectedItem().toString();
            String beneficName = beneficiaryName.getText().toString();
            String beneficAccount = beneficiaryAccNo.getText().toString();
            String Bank=bank.getText().toString();
            String Branch=branch.getText().toString();
            String transAmount = transferAmount.getText().toString();
            String transDate = transferDate.getText().toString();
            String transDesc = transferDesc.getText().toString();


            @Override
            public void onClick(View view) {

                //create a Bundle object
                Bundle extras = new Bundle();

            //Adding key value pairs to this bundle
            //there are quite a lot data types you can store in a bundle
                extras.putString("ACCOUNT",Account);
                extras.putString("BENEFIC_NAME",beneficName);
                extras.putString("BENEFIC_ACC", beneficAccount);
                extras.putString("BANK",Bank);
                extras.putString("BRANCH",Branch);
                extras.putString("TRANS_AMOUNT",transAmount);
                extras.putString("TRANS_DATE", transDate);
                extras.putString("TRANS_DESC", transDesc);

                //create and initialize an intent
                Intent intent = new Intent(one_time_transfer.this, confirm_transfer_details.class);

                //attach the bundle to the Intent object
                intent.putExtras(extras);

                //finally start the activity
                startActivity(intent);


            }
        });

    }

    public void addListenerOnButtonCancel(){
        cancel = findViewById(R.id.btn_cancel_oneTime);

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(one_time_transfer.this, "cancelled..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(one_time_transfer.this,ThirdPartyTransactions.class);
                startActivity(intent);
            }
        });
    }
}