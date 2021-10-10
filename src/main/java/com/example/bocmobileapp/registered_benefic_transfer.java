package com.example.bocmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class registered_benefic_transfer extends AppCompatActivity {

    Spinner spinnerAccounts, spinnerBeneficiary;
    EditText transferAmount,transferDate,transferDesc;
    Button next,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_benefic_transfer);

        addItemsOnSpinnerAccounts();
        addItemsOnSpinnerBeneficiary();
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
    public void addItemsOnSpinnerBeneficiary(){

        spinnerBeneficiary = (Spinner) findViewById(R.id.beneficiary_list);
        List<String> list = new ArrayList<String>();
        list.add("Beneficiary 1");
        list.add("Beneficiary 2");
        list.add("Beneficiary 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBeneficiary.setAdapter(dataAdapter);

    }
    public void addListenerOnButtonNext(){
        transferAmount = findViewById(R.id.en_transAmount);
        transferDate = findViewById(R.id.en_transDate);
        transferDesc = findViewById(R.id.en_transDesc);

        spinnerAccounts = (Spinner) findViewById(R.id.account_list_oneTime);
        spinnerBeneficiary = (Spinner) findViewById(R.id.beneficiary_list);

        next = findViewById(R.id.btn_next);


        next.setOnClickListener(new View.OnClickListener() {

            String transAmount = transferAmount.getText().toString();
            String transDate = transferDate.getText().toString();
            String transDesc = transferDesc.getText().toString();


            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                bundle.putString("TRANS_AMOUNT",transAmount);
                bundle.putString("TRANS_DATE", transDate);
                bundle.putString("TRANS_DESC", transDesc);

                Intent intent = new Intent(registered_benefic_transfer.this, confirm_transfer_details.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public void addListenerOnButtonCancel(){

        cancel = findViewById(R.id.btn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(registered_benefic_transfer.this, "cancelled..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(registered_benefic_transfer.this,ThirdPartyTransactions.class);
                startActivity(intent);
            }
        });

    }
}