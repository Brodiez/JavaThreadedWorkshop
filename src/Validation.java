import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import org.jdatepicker.impl.JDatePickerImpl;


public class Validation {
	
	public static boolean isPresent(JTextField textField) {
		if(textField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "A value is required");
			textField.requestFocus();
			return false;
		}
		return true;
	}
	
	/*public static boolean isDate(JDatePickerImpl datePicker) {
		if(datePicker.getModel().getValue()== null) {
			JOptionPane.showMessageDialog(null, "Date is required");
			datePicker.requestFocus();
			return false;
		}
		return true;
	}*/
	
	public static boolean isDecimal(JTextField textField) {
		try {
			new BigDecimal(textField.getText());
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Decimal number format is required");
			textField.requestFocus();
			return false;
			
		}
		return true;
	}
	public static boolean isNumber(JTextField textField) {
		try {
			new BigInteger(textField.getText());
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Number format is required");
			textField.requestFocus();
			return false;
			
		}
		return true;
	}
}
