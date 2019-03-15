package atm.machine;

import javax.swing.JOptionPane;

/**
 *
 * @author nosai
 */
public class validation {

    final String savedPIN = "123";
    private String userPIN;

    public boolean valid;

    public validation() {
        valid = false;
    }

    public void Validate() {
        userPIN = JOptionPane.showInputDialog("Please Enter your Pin Number ");
        if (!userPIN.equals(savedPIN)) {
            JOptionPane.showMessageDialog(null, "Your Pin Number is InValid");
            userPIN = JOptionPane.showInputDialog("Please Enter your Bin Number ");
            valid = false;
            JOptionPane.showMessageDialog(null, "Your Pin Number is InValid");

        } else if (userPIN.equals(savedPIN)) {
            JOptionPane.showMessageDialog(null, "Valid Pin Number ");
            valid = true;
        }
        
        

    }

}
