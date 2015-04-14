import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class AgentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMInit;
	private JTextField txtLName;
	private JTextField txtBusPhone;
	private JTextField txtEmail;
	private JTextField txtFName;
	boolean add = false;

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
		txtFName.setEnabled(false);
		txtFName.setBounds(142, 129, 175, 22);
		contentPane.add(txtFName);
		txtFName.setColumns(10);
		
		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(39, 132, 91, 16);
		contentPane.add(lblFName);
		
		txtMInit = new JTextField();
		txtMInit.setColumns(10);
		txtMInit.setBounds(142, 164, 175, 22);
		contentPane.add(txtMInit);
		txtMInit.setEnabled(false);
		
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(142, 199, 175, 22);
		contentPane.add(txtLName);
		txtLName.setEnabled(false);
		
		
		txtBusPhone = new JTextField();
		txtBusPhone.setColumns(10);
		txtBusPhone.setBounds(142, 234, 175, 22);
		contentPane.add(txtBusPhone);
		txtBusPhone.setEnabled(false);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(142, 269, 264, 22);
		contentPane.add(txtEmail);
		txtEmail.setEnabled(false);
		
		JLabel lblMidInit = new JLabel("Middle Initial");
		lblMidInit.setBounds(39, 167, 91, 16);
		contentPane.add(lblMidInit);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(39, 202, 91, 16);
		contentPane.add(lblLastName);
		
		JLabel lblBusinessPhone = new JLabel("Business Phone");
		lblBusinessPhone.setBounds(39, 237, 91, 16);
		contentPane.add(lblBusinessPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 272, 91, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(39, 307, 91, 16);
		contentPane.add(lblPosition);
		
		JLabel lblAgencyId = new JLabel("Agency ID");
		lblAgencyId.setBounds(39, 342, 91, 16);
		contentPane.add(lblAgencyId);
		
		JLabel lblAgentForm = new JLabel("Agent");
		lblAgentForm.setBounds(39, 78, 91, 16);
		contentPane.add(lblAgentForm);

		//Position combo box
		String[] pos = {"Senior Agent","Intermediate Agent","Junior Agent","Inactive"};	
		JComboBox comboBox_1 = new JComboBox(pos);
		comboBox_1.setBounds(142, 304, 175, 22);
		contentPane.add(comboBox_1);
		comboBox_1.setEnabled(false);
		
		//agencyid combobox
		String[] id = {"1","2"};
		JComboBox cbAgencyId = new JComboBox(id);
		cbAgencyId.setBounds(142, 342, 175, 22);
		contentPane.add(cbAgencyId);
		cbAgencyId.setEnabled(false);

		//pulling data from database for the agent form
		Vector<Agent> agents = null;
		try {
			agents = AgentDB.getAgents();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JComboBox<Agent> comboBox = new JComboBox<Agent>(agents);
		comboBox.setBounds(143, 75, 174, 22);
		contentPane.add(comboBox);
		
		//set agent combo box with database values
		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Agent agt = (Agent)comboBox.getSelectedItem();
				txtFName.setText(agt.getAgtFirstName());
				txtMInit.setText(agt.getAgtMiddleInitial());
				txtLName.setText(agt.getAgtLastName());
				txtBusPhone.setText(agt.getAgtBusPhone());
				txtEmail.setText(agt.getAgtEmail());
				cbAgencyId.setSelectedItem(String.valueOf(agt.getAgencyId()));
				comboBox_1.setSelectedItem(agt.getAgtPosition());
			}

		}
		);
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(142, 384, 76, 25);
		contentPane.add(btnClear);
			
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(39, 32, 76, 25);
		contentPane.add(btnAdd);
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(142, 32, 76, 25);
		contentPane.add(btnEdit);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(230, 384, 87, 25);
		contentPane.add(btnSave);
		
		//listeners added to buttons
		btnEdit.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				 add = false;
				 txtFName.setEnabled(true);
				 txtMInit.setEnabled(true);
				 txtLName.setEnabled(true);
				 txtBusPhone.setEnabled(true);
				 txtEmail.setEnabled(true);
				 cbAgencyId.setEnabled(true);
				 comboBox.setEnabled(false);
				 comboBox_1.setEnabled(true);
				 btnClear.setEnabled(false);
				 btnAdd.setEnabled(false);
				 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		btnAdd.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				add = true;
				txtFName.setEnabled(true);
				txtMInit.setEnabled(true);
				txtLName.setEnabled(true);
				txtBusPhone.setEnabled(true);
				txtEmail.setEnabled(true);
				cbAgencyId.setEnabled(true);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(true);
				btnEdit.setEnabled(false);
				Clear();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


		});
		

		btnSave.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if (add == true){
					Agent agt = new Agent();
					agt.setAgtFirstName(txtFName.getText());
					agt.setAgtMiddleInitial(txtMInit.getText());
					agt.setAgtLastName(txtLName.getText());
					agt.setAgtBusPhone(txtBusPhone.getText());
					agt.setAgtEmail(txtEmail.getText());
					agt.setAgtPosition(comboBox_1.getSelectedItem().toString());
					agt.setAgencyId(Integer.parseInt(cbAgencyId.getSelectedItem().toString()));
					try {
						AgentDB.createAgent(agt);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				else 
				{
					Agent agt = (Agent)comboBox.getSelectedItem();
					Agent newAgt = new Agent();
					newAgt.setAgtFirstName(txtFName.getText());
					newAgt.setAgtMiddleInitial(txtMInit.getText());
					newAgt.setAgtLastName(txtLName.getText());
					newAgt.setAgtBusPhone(txtBusPhone.getText());
					newAgt.setAgtEmail(txtEmail.getText());
					newAgt.setAgtPosition(comboBox_1.getSelectedItem().toString());
					newAgt.setAgencyId(Integer.parseInt(cbAgencyId.getSelectedItem().toString()));
					try {
						AgentDB.updateAgent(newAgt,agt);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				comboBox.setEnabled(true);
				txtFName.setEnabled(false);
				txtMInit.setEnabled(false);
				txtLName.setEnabled(false);
				txtBusPhone.setEnabled(false);
				txtEmail.setEnabled(false);
				cbAgencyId.setEnabled(false);
				comboBox_1.setEnabled(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}	
			
		});
		
		btnClear.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				Clear();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		

	}
	public void Clear(){
		txtFName.setText("");
		txtMInit.setText("");
		txtLName.setText("");
		txtBusPhone.setText("");
		txtEmail.setText("");

	}
}
