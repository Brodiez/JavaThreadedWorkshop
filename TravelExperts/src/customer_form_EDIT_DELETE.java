import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class customer_form_EDIT_DELETE extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustFNameED;
	private JTextField txtCustLNameED;
	private JTextField txtCustAddressED;
	private JTextField txtCustPostalED;
	private JTextField txtCustHomePhoneED;
	private JTextField txtCustEMailED;
	private JTextField txtCustProvED;
	private JTextField txtCustCityED;
	private JTextField txtCustBusPhoneED;
	private JTextField txtCustIDED;
	private JTextField txtCustCountryED;
	private JTextField txtAgtNoED;
	private JTextField txtCustUserNameED;
	private JTextField txtCustPasswordED;
	private static String firstName;
	private static String lastName;
	private static String fullName;
	private static JComboBox cmbBoxCustName;
	private static JButton btnUpdate;
	private static JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_form_EDIT_DELETE frame = new customer_form_EDIT_DELETE();
					loadData();
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
	
	public customer_form_EDIT_DELETE() {
		
		conn = travelExpertsConnectionDB .dbConnection();
		
		setTitle("Customer Modification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(12, 90, 86, 15);
		contentPane.add(label);
		
		txtCustFNameED = new JTextField();
		txtCustFNameED.setEnabled(false);
		txtCustFNameED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustFNameED.setColumns(10);
		txtCustFNameED.setBounds(111, 88, 160, 19);
		contentPane.add(txtCustFNameED);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(376, 90, 95, 15);
		contentPane.add(label_1);
		
		txtCustLNameED = new JTextField();
		txtCustLNameED.setEnabled(false);
		txtCustLNameED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustLNameED.setColumns(10);
		txtCustLNameED.setBounds(478, 90, 160, 19);
		contentPane.add(txtCustLNameED);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(12, 140, 79, 15);
		contentPane.add(label_2);
		
		txtCustAddressED = new JTextField();
		txtCustAddressED.setEnabled(false);
		txtCustAddressED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustAddressED.setColumns(10);
		txtCustAddressED.setBounds(109, 138, 162, 66);
		contentPane.add(txtCustAddressED);
		
		JLabel label_3 = new JLabel("Postal Code");
		label_3.setBounds(12, 217, 86, 15);
		contentPane.add(label_3);
		
		txtCustPostalED = new JTextField();
		txtCustPostalED.setEnabled(false);
		txtCustPostalED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustPostalED.setColumns(10);
		txtCustPostalED.setBounds(111, 216, 155, 17);
		contentPane.add(txtCustPostalED);
		
		JLabel label_4 = new JLabel("Home Phone");
		label_4.setBounds(12, 260, 95, 15);
		contentPane.add(label_4);
		
		txtCustHomePhoneED = new JTextField();
		txtCustHomePhoneED.setEnabled(false);
		txtCustHomePhoneED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustHomePhoneED.setColumns(10);
		txtCustHomePhoneED.setBounds(111, 260, 160, 17);
		contentPane.add(txtCustHomePhoneED);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(12, 306, 79, 15);
		contentPane.add(label_5);
		
		txtCustEMailED = new JTextField();
		txtCustEMailED.setEnabled(false);
		txtCustEMailED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustEMailED.setColumns(10);
		txtCustEMailED.setBounds(109, 304, 162, 19);
		contentPane.add(txtCustEMailED);
		
		JLabel label_6 = new JLabel("City");
		label_6.setBounds(376, 142, 79, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Province");
		label_7.setBounds(376, 171, 79, 15);
		contentPane.add(label_7);
		
		txtCustProvED = new JTextField();
		txtCustProvED.setEnabled(false);
		txtCustProvED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustProvED.setColumns(10);
		txtCustProvED.setBounds(478, 169, 79, 19);
		contentPane.add(txtCustProvED);
		
		txtCustCityED = new JTextField();
		txtCustCityED.setEnabled(false);
		txtCustCityED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustCityED.setColumns(10);
		txtCustCityED.setBounds(478, 140, 160, 19);
		contentPane.add(txtCustCityED);
		
		JLabel label_8 = new JLabel("Country");
		label_8.setBounds(376, 219, 79, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Bus Phone");
		label_9.setBounds(376, 262, 95, 15);
		contentPane.add(label_9);
		
		txtCustBusPhoneED = new JTextField();
		txtCustBusPhoneED.setEnabled(false);
		txtCustBusPhoneED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustBusPhoneED.setColumns(10);
		txtCustBusPhoneED.setBounds(478, 260, 149, 19);
		contentPane.add(txtCustBusPhoneED);
		
		JLabel label_10 = new JLabel("Agent Name");
		label_10.setBounds(376, 308, 86, 15);
		contentPane.add(label_10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer();
				UpdateCustomerInfo(customer);
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(12, 413, 117, 25);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.OK_CANCEL_OPTION(null, "Confirm to Delete this Customer Information?");
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Confirm to Delete this Customer Information?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					Customer customer = new Customer();
					DeleteCustomerInfo(customer);
				}
			}
		});
		btnDelete.setBounds(250, 413, 117, 25);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(485, 413, 117, 25);
		contentPane.add(btnExit);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(376, 42, 86, 15);
		contentPane.add(lblCustomerId);
		
		txtCustIDED = new JTextField();
		txtCustIDED.setEnabled(false);
		txtCustIDED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustIDED.setColumns(10);
		txtCustIDED.setBounds(478, 38, 160, 19);
		contentPane.add(txtCustIDED);
		
		txtCustCountryED = new JTextField();
		txtCustCountryED.setEnabled(false);
		txtCustCountryED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustCountryED.setColumns(10);
		txtCustCountryED.setBounds(478, 215, 160, 19);
		contentPane.add(txtCustCountryED);
		
		txtAgtNoED = new JTextField();
		txtAgtNoED.setEnabled(false);
		txtAgtNoED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtAgtNoED.setColumns(10);
		txtAgtNoED.setBounds(478, 306, 160, 19);
		contentPane.add(txtAgtNoED);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 42, 86, 15);
		contentPane.add(lblName);
		
		cmbBoxCustName = new JComboBox();
		cmbBoxCustName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				loadDataIntoTextBoxes();
			}
		});
		cmbBoxCustName.setBounds(111, 37, 160, 24);
		contentPane.add(cmbBoxCustName);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEnableText();
			}
		});
		btnEdit.setBounds(284, 37, 74, 25);
		contentPane.add(btnEdit);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(12, 355, 79, 15);
		contentPane.add(lblUserName);
		
		txtCustUserNameED = new JTextField();
		txtCustUserNameED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustUserNameED.setEnabled(false);
		txtCustUserNameED.setColumns(10);
		txtCustUserNameED.setBounds(109, 353, 162, 19);
		contentPane.add(txtCustUserNameED);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(376, 357, 86, 15);
		contentPane.add(lblPassword);
		
		txtCustPasswordED = new JTextField();
		txtCustPasswordED.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCustPasswordED.setEnabled(false);
		txtCustPasswordED.setColumns(10);
		txtCustPasswordED.setBounds(478, 355, 160, 19);
		contentPane.add(txtCustPasswordED);
	}
	public static void loadData()
	{
		try 
		{
			//Defines Result Sheet with corresponding PL/ SQL Statement
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery("select * from customers");
						
			//While loop to insert all data into combo box from Database
			while (rs.next())
			{
				firstName = rs.getString("CustFirstName");
				lastName = rs.getString ("CustLastName");
				fullName = firstName +" "+ lastName;
				cmbBoxCustName.addItem(fullName);			
			}
			firstName = (String)cmbBoxCustName.getSelectedItem();
		} catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
	}
	private void setEnableText()
	{
		txtCustFNameED.setEnabled(true);
		txtCustLNameED.setEnabled(true);
		txtCustAddressED.setEnabled(true);
		txtCustCityED.setEnabled(true);
		txtCustProvED.setEnabled(true);
		txtCustPostalED.setEnabled(true);
		txtCustCountryED.setEnabled(true);
		txtCustHomePhoneED.setEnabled(true);
		txtCustBusPhoneED.setEnabled(true);
		txtCustEMailED.setEnabled(true);
		txtCustUserNameED.setEnabled(true);
		txtCustPasswordED.setEnabled(true);
		txtAgtNoED.setEnabled(false);
		btnUpdate.setEnabled(true);
	}
	private void setDisableText()
	{
		txtCustFNameED.setEnabled(false);
		txtCustLNameED.setEnabled(false);
		txtCustAddressED.setEnabled(false);
		txtCustCityED.setEnabled(false);
		txtCustProvED.setEnabled(false);
		txtCustPostalED.setEnabled(false);
		txtCustCountryED.setEnabled(false);
		txtCustHomePhoneED.setEnabled(false);
		txtCustBusPhoneED.setEnabled(false);
		txtCustEMailED.setEnabled(false);
		txtCustUserNameED.setEnabled(false);
		txtCustPasswordED.setEnabled(false);
		txtAgtNoED.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	public boolean validateData(){
		return validate.isNumber(txtCustHomePhoneED.getText()) &&
				validate.isNumber(txtCustBusPhoneED.getText()) &&
				validate.isPresent(txtCustFNameED.getText()) &&
				validate.isPresent(txtCustLNameED.getText())&&
				validate.isPresent(txtCustAddressED.getText())&&
				validate.isPresent(txtCustCityED.getText())&&
				validate.isPresent(txtCustPostalED.getText())&&
				validate.isPresent(txtCustProvED.getText())&&
				validate.isPresent(txtCustEMailED.getText())&&
				validate.isPresent(txtCustUserNameED.getText())&&
				validate.isPresent(txtCustPasswordED.getText());
	}
	public void UpdateCustomerInfo(Customer customer){
		customer.setCustomerID((Integer.parseInt(txtCustIDED.getText())));
		customer.setCustFirstName(txtCustFNameED.getText());
		customer.setCustLastName(txtCustLNameED.getText());
		customer.setCustAddress(txtCustAddressED.getText());
		customer.setCustCity(txtCustCityED.getText());
		customer.setCustPostal(txtCustPostalED.getText());
		customer.setCustProv(txtCustProvED.getText());
		customer.setCustCountry(txtCustCountryED.getText());
		customer.setCustEmail(txtCustEMailED.getText());
		customer.setCustHomePhone(txtCustHomePhoneED.getText());
		customer.setCustBusPhone(txtCustBusPhoneED.getText());
		customer.setAgentId(txtAgtNoED.getText());
		customer.setUserName(txtCustUserNameED.getText());
		customer.setPassword(txtCustPasswordED.getText());
		validateData();
		customerDB.UpdateCustomer(customer);
		setDisableText();
	}
	public void DeleteCustomerInfo(Customer customer){
		customer.setCustomerID(Integer.parseInt(txtCustIDED.getText()));
		customerDB.DeleteCustomer(customer);
		clearData();
		cmbBoxCustName.revalidate();
	}
	public void clearData(){
		txtCustFNameED.setText("");
		txtCustLNameED.setText("");
		txtCustAddressED.setText("");
		txtCustCityED.setText("");
		txtCustProvED.setText("");
		txtCustPostalED.setText("");
		txtCustCityED.setText("");
		txtCustHomePhoneED.setText("");
		txtCustBusPhoneED.setText("");
		txtCustEMailED.setText("");
		txtCustUserNameED.setText("");
		txtCustPasswordED.setText("");
	}
	private void loadDataIntoTextBoxes() {
		// TODO Auto-generated method stub
		try
		{					
			//Setting up PL/SQL Statement to retrieve data according to agent's name 
			PreparedStatement pstmt = conn.prepareStatement("select * from customers where Custfirstname=?");
			
			//Retrieve agent's name from combo box, then split the name, get the agent's first name of agent and passing value to select Statement
			String selectedName = (String)cmbBoxCustName.getSelectedItem();
			String [] names = selectedName.split(" ");
			firstName = names[0];
			pstmt.setString(1, firstName);
			
			//Defines result-set and execute prepared-statement
			ResultSet rs1 = pstmt.executeQuery();
			
			//While loop to get the information from database and display data in relevant text-fields
			while (rs1.next())
				{
					txtCustIDED.setText(rs1.getString("CustomerId"));	
					txtCustFNameED.setText(rs1.getString("CustFirstName"));
					txtCustLNameED.setText(rs1.getString("CustLastName"));
					txtCustAddressED.setText(rs1.getString("CustAddress"));
					txtCustCityED.setText(rs1.getString("CustCity"));
					txtCustProvED.setText(rs1.getString("CustProv"));
					txtCustPostalED.setText(rs1.getString("CustPostal"));
					txtCustCountryED.setText(rs1.getString("CustCountry"));
					txtCustEMailED.setText(rs1.getString("CustEmail"));
					txtCustHomePhoneED.setText(rs1.getString("CustHomePhone"));
					txtCustBusPhoneED.setText(rs1.getString("CustBusPhone"));
					txtAgtNoED.setText(rs1.getString("AgentId"));
					txtCustUserNameED.setText(rs1.getString("UserName"));
					txtCustPasswordED.setText(rs1.getString("Password"));
					btnDelete.setEnabled(true);
				}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		
	}
}
