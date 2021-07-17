package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtlogin = findViewById(R.id.myTextView);
        EditText password = findViewById(R.id.editTextTextPassword);
        EditText username =findViewById(R.id.editTextTextEmailAddress);
        button= findViewById(R.id.button);
        TextView invalid = findViewById(R.id.textView);
        invalid.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().equals("admin") &&
                        username.getText().toString().equals("admin")) {
                    openActivity2();
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();
                    invalid.setVisibility(View.VISIBLE);
                    invalid.setBackgroundColor(Color.RED);
                    counter--;
                    invalid.setText(Integer.toString(counter));

                    if (counter == 0) {
                        button.setEnabled(false);
                    }
                }
            }
        });
    }

    private void openActivity2() {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}