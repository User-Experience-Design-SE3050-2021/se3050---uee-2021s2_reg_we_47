package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.boc_app.DataBase.DBHelperAddAccount;

public class AddAccountActivity extends AppCompatActivity {

    Button cancel,done;
    ImageView home;
    EditText type,holder_name,acc_number,branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);

        cancel = findViewById(R.id.rechargecreditback);
        home = findViewById(R.id.home);
        done = findViewById(R.id.sendcon);

        type = findViewById(R.id.type);
        holder_name = findViewById(R.id.email);
        acc_number = findViewById(R.id.number);
        branch = findViewById(R.id.branchacc);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAccountActivity.this, DashboardActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAccountActivity.this, AccountsActivity.class);
                //String Vemaill  = verify;
                //intent.putExtra("Verify", Vemaill );
                startActivity(intent);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelperAddAccount dbHelper = new DBHelperAddAccount(getApplicationContext());
                long newID = dbHelper.addInfo(type.getText().toString(), holder_name.getText().toString(), acc_number.getText().toString(), branch.getText().toString());
                Toast.makeText(AddAccountActivity.this, "User Successfully Added..Hospital ID is " + newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), AddAccountActivity.class);
                startActivity(i);

                type.setText(null);
                holder_name.setText(null);
                acc_number.setText(null);
                branch.setText(null);
            }
        });
    }
}