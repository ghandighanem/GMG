package com.example.ass_1_1212386;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private List<Double> marksList = new ArrayList<>();
    private EditText editTextSubject;
    private EditText editTextMark;
    private Button btnAdd;
    private Button btnCalculateAverage;
    private TextView textViewAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMark = findViewById(R.id.editTextMark);
        btnAdd = findViewById(R.id.btnAdd);
        btnCalculateAverage = findViewById(R.id.btnCalculateAverage);
        textViewAverage = findViewById(R.id.textViewAverage);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubjectAndMark();
            }
        });

        btnCalculateAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    public void addSubjectAndMark() {
        String subject = editTextSubject.getText().toString();
        String markString = editTextMark.getText().toString();

        if (!subject.isEmpty() && !markString.isEmpty()) {
            double mark = Double.parseDouble(markString);
            marksList.add(mark);
            editTextSubject.setText("");
            editTextMark.setText("");

            if (marksList.size() > 1) {
                btnCalculateAverage.setVisibility(View.VISIBLE);
            }
            // Show the "Added successfully" message
            TextView textViewMessage = findViewById(R.id.textViewMessage);
            textViewMessage.setVisibility(View.VISIBLE);
        }
    }

    public void calculateAverage() {
        double sum = 0;
        for (Double mark : marksList) {
            sum += mark;
        }
        double average = sum / marksList.size();
        textViewAverage.setText("Average: " + String.format("%.2f", average));
        textViewAverage.setVisibility(View.VISIBLE);
    }
}
