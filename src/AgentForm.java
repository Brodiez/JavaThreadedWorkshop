import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;


public class AgentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtMInit;
	private JTextField txtLName;
	private JTextField txtBusPhone;
	private JTextField txtEmail;
	private JTextField txtPos;
	private JTextField txtAgencyId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentForm frame = new AgentForm();
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
	public AgentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFName = new JTextField();
		txtFName.setBounds(142, 41, 116, 22);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(39, 44, 91, 16);
		contentPane.add(lblFName);
		
		txtMInit = new JTextField();
		txtMInit.setColumns(10);
		txtMInit.setBounds(142, 76, 116, 22);
		contentPane.add(txtMInit);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(142, 111, 116, 22);
		contentPane.add(txtLName);
		
		txtBusPhone = new JTextField();
		txtBusPhone.setColumns(10);
		txtBusPhone.setBounds(142, 150, 116, 22);
		contentPane.add(txtBusPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 193, 116, 22);
		contentPane.add(txtEmail);
		
		txtPos = new JTextField();
		txtPos.setColumns(10);
		txtPos.setBounds(142, 231, 116, 22);
		contentPane.add(txtPos);
		
		txtAgencyId = new JTextField();
		txtAgencyId.setColumns(10);
		txtAgencyId.setBounds(142, 272, 116, 22);
		contentPane.add(txtAgencyId);
		
		JLabel lblMidInit = new JLabel("Middle Initial");
		lblMidInit.setBounds(39, 79, 91, 16);
		contentPane.add(lblMidInit);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(39, 114, 91, 16);
		contentPane.add(lblLastName);
		
		JLabel lblBusinessPhone = new JLabel("Business Phone");
		lblBusinessPhone.setBounds(39, 153, 91, 16);
		contentPane.add(lblBusinessPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 196, 91, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(39, 234, 91, 16);
		contentPane.add(lblPosition);
		
		JLabel lblAgencyId = new JLabel("Agency ID");
		lblAgencyId.setBounds(39, 275, 91, 16);
		contentPane.add(lblAgencyId);
		
		JLabel lblAgentForm = new JLabel("Agent");
		lblAgentForm.setBounds(39, 13, 91, 16);
		contentPane.add(lblAgentForm);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 13, 200, 50);
		contentPane.add(comboBox);
	}
}
