package com.example.caculator;
import javafx.scene.control.Alert;

public class CalculatorModel {


    public void ErrorDialog(String header, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Arithmetics Error");
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }
    public String Calculate(int firstNum, int secondNum, String check){
        int res;
        if(check.equals("+")==true){
            return("" + (firstNum + secondNum));
        }
        if(check.equals("-")==true){
            return("" + (firstNum - secondNum));
        }
        if(check.equals("*")==true){
            return("" + (firstNum * secondNum));
        }
        if(check.equals("/")==true){
            return("" + (firstNum / secondNum));
        }
        if(check.equals("%")==true){
            return("" + (firstNum % secondNum));
        }
        return null;
    }
}
