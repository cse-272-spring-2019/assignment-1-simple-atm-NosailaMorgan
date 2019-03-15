package atm.machine;

import static atm.machine.Gui.outputText;
import static atm.machine.Gui.shouldFill;
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

public class Menu extends JFrame {

    private JButton balanceButton;
    private JButton depositeButton;
    private JButton withdrawButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel label;
    private JTextField text;
    static String checkString;
    final static boolean shouldFill = true;
    
  
    atmOperations operations = new atmOperations();
    JFrame frame2 = new JFrame("ATM Machine");
    int counterPrevious = operations.hist.size() - 1;
    int counterNext = 0;

    public Menu() {

        //JFrame frame = new JFrame("ATM Machine");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AddComponentsToPane(frame2.getContentPane());

        frame2.pack();
        frame2.setVisible(true);

        balanceButton.addActionListener(this::balanceButtonActionPreformed);
        withdrawButton.addActionListener(this::withdrawButtonActionPreformed);
        depositeButton.addActionListener(this::depositeButtonActionPreformed);
        nextButton.addActionListener(this::nextButtonActionPreformed);
        previousButton.addActionListener(this::previousButtonActionPreformed);
    }

    protected void AddComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width;
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        label = new JLabel("Select From The Options Bellow .");
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        pane.add(label, c);

        text = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        pane.add(text, c);

        balanceButton = new JButton("Balance");
        c.gridx = 1;
        c.gridy = 2;
        pane.add(balanceButton, c);

        depositeButton = new JButton("Deposite");
        c.gridx = 1;
        c.gridy = 3;
        pane.add(depositeButton, c);

        withdrawButton = new JButton("WIthdraw");
        c.gridx = 1;
        c.gridy = 4;
        pane.add(withdrawButton, c);

        previousButton = new JButton("Previous");
        c.gridx = 1;
        c.gridy = 5;
        pane.add(previousButton, c);

        nextButton = new JButton("Next");
        c.gridx = 1;
        c.gridy = 6;
        pane.add(nextButton, c);

    }

    protected void balanceButtonActionPreformed(ActionEvent e) {
        text.setText("Current Balance :" + Float.toString(atmOperations.balance));
    }

    protected void withdrawButtonActionPreformed(ActionEvent e) {
        checkString = "withdraw";
        frame2.setVisible(false);
        Gui gui = new Gui();

    }

    protected void depositeButtonActionPreformed(ActionEvent e) {
        checkString = "deposite";
        frame2.setVisible(false);
        Gui gui = new Gui();

    }

    protected void previousButtonActionPreformed(ActionEvent e) {
        
        if (counterPrevious < 0) { 
            return;
        }
        text.setText(operations.hist.get(counterPrevious));
        counterPrevious--;
        counterNext = counterPrevious + 1;
//        for(int i = 0; i < operations.hist.size(); i++)
//        {
//            String s  = operations.hist.get(i);
//            System.out.println(s);
//        }
//            System.out.println("---------------");

    }

    protected void nextButtonActionPreformed(ActionEvent e) {

        if (counterNext < 0 || counterNext >= operations.hist.size() - 1) {
            return;
        }
        counterNext++;
        counterPrevious = counterNext - 1;
        text.setText(operations.hist.get(counterNext));

    }

   

}
