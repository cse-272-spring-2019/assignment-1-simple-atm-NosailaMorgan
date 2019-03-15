package atm.machine;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

public class Gui extends JFrame {

    public JButton balanceButton;
    private JButton withdrawButton;
    private JButton depositeButton;
    private JButton previousButton;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton nextButton;
    private JButton confirmButton;
    private JButton returnToMenu;
    private JPanel panel;
    //static 3lshan ast5dmha bara el class bta3y .
    static JTextArea outputText;
    private JLabel label;

    //atmOperations operations = new atmOperations();
    JFrame frame2;
    JFrame frame;
    Menu menu;
    atmOperations operations = new atmOperations();

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public Gui() {

        CreateGUI();

        label = new JLabel();

        button0.addActionListener(this::button0ActionPreformed);
        button1.addActionListener(this::button1ActionPreformed);
        button2.addActionListener(this::button2ActionPreformed);
        button3.addActionListener(this::button3ActionPreformed);
        button4.addActionListener(this::button4ActionPreformed);
        button5.addActionListener(this::button5ActionPreformed);
        button6.addActionListener(this::button6ActionPreformed);
        button7.addActionListener(this::button7ActionPreformed);
        button8.addActionListener(this::button8ActionPreformed);
        button9.addActionListener(this::button9ActionPreformed);
        confirmButton.addActionListener(this::confirmButtonActionPreformed);
        returnToMenu.addActionListener(this::returnToMenuActionPreformed);

    }

    protected void AddComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width;
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        
        label=new JLabel("Entre The Amount..");
        c.gridx=1;
        c.gridy=0;
        pane.add(label,c);
        
        outputText = new JTextArea();
        outputText.setColumns(10);
        outputText.setEditable(true);
        c.ipadx=30;
        c.ipady=10;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(outputText, c);

        button0 = new JButton("0");
        c.gridx = 1;
        c.gridy = 5;
        pane.add(button0, c);

        button1 = new JButton("1");
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button1, c);

        button2 = new JButton("2");
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button2, c);

        button3 = new JButton("3");
        c.gridx = 2;
        c.gridy = 2;
        pane.add(button3, c);

        button4 = new JButton("4");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;

        pane.add(button4, c);
        button5 = new JButton("5");
        c.gridx = 1;
        c.gridy = 3;
        pane.add(button5, c);

        button6 = new JButton("6");
        c.gridx = 2;
        c.gridy = 3;
        pane.add(button6, c);

        button7 = new JButton("7");
        c.gridx = 0;
        c.gridy = 4;
        pane.add(button7, c);
        //add(button7);
        button8 = new JButton("8");
        c.gridx = 1;
        c.gridy = 4;
        pane.add(button8, c);

        button9 = new JButton("9");
        c.gridx = 2;
        c.gridy = 4;
        pane.add(button9, c);

        confirmButton = new JButton("Confirm");
        c.gridx = 0;
        c.gridy = 5;
        pane.add(confirmButton, c);

        returnToMenu = new JButton("Return");
        c.gridx = 2;
        c.gridy = 5;
        pane.add(returnToMenu, c);

    }

    private void CreateGUI() {
        //Create and set up the window.
        frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        AddComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    protected void button0ActionPreformed(ActionEvent e) {
        outputText.append("0");

    }

    protected void button1ActionPreformed(ActionEvent e) {
        outputText.append("1");

    }

    protected void button2ActionPreformed(ActionEvent e) {
        outputText.append("2");
    }

    protected void button3ActionPreformed(ActionEvent e) {
        outputText.append("3");
    }

    protected void button4ActionPreformed(ActionEvent e) {
        outputText.append("4");
    }

    protected void button5ActionPreformed(ActionEvent e) {
        outputText.append("5");
    }

    protected void button6ActionPreformed(ActionEvent e) {
        outputText.append("6");
    }

    protected void button7ActionPreformed(ActionEvent e) {
        outputText.append("7");
    }

    protected void button8ActionPreformed(ActionEvent e) {
        outputText.append("8");
    }

    protected void button9ActionPreformed(ActionEvent e) {
        outputText.append("9");

    }

    protected void confirmButtonActionPreformed(ActionEvent e) {

        if (menu.checkString.equals("deposite")) {
            operations.deposite(Float.parseFloat(outputText.getText()));
            // JOptionPane.showMessageDialog(null, "Successful Deposite->Current Balance : " + operations.balance);
            //frame2.setVisible(true);
            frame.setVisible(false);
            Menu menu = new Menu();
            if (frame != null) {
                frame.setVisible(false);

            }
            
        } else if (menu.checkString.equals("withdraw")) {
            operations.withdraw(Float.parseFloat(outputText.getText()));
            frame.setVisible(false);
            Menu menu = new Menu();
            if (frame != null) {
                frame.setVisible(false);

            }

        }

    }

    protected void returnToMenuActionPreformed(ActionEvent e) {
        //atmOperations operations = new atmOperations();
        //operations.setBalance();
        Menu menu = new Menu();
        if (frame != null) {
            frame.setVisible(false);
        }

    }

}
