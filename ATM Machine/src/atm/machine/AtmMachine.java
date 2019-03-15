package atm.machine;


import javax.swing.JFrame;

public class AtmMachine {

    public static void main(String[] args) {
        // TODO code application logic here

        
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                validation login = new validation();

                do {
                    login.Validate();
                } while (login.valid == false);
                
                Menu menu=new Menu();
                
            }
        });

    }

}
