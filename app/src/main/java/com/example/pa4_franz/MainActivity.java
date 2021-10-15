/*
Author: Tanner Franz
Class: CPSC 312-02
Assignment: PA4
Last Edited: 10/15/2021
Description: Calculates the needed score of a weighted final exam based on
             desired grade percentage and current grade percentage
 */


package com.example.pa4_franz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double calculatedGrade=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Grade Calculator");
        EditText desiredLetterGrade = findViewById(R.id.desiredLetterGradeInput);
        EditText currentAverage = findViewById(R.id.currentAverageInput);
        EditText finalExamWeight= findViewById(R.id.finalExamWeightInput);
        EditText minimumAverage= findViewById(R.id.minimumAverageInput);
        Button button =(Button) findViewById(R.id.submitButton);
        TextView finalPercentBox = findViewById(R.id.finalPercentBox);
        TextView finalPrologueBox = findViewById(R.id.finalPrologueBox);
        final String[] percentage = new String[1];
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String desiredGrade = desiredLetterGrade.getText().toString();
                String minAverageGrade = minimumAverage.getText().toString();
                String curAverageGrade = currentAverage.getText().toString();
                String finalWeight = finalExamWeight.getText().toString();
                if(checkPercentValidity(minAverageGrade)&&checkPercentValidity(curAverageGrade)&&checkPercentValidity(finalWeight)) {

                    GradeCalculator calculationVars = new GradeCalculator(Double.parseDouble(minAverageGrade),
                            Double.parseDouble(curAverageGrade), Double.parseDouble(finalWeight));
                    calculatedGrade = calculationVars.calculateFinalGrade();
                    percentage[0] = String.format("%.2f", (double) calculatedGrade);
                    finalPercentBox.setText(percentage[0]);
                    finalPrologueBox.setText("To get a " + desiredGrade + ", you need a final exam grade of");
                }
                else{
                    finalPrologueBox.setText("INVALID VALUES");
                }
                //equation time.
            }
        });

    }

    boolean checkPercentValidity(String input){
        if(input.length()>0)
            return true;
        else
            return false;
    }
}




