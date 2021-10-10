package com.example.bocmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class budget_calculator extends AppCompatActivity {
    private static final String TAG = "CardListActivity";
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;

    Button editBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_calculator);

        editBudget = findViewById(R.id.btn_editBudget);

        editBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOneTimeEditBudgetActivity();
            }
        });

    }

    private void   goToOneTimeEditBudgetActivity(){
        Intent intent = new Intent(this, editBudget.class);
        startActivity(intent);
    }
}