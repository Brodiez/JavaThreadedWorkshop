/*Developer's Name: Anushka Kaushalya De Silva*/
/*Developer's SAIT ID: 000680968*/
/*Project Name: Threaded Workshop 03*/
/*Class Name: customer_form_NEW.java*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class customer_form_NEW extends JFrame {

	//Defined Textboxes which used in the Form for access by different methods in this class 
	private JPanel contentPane;
	private JTextField txtCustFNameNEW;
	private JTextField txtCustLNameNEW;
	private JTextField txtCustAddressNEW;
	private JTextField txtCustCityNEW;
	private JTextField txtCustProvNEW;
	private JTextField txtCustPostalCodeNEW;
	private JTextField txtCustHomePhoneNEW;
	private JTextField txtCustBusPhoneNEW;
	private JTextField txtCustEMailNEW;
	private static JComboBox cmbCustCountryNEW;
	private static JComboBox cmbCustAgtNameNEW;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnExit;
	
	//Define attributes for get Agent's ID by using Agent's nmae
	private static String firstName;
	private static String lastName;
	private static String fullName;
	private static String agtID;
	

	/**
	 * Launch the application.
	 */
	//Main Method where Application Loads
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_form_NEW frame = new customer_form_NEW();
					countryList();
					agentList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	static Connection conn = null;
	private JLabel lblUserName;
	private JTextField txtCustUserNameNEW;
	private JLabel lblPassword;
	private JTextField txtCustPasswordNEW;
	
	public customer_form_NEW() {
		
		//Defines Database Connection
		conn = travelExpertsConnectionDB .dbConnection();
		
		//Defines all The Attributes which declares in the form including Labels, Textboxes, Buttons and Combo Boxes
		setTitle("New Customer Entery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 72, 86, 15);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(340, 72, 95, 15);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(12, 133, 79, 15);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(340, 133, 79, 15);
		contentPane.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(340, 162, 79, 15);
		contentPane.add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setBounds(12, 210, 86, 15);
		contentPane.add(lblPostalCode);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(340, 210, 79, 15);
		contentPane.add(lblCountry);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(12, 253, 95, 15);
		contentPane.add(lblHomePhone);
		
		JLabel lblBusPhone = new JLabel("Bus Phone");
		lblBusPhone.setBounds(340, 253, 95, 15);
		contentPane.add(lblBusPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 299, 79, 15);
		contentPane.add(lblEmail);
		
		JLabel lblAgentName = new JLabel("Agent Name");
		lblAgentName.setBounds(340, 299, 86, 15);
		contentPane.add(lblAgentName);
		
		txtCustFNameNEW = new JTextField();
		txtCustFNameNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustFNameNEW.setBounds(111, 70, 160, 19);
		contentPane.add(txtCustFNameNEW);
		txtCustFNameNEW.setColumns(10);
		
		txtCustLNameNEW = new JTextField();
		txtCustLNameNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustLNameNEW.setBounds(442, 72, 160, 19);
		contentPane.add(txtCustLNameNEW);
		txtCustLNameNEW.setColumns(10);
		
		txtCustAddressNEW = new JTextField();
		txtCustAddressNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustAddressNEW.setBounds(109, 131, 162, 66);
		contentPane.add(txtCustAddressNEW);
		txtCustAddressNEW.setColumns(10);
		
		txtCustCityNEW = new JTextField();
		txtCustCityNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustCityNEW.setBounds(442, 131, 160, 19);
		contentPane.add(txtCustCityNEW);
		txtCustCityNEW.setColumns(10);
		
		txtCustProvNEW = new JTextField();
		txtCustProvNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustProvNEW.setBounds(442, 160, 79, 19);
		contentPane.add(txtCustProvNEW);
		txtCustProvNEW.setColumns(10);
		
		cmbCustCountryNEW = new JComboBox();
		cmbCustCountryNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		cmbCustCountryNEW.setBounds(439, 205, 160, 24);
		contentPane.add(cmbCustCountryNEW);
		
		txtCustPostalCodeNEW = new JTextField();
		txtCustPostalCodeNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustPostalCodeNEW.setBounds(111, 209, 155, 17);
		contentPane.add(txtCustPostalCodeNEW);
		txtCustPostalCodeNEW.setColumns(10);
		
		txtCustHomePhoneNEW = new JTextField();
		txtCustHomePhoneNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustHomePhoneNEW.setBounds(111, 253, 160, 17);
		contentPane.add(txtCustHomePhoneNEW);
		txtCustHomePhoneNEW.setColumns(10);
		
		txtCustBusPhoneNEW = new JTextField();
		txtCustBusPhoneNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustBusPhoneNEW.setBounds(442, 251, 149, 19);
		contentPane.add(txtCustBusPhoneNEW);
		txtCustBusPhoneNEW.setColumns(10);
		
		txtCustEMailNEW = new JTextField();
		txtCustEMailNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustEMailNEW.setBounds(109, 297, 162, 19);
		contentPane.add(txtCustEMailNEW);
		txtCustEMailNEW.setColumns(10);
		
		cmbCustAgtNameNEW = new JComboBox();
		cmbCustAgtNameNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		cmbCustAgtNameNEW.setBounds(444, 294, 158, 24);
		contentPane.add(cmbCustAgtNameNEW);
		
		btnSave = new JButton("SAVE");
		//Action Listener for SAVE button where it calls public/ private method to insert Customer Info in to Database
		//After going through ValidateData method
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateData()){
					Customer customer = new Customer();
					PutCustomerData(customer);
				}
			}
		});
		btnSave.setBounds(12, 417, 117, 25);
		contentPane.add(btnSave);
		
		btnClear = new JButton("CLEAR");
		//Action Listener for CLEAR button where it calls public/ private method to Clear Customer Info from Textboxes
		//in the text boxes
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearData();				
			}
		});
		btnClear.setBounds(250, 417, 117, 25);
		contentPane.add(btnClear);
		
		btnExit = new JButton("EXIT");
		//Action Listener for EXIT button which it calls exit method of form
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(485, 417, 117, 25);
		contentPane.add(btnExit);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(12, 348, 79, 15);
		contentPane.add(lblUserName);
		
		txtCustUserNameNEW = new JTextField();
		txtCustUserNameNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustUserNameNEW.setColumns(10);
		txtCustUserNameNEW.setBounds(109, 346, 162, 19);
		contentPane.add(txtCustUserNameNEW);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(340, 348, 86, 15);
		contentPane.add(lblPassword);
		
		txtCustPasswordNEW = new JTextField();
		txtCustPasswordNEW.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustPasswordNEW.setColumns(10);
		txtCustPasswordNEW.setBounds(442, 346, 160, 19);
		contentPane.add(txtCustPasswordNEW);
	}
	//Public method which bring agent name list into form's combo box
	public static void agentList(){
		ResultSet rs = null;
		try 
		{
			//Defines Result Sheet with corresponding SQL Statement
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from agents");
			
			//While loop to insert all data into combo box from Database
			while (rs.next())
			{
				//Set Agent's First Name and Last Name into two different local variables and add names into combo box after
				//Concatenate both names
				firstName = rs.getString("agtfirstname");
				lastName = rs.getString ("agtlastname");
				fullName = firstName +" "+ lastName;
				cmbCustAgtNameNEW.addItem(fullName);			
			}
		} catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
	}
	//Get all the country name list into Combo Box method by using Locale methods
	public static void countryList(){
		
		List<String> countries = new ArrayList<>();

	    Locale[] locales = Locale.getAvailableLocales();
	    for (Locale locale : locales) {
	      String countryName = locale.getDisplayCountry();
	      cmbCustCountryNEW.addItem(countryName);
	    }
	}
	//public method which disable all input components
	public void disableInputs(){
		txtCustFNameNEW.setEnabled(false);
		txtCustLNameNEW.setEnabled(false);
		txtCustAddressNEW.setEnabled(false);
		txtCustCityNEW.setEnabled(false);
		txtCustProvNEW.setEnabled(false);
		txtCustPostalCodeNEW.setEnabled(false);
		txtCustCityNEW.setEnabled(false);
		txtCustHomePhoneNEW.setEnabled(false);
		txtCustBusPhoneNEW.setEnabled(false);
		txtCustEMailNEW.setEnabled(false);
		txtCustUserNameNEW.setEnabled(false);
		txtCustPasswordNEW.setEnabled(false);
		btnSave.setEnabled(false);
		btnClear.setEnabled(false);
		cmbCustAgtNameNEW.setEnabled(false);
		cmbCustCountryNEW.setEnabled(false);	
	}
	//Public method which clear data in the text boxes
	public void clearData(){
		txtCustFNameNEW.setText("");
		txtCustLNameNEW.setText("");
		txtCustAddressNEW.setText("");
		txtCustCityNEW.setText("");
		txtCustProvNEW.setText("");
		txtCustPostalCodeNEW.setText("");
		txtCustCityNEW.setText("");
		txtCustHomePhoneNEW.setText("");
		txtCustBusPhoneNEW.setText("");
		txtCustEMailNEW.setText("");
		txtCustUserNameNEW.setText("");
		txtCustPasswordNEW.setText("");
	}
	//Public method which validate all the inputs before send them to Database
	public boolean validateData(){
		return validate.isNumber(txtCustHomePhoneNEW.getText()) &&
				validate.isNumber(txtCustBusPhoneNEW.getText()) &&
				validate.isPresent(txtCustFNameNEW.getText()) &&
				validate.isPresent(txtCustLNameNEW.getText())&&
				validate.isPresent(txtCustAddressNEW.getText())&&
				validate.isPresent(txtCustCityNEW.getText())&&
				validate.isPresent(txtCustPostalCodeNEW.getText())&&
				validate.isPresent(txtCustProvNEW.getText())&&
				validate.isPresent(txtCustEMailNEW.getText())&&
				validate.isPresent(txtCustUserNameNEW.getText())&&
				validate.isPresent(txtCustPasswordNEW.getText());
	}
	//Public method which call AddCustomer method from CustomerDB class and insert info into Database
	public void PutCustomerData(Customer customer)
	{
		//Call method to disable input components
		disableInputs();
		//This try catch method to retrieve Agent's ID whose newly adding Customer Belong to
		try{
			//Select SQL Statement
			PreparedStatement pstmt = conn.prepareStatement("select AGENTID from agents where agtfirstname=?");
			
			//Retrieve agent's name from combo box, then split the name, get the agent's first name of agent and passing value to select Statment
			String selectedName = (String)cmbCustAgtNameNEW.getSelectedItem();
			String [] names = selectedName.split(" ");
			firstName = names[0];
			pstmt.setString(1, firstName);
			
			//Defines result-set and execute prepared-statement
			ResultSet rs1 = pstmt.executeQuery();
			while(rs1.next())
			{
				//Fill Customer Class's attribute agentId as selected Agent's ID
				customer.setAgentId(rs1.getString("AGENTID"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		//Set up Customer's Attributes according to the inputs
		customer.setCustFirstName(txtCustFNameNEW.getText());
		customer.setCustLastName(txtCustLNameNEW.getText());
		customer.setCustAddress(txtCustAddressNEW.getText());
		customer.setCustCity(txtCustCityNEW.getText());
		customer.setCustPostal(txtCustPostalCodeNEW.getText());
		customer.setCustProv(txtCustProvNEW.getText());
		customer.setCustCountry(cmbCustCountryNEW.getSelectedItem().toString());
		customer.setCustEmail(txtCustEMailNEW.getText());
		customer.setCustHomePhone(txtCustHomePhoneNEW.getText());
		customer.setCustBusPhone(txtCustBusPhoneNEW.getText());
		customer.setUserName(txtCustUserNameNEW.getText());
		customer.setPassword(txtCustPasswordNEW.getText());
		clearData();
		try
		{
			//Pass Customer's Values into AddCustomer Method of CustomerDB Class
			customerDB.AddCustomer(customer);
		}catch(Exception ex){
			System.out.print(ex);
		}
		//Finally Message after inserting Info into Database
		String successMsg = "Customer Succussfully Added!";
		JOptionPane.showMessageDialog(null, successMsg);
	}
}