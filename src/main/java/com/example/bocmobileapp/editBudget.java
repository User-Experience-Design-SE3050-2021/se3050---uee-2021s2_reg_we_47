package com.example.bocmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class editBudget extends AppCompatActivity {

    Button saveBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_budget);

        addListenerOnButtonSaveBudget();

    }

    public void addListenerOnButtonSaveBudget(){
        saveBudget = findViewById(R.id.btn_saveBudget);

        saveBudget.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(editBudget.this, "saved budget", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(editBudget.this,budget_calculator.class);
                startActivity(intent);
            }
        });
    }
}