package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

public class OwnAccTransActivity extends AppCompatActivity {
    Spinner spinner1;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_acc_trans);

        //own account spinner
        spinner1 = (Spinner)findViewById(R.id.spinnerFA);
        adapter = ArrayAdapter.createFromResource(this,R.array.Accounts,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
    }
}