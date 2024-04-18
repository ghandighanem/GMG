package com.example.ass_1_1212386;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LogIn_Activity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private Button btnHint;
    private Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(com.example.ass_1_1212386.R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LLogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnHint = findViewById(R.id.btnHint);
        btnConfirm = findViewById(R.id.btnConfirm);

        // Set onClickListener for the Hint button
        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUserName.setText("1111");
                etPassword.setText("1111");
            }
        });

        // Set onClickListener for the Confirm button
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the user entered correct credentials
                if (etUserName.getText().toString().equals("1111") && etPassword.getText().toString().equals("1111")) {
                   if(MainActivity.isStudent == false){
                        // If correct, navigate to the next activity (replace NextActivity.class with your desired activity)

                       Intent intent = new Intent(LogIn_Activity.this, TeacherActivity.class);
                       // Pass the studentList as an extra to the intent

                         startActivity(intent);
                        // Finish the current activity
                        finish();
                   }else{
                       Intent intent = new Intent(LogIn_Activity.this, StudentActivity.class);
                       startActivity(intent);
                       // Finish the current activity
                       finish();
                    }
                } else {
                    // If incorrect, display a toast message
                    Toast.makeText(LogIn_Activity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
