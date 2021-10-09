package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private Button CancleButton,RegisterButton;
    EditText name,uname,debcardno,contact,email;
    String pass = "123456";
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        name = findViewById(R.id.NameinputText);
        uname= findViewById(R.id.UNameinputText);
        debcardno= findViewById(R.id.DebitCardEditTextNumber);
        contact= findViewById(R.id.Contactno);
        email= findViewById(R.id.Email);
        DB = new DBHelper(this);

        //cancle button implementation
        CancleButton = (Button)findViewById(R.id.CancleButton);
        CancleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                cancleReg();
            }
        });

        //register button implementation
        RegisterButton = (Button)findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               String Name = name.getText().toString();
               String UName = uname.getText().toString();
               String Dcno = debcardno.getText().toString();
               String Contact = contact.getText().toString();
               String Email = email.getText().toString();
               String Pass = pass;

               if(TextUtils.isEmpty(Name)||TextUtils.isEmpty(UName)||TextUtils.isEmpty(Dcno)||TextUtils.isEmpty(Contact)||TextUtils.isEmpty(Email)||TextUtils.isEmpty(Pass)){
                   Toast.makeText(RegistrationActivity.this,"All feilds Requiered",Toast.LENGTH_SHORT).show();
               }
               else{
                   Boolean checkuser = DB.checkusername(UName);
                   if(checkuser==false){
                       Boolean insert = DB.insertData(Name,UName,Dcno,Contact,Email,Pass);
                       if(insert==true){
                           Toast.makeText(RegistrationActivity.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                           startActivity(intent);
                       }
                       else{
                           Toast.makeText(RegistrationActivity.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                       }
                   }
                   else{
                       Toast.makeText(RegistrationActivity.this,"User already Exists",Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });

    }

    public void cancleReg(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}