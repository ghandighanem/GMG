package com.example.ass_1_1212386;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ass_1_1212386.LogIn_Activity;
import com.example.ass_1_1212386.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button studentButton;
    private Button teacherButton;
    public static boolean isStudent = false ;
    private ArrayList<Student> studentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(com.example.ass_1_1212386.R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        studentButton = findViewById(R.id.btn1);
        teacherButton = findViewById(R.id.btn2);

        // Set onClickListeners for the buttons
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            isStudent = true;
                // Start LoginActivity
                startActivity(new Intent(MainActivity.this, LogIn_Activity.class));
            }
        });

        teacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStudent = false;
                // Start LoginActivity
                Intent intent  = new Intent(MainActivity.this, LogIn_Activity.class);
                startActivity(intent);
            }
        });
    }
}
