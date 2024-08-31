package com.BSIT_BA_3A_BMI.bmi_calculator_bsitba_3a_ocba;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.BSIT_BA_3A_BMI.bmi_calculator_bsitba_3a_ocba.core.Health;

public class MainActivity extends AppCompatActivity {
    EditText heightText, weightText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightText = findViewById(R.id.editTextTextHeight);
        weightText = findViewById(R.id.editTextText2Weight);
    }

    public void onCalculateButton(View view) {
        double height = 0;
        double weight = 0;

        if(!heightText.getText().toString().equals("") && Double.parseDouble(heightText.getText().toString()) !=0){
            height = Double.parseDouble(heightText.getText().toString());
        }

        if (!weightText.getText().toString().equals("") && Double.parseDouble(weightText.getText().toString()) !=0){
            weight = Double.parseDouble(weightText.getText().toString());
        }

        Health health = new Health();
        double bmiResult = health.calculateBMI(height,weight);

        String resultText;

        if(bmiResult != -1){
            String bmiCat = health.determineCategory(bmiResult);
            resultText = "Your BMI Index is " + String.format("%.2f",bmiResult)+ "\nBMI category: " + bmiCat;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("BMI");
            alertDialogBuilder.setMessage(resultText);
            alertDialogBuilder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    heightText.setText("");
                    weightText.setText("");
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            Toast.makeText(this, health.getErrorMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}