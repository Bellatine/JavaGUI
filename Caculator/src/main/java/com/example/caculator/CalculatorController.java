package com.example.caculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    private CalculatorModel calculatorModel = new CalculatorModel();
    @FXML
    private  TextField firstNum;

    @FXML
    private  TextField secondNum;

    @FXML
    private Label result;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        String sign = ((Button) event.getSource()).getText();
        int firstNumber = 0, secondNumber=0;
        firstNumber = Integer.parseInt(firstNum.getText());
        secondNumber = Integer.parseInt(secondNum.getText());
        if(firstNumber==0||secondNumber==0) {
            result.setText("error!");
            return;
        }
        result.setText(calculatorModel.Calculate(firstNumber,secondNumber,sign));
    }

    @FXML
    private void handleClearAction(ActionEvent event){
        firstNum.clear();
        secondNum.clear();
        result.setText("");
    }
}