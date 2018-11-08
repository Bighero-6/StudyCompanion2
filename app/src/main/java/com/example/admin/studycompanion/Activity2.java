package com.example.admin.studycompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onRegister(View v) {
        //TODO:create user
        EditText name = findViewById(R.id.name);
        EditText pwd = findViewById(R.id.password);
        EditText cpwd = findViewById(R.id.confirmpassword);
        EditText email = findViewById(R.id.email);
        boolean validname = name.getText().length() > 0;
        boolean validpass = pwd.getText().length() >= 6;
        boolean passmatch = pwd.getText().toString().equals(cpwd.getText().toString());
        boolean validemail = true;
        if (validname) {
            if (validpass) {
                if (passmatch) {
                    if (validemail) {
                        FirebaseConnector a = new FirebaseConnector(getApplicationContext());
                        if(a.signup(email.getText().toString(), pwd.getText().toString())){
                        Intent i = new Intent(getBaseContext(), HomeActivity.class);
                        finish();
                        startActivity(i);}
                        else{
                            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Passwords doesnt Match", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "minimum password length is 6", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
