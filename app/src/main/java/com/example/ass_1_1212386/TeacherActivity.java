package com.example.ass_1_1212386;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TeacherActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private EditText editTextName, editTextSubject, editTextMark, editTextAttendance, editTextBehavior;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);



        // Initialize views
        tableLayout = findViewById(R.id.tableLayout);
        editTextName = findViewById(com.example.ass_1_1212386.R.id.editTextName);
        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMark = findViewById(R.id.editTextMark);
        editTextAttendance = findViewById(R.id.editTextAttendance);
        editTextBehavior = findViewById(R.id.editTextBehavior);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentToTable();
            }
        });
    }





    private void addStudentToTable() {
        String name = editTextName.getText().toString();
        String subject = editTextSubject.getText().toString();
        String mark = editTextMark.getText().toString();
        String attendance = editTextAttendance.getText().toString();
        String behavior = editTextBehavior.getText().toString();

        // Create a new row to be added to the table layout
        TableRow row = new TableRow(this);

        // Create text views for each cell in the row
        TextView tvName = new TextView(this);
        tvName.setText(name);

        TextView tvSubject = new TextView(this);
        tvSubject.setText(subject);

        TextView tvMark = new TextView(this);
        tvMark.setText(mark);

        TextView tvAttendance = new TextView(this);
        tvAttendance.setText(attendance);

        TextView tvBehavior = new TextView(this);
        tvBehavior.setText(behavior);

        // Add text views to the row
        row.addView(tvName);
        row.addView(tvSubject);
        row.addView(tvMark);
        row.addView(tvAttendance);
        row.addView(tvBehavior);

        // Add the row to the table layout
        tableLayout.addView(row);
    }






    @Override
    public void onBackPressed() {
        // Save data when back button is pressed
        saveDataToPreferences();
        super.onBackPressed();
    }

    private void saveDataToPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences("TeacherData", MODE_PRIVATE).edit();
        // Save your data to SharedPreferences here
        // Example:
        editor.putString("Name", editTextName.getText().toString());
        editor.putString("Subject", editTextSubject.getText().toString());
        editor.putString("Mark", editTextMark.getText().toString());
        editor.putString("Attendance", editTextAttendance.getText().toString());
        editor.putString("Behavior", editTextBehavior.getText().toString());
        editor.apply();
    }
}