package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackupArithmetics extends JFrame {
    private JTextField firstNumber, secondNumber,result;

    public BackupArithmetics(){
        firstNumber = new JTextField(10);
        secondNumber = new JTextField(10);
        Container container = getContentPane();
        container.setLayout(new GridLayout(6,2));
        addTextField(container);
        addButton(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Arithmetics");
        setSize(300,250);
        setVisible(true);
    }
    private void addTextField(Container container){
        container.add(new JLabel("  First Number"));
        firstNumber = new JTextField(10);
        firstNumber.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(firstNumber);
        container.add(new JLabel("  Second Number"));
        secondNumber = new JTextField(10);
        secondNumber.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(secondNumber);
        container.add(new JLabel("  Result"));
        result = new JTextField(10);
        result.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        result.setEditable(false);
        container.add(result);
    }
    private void addButton(Container container){
        BackupArithmetics.buttonListener buttonListener = new BackupArithmetics.buttonListener();
        JButton add = new JButton("+");
        container.add(add);
        add.addActionListener(buttonListener);
        JButton sub = new JButton("-");
        container.add(sub);
        sub.addActionListener(buttonListener);
        JButton mul = new JButton("*");
        container.add(mul);
        mul.addActionListener(buttonListener);
        JButton div = new JButton("/");
        container.add(div);
        div.addActionListener(buttonListener);
        JButton mod = new JButton("%");
        container.add(mod);
        mod.addActionListener(buttonListener);
        JButton clear = new JButton("Clear");
        container.add(clear);
        clear.addActionListener(buttonListener);


    }
    private class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent Event){
            int firstNum = 0, secondNum=0;
            try {
                firstNum = (firstNumber.getText()) == null ? 0 : Integer.parseInt(firstNumber.getText());
                secondNum = (secondNumber.getText()) == null ? 0 : Integer.parseInt(secondNumber.getText());
            }catch (Exception e){
                SetNull();
                ErrorMessage("NumberformatException: " + e.getMessage());
                return;
            }
            String buttonCmd = Event.getActionCommand();
            switch (buttonCmd){
                case "+" : {
                    result.setText("" + (firstNum + secondNum));
                    break;
                }
                case "-" : {
                    result.setText("" + (firstNum - secondNum));
                    break;
                }
                case "*" : {
                    result.setText("" + (firstNum * secondNum));
                    break;
                }
                case "/" : {
                    if(secondNum == 0)
                        ErrorMessage("Divide by zero");
                    else
                        result.setText("" + (firstNum/secondNum));
                    break;
                }
                case "%" : {
                    if(secondNum == 0)
                        ErrorMessage("Divide by zero");
                    else
                        result.setText("" + (firstNum%secondNum));
                    break;
                }
                case "Clear" : {
                    SetNull();
                    break;
                }
                default:
                    ErrorMessage("Error in Switch Case !");
            }
        }
    }
    private void ErrorMessage(String message){
        JFrame errFrame = new JFrame();
        JOptionPane.showMessageDialog(errFrame,message);
    }
    private void SetNull(){
        firstNumber.setText("");
        secondNumber.setText("");
        result.setText("");
    }
    public static void main(String[] args){
        new BackupArithmetics();
    }
}
