/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Verify {

    private String firstID = "", id, nextID = "";

    public String getNextID(String id) {
        String oldID, nextID = "";
        oldID = (id.charAt(3) + "") + (id.charAt(4) + "") + (id.charAt(5) + "") + (id.charAt(6) + "") + (id.charAt(7) + "") + (id.charAt(8) + "");
        int val = Integer.parseInt(oldID);
        String number = String.format("%06d", (val + 1));
        nextID = (id.charAt(0) + "") + (id.charAt(1) + "") + (id.charAt(2) + "") + number;
        return nextID;
    }

    public boolean limitedTo(int number, int limit) {
        int count = 0;
        boolean b = false;
        while (number > 0) {
            number = (number / 10);
            count++;
        }
        if (count == limit) {
            b = true;
        }
        return b;
    }

    public boolean verifyDate(String date) {
        Pattern pattern = Pattern.compile("[0-9]{4}[-][0,1][0-9][-][0,1,2,3][0-9]");
        Matcher matcher = pattern.matcher(date);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
    
    public boolean verifyMobileNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0][7][1,2,5,6,7,8]([0-9]){7}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public boolean verifyPhoneNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0]([0-9]){9}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public boolean verifyNICNumber(JTextField textField) {
        String text = textField.getText();

        Pattern pattern = Pattern.compile("[0-9]{2}[0,1,2,3,5,6,7,8]([0-9]){6}");
        Matcher matcher = pattern.matcher(text);

        boolean b = false;

        if (matcher.find()) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
}
