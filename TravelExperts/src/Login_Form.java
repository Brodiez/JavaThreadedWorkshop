import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;


public class Login_Form extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form frame = new Login_Form();
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
	public Login_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("User-Name:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(93, 47, 162, 30);
		contentPane.add(lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtUserName.setBounds(267, 47, 200, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(93, 108, 162, 30);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(93, 190, 97, 25);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(237, 190, 97, 25);
		contentPane.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(385, 190, 97, 25);
		contentPane.add(btnExit);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(267, 125, 200, 22);
		contentPane.add(txtPassword);
	}
	private void clearControls() {
		// TODO Auto-generated method stub
		txtUserName.setText("");
		txtPassword.setText("");
	}
	private void login() {
		// TODO Auto-generated method stub
		if((txtUserName.getText().length()==0) && (txtPassword.getPassword().length==0))
		{
			JOptionPane.showMessageDialog(null, "Empty Fields Detected! Please Fill Up Both Fields!");
			clearControls();
			txtUserName.requestFocus();
		}
		else
		{
			String user = txtUserName.getText();
			char [] pass = txtPassword.getPassword();
			String pwd = String.copyValueOf(pass);
			if (validate_login(user,pwd))
			{
				JOptionPane.showMessageDialog(null, "Correct Login Crendtials");
				clearControls();
				TEManager temanager = new TEManager();
				temanager.setVisible(true);
				dispose();
				Login_Form.this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Try Again with Better Luck in Next Time!!");
				clearControls();
				txtUserName.requestFocus();
		
			}
		}
		
	}

	private boolean validate_login(String user, String pwd) {
		// TODO Auto-generated method stub
		try
		{
			String selectQuery = "select * from agents where agtFirstName=? and agtLastName=?";
			PreparedStatement pStmt = conn.prepareStatement(selectQuery);
			pStmt.setString(1, user);
			pStmt.setString(2, pwd);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		}catch(Exception ex){
			System.out.println(ex);
			return false;
		}
	}
}
