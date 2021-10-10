package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button registerButton,loginButton;
    EditText username,password;
    TextView forgotps;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.UsernameLogin);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        DB = new DBHelper(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = username.getText().toString();
                String Password = password.getText().toString();

                if(TextUtils.isEmpty(Username)||TextUtils.isEmpty(Password)){
                    Toast.makeText(LoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT ).show();
                }
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(Username,Password);
                    if(checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT ).show();
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login failed! Wrong username or password.", Toast.LENGTH_SHORT ).show();
                    }
                }
            }
        });

        registerButton = (Button)findViewById(R.id.registerNowButton);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registration();
            }
        });

        forgotps = (TextView) findViewById(R.id.forgotPtextView);
        forgotps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ChangePassword2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void registration(){
        Intent intent = new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }
}