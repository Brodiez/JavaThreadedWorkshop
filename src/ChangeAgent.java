import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;


public class ChangeAgent extends JFrame {

	private JPanel contentPane;
	public Integer agtint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeAgent frame = new ChangeAgent();
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
	public ChangeAgent() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbAgentSelector = new JComboBox(AgentForm.loadComboBox());
		cbAgentSelector.setBounds(37, 102, 376, 24);
		contentPane.add(cbAgentSelector);
		
		
		JLabel lblMoveAllCustomer = new JLabel("Move all customer data to a new Agent");
		lblMoveAllCustomer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMoveAllCustomer.setBounds(37, 20, 376, 50);
		contentPane.add(lblMoveAllCustomer);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(178, 173, 99, 25);
		contentPane.add(btnAccept);
		btnAccept.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Agent agt = (Agent)cbAgentSelector.getSelectedItem();

				try {
					AgentDB.UpdateAgentCustomers(agtint,agt.getAgentId());
					JOptionPane.showMessageDialog(ChangeAgent.this,"SUCCESS");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ChangeAgent.this.dispose();
				
			}
		});
	}
}
