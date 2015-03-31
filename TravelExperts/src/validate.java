import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class validate 
{
	public static boolean isNumber (String numbInput)
	{
		boolean stat = false;
		try{
			Integer.parseInt(numbInput);
			stat= true;
		}catch (NumberFormatException nfe){
			stat= false;
		}
		return stat;
	}
	public static boolean isPresent (String anyInput)
	{
		boolean stat = false;
		try{
			if(!(anyInput.equals("")))
			{
				stat = true;
			}else
			{
				JOptionPane.showMessageDialog(null,"Mis-Match Data have been inserted.");
				stat = false;
			}
		}catch(Exception e){
			stat = false;
		}
		return stat;
	}
	public static boolean validateEmail(String email)
	{
		boolean stat = false;
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-­]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\­.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches())
		{
			stat = true;
		}else
		{
			stat = false;
		}
		return stat;
	}
}
