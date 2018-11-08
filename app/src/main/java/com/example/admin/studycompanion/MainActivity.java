package com.example.admin.studycompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Activity2.class);
                startActivity(intent);
            }
        });
    }

    public void onSubmit(View v) {
        EditText name = findViewById(R.id.Name);
        EditText password = findViewById(R.id.Password);
//TODO:check db
        if (name.getText().length() == 0 || password.getText().length() < 6) {
            if (name.getText().length() == 0) {
                Toast.makeText(MainActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "minimum password length is 6", Toast.LENGTH_SHORT).show();
            }
        } else {
            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
            finish();
            startActivity(intent);
        }
    }
}
