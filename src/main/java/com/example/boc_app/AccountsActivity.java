package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccountsActivity extends AppCompatActivity {

    ImageView acc,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounts);

        acc = findViewById(R.id.plus);
        home = findViewById(R.id.home);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountsActivity.this, AddAccountActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountsActivity.this, DashboardActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
    }
}