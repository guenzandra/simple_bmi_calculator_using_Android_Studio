package com.BSIT_BA_3A_BMI.bmi_calculator_bsitba_3a_ocba.core;

public class Health {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public double calculateBMI(double heightCm, double weightKg) {
        double bmiIndex = -1;
        if (heightCm <= 0 && weightKg <= 0) {
            errorMessage = "Height and Weight can't be zero or less";
        } else {
            bmiIndex = weightKg / ((heightCm/100) * (heightCm/100));
        }
        return bmiIndex;
    }

    public String determineCategory (double bmiIndex){
        String bmiCategory = "";

        if (bmiIndex < 18.5) {
            bmiCategory = "Underweight";
        } else if (bmiIndex >= 18.5 && bmiIndex <25) {
            bmiCategory = "Normal";
        } else if (bmiIndex >= 25 && bmiIndex <30) {
            bmiCategory = "Overweight";
        } else if (bmiIndex >= 30 && bmiIndex <100) {
            bmiCategory = "Obese";
        }
        return bmiCategory;
    }
}
