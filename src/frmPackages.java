import java.awt.Component;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class frmPackages extends JFrame {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -2805805867999227623L;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	
	private TableModel packages;
	private JPanel contentPane;
	private JTable tblPackages;
	private JButton btnClose;
	public Package selected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPackages frame = new frmPackages();
					frame.setLocationRelativeTo(null);
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
	public frmPackages() {
		setTitle("Packages");
		
		selected = new Package();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 43, 589, 243);
		contentPane.add(scrollPane);
		
		tblPackages = new JTable();
		tblPackages.setFont(new Font("Arial", Font.PLAIN, 14));
		tblPackages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblPackages);
		getTableData();
				
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddEditPackage addEditPackage = new frmAddEditPackage(true, selected);
				addEditPackage.setLocationRelativeTo(null);
				addEditPackage.setVisible(true);
				frmPackages.this.dispose();
			}
		});
		btnAdd.setBounds(655, 46, 89, 23);
		contentPane.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tblPackages.getSelectedRow() != -1) {
						selected = PackagesDB.getPackage((int) packages.getValueAt(tblPackages.getSelectedRow(), 0));
						frmAddEditPackage addEditPackage = new frmAddEditPackage(false, selected);
						addEditPackage.setLocationRelativeTo(null);

						addEditPackage.setVisible(true);
						frmPackages.this.dispose();

					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnEdit.setBounds(655, 97, 89, 23);
		contentPane.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tblPackages.getSelectedRow() != -1) {
						selected = PackagesDB.getPackage((int) packages.getValueAt(tblPackages.getSelectedRow(), 0));
						PackagesDB.deletePackage(selected);
						getTableData();
					}
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnDelete.setBounds(655, 152, 89, 23);
		contentPane.add(btnDelete);
		
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPackages.this.dispose();
			}
		});
		btnClose.setBounds(655, 263, 89, 23);
		contentPane.add(btnClose);
	}
	
	private void fixWidth(final JTable table, final int columnIndex, final int width) {
	    TableColumn column = table.getColumnModel().getColumn(columnIndex);
	    column.setMinWidth(width);
	    column.setMaxWidth(width);
	    column.setPreferredWidth(width);
	}
	
	// method to auto resize columns based on the data 
	@SuppressWarnings("unused")
	private void autoResizeColumns(final JTable table) {
		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();

		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);

		        //  We've exceeded the maximum width, no need to check other rows

		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }

		    tableColumn.setPreferredWidth( preferredWidth );
		}
	}
	
	public void getTableData() {
		try {
			packages = PackagesDB.getTableModel();
			tblPackages.setModel(packages);
			//tblPackages.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
			//autoResizeColumns(tblPackages);

			fixWidth(tblPackages, 0, 0);
			fixWidth(tblPackages, 1, 150);
			fixWidth(tblPackages, 2, 310);
			fixWidth(tblPackages, 3, 70);
			fixWidth(tblPackages, 4, 60);

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
