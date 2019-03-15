/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.machine;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author nosai
 */
public class atmOperations {

    static float balance=0;
    private float amount;
    static int counter = 0;
    public static ArrayList<String> hist = new ArrayList<>();

 
    public float currentBalance() {

        return balance;
    }

    public void withdraw(float withdrawAmount) {
        amount = withdrawAmount;
        if (amount > balance) {
          
            JOptionPane.showMessageDialog(null, "Error in Funds...");
            Gui.outputText.setText(null);

        } else {
            balance = balance - amount;
            getHistory("withdraw", amount);
            Gui.outputText.setText("current Balance : " + Float.toString(balance));
            JOptionPane.showMessageDialog(null, "Successful Withdraw->Current Balance : " + balance);
            

        }
    }

    public void deposite(float depositeAmount) {
        amount = depositeAmount;
        balance = balance + amount;
        Gui.outputText.setText("Current Balance: " + Float.toString(balance));
        JOptionPane.showMessageDialog(null, "Successful Deposite->Current Balance : " + balance);
        getHistory("deposite", amount);

    }

    public void getHistory(String type, float amount) {
        if (hist.size() > 4) {
            hist.remove(0);
        }
        
        if (type.equals("deposite")) {
            hist.add(String.format("Deposite : %f ", amount));
        } else if (type.equals("withdraw")) {
            hist.add(String.format("Withdraw : %f ", amount));
        } 
    }

}
