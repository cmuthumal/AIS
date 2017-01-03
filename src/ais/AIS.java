/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ais;

//import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import view.Login;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class AIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setNimbusLookAndFeel();

        new Login().setVisible(true);
    }

    /*  private static void setGTKLookAndFeel() {
     try {
     UIManager.setLookAndFeel(new GTKLookAndFeel());
     } catch (UnsupportedLookAndFeelException ex) {
     JOptionPane.showMessageDialog(null, ex);
     setNimbusLookAndFeel();
     }
     }
     */
    private static void setNimbusLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }
}
