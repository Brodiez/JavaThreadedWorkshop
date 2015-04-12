import java.awt.EventQueue;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;

import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;


public class frmAddEditPackage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -140543490674675351L;
	private JPanel contentPane;
	public boolean isAdd = true;
	public Package package1;
	private JTextField tfPackName;
	private JTextField tfDesc;
	private JTextField tfBasePrice;
	private JTextField tfComm;
	private Vector<Product> products;
	private Vector<Product_Supplier> suppliers;
	private JComboBox<Product> cbxProducts;
	private JComboBox<Product_Supplier> cbxSuppliers;
	private DefaultTableModel prodSup;
	private Vector<String> columnNames;
	private JTable tblProdSupp;
	private Vector<Product_Supplier> newProdSupp;
	private Vector<Packages_Products_Suppliers> packProdSupp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAddEditPackage addEditPackage = new frmAddEditPackage(true, new Package());
					addEditPackage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param package1 
	 */
	
	
	public frmAddEditPackage(boolean isAdd, Package package1) {
		this.isAdd = isAdd;
		this.package1 = package1;
		
		newProdSupp = new Vector<Product_Supplier>();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frmAddEditPackage.this.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
			     onExit();
			   }
			  });
        //frmAddEditPackage.this.addWindowListener(exitListener);
		
		
		setBounds(100, 100, 869, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("New label");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 22));
		lblTitle.setBounds(329, 11, 200, 50);
		contentPane.add(lblTitle);
		
		JLabel lblPackageName = new JLabel("Package Name");
		lblPackageName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPackageName.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPackageName.setBounds(56, 88, 120, 25);
		contentPane.add(lblPackageName);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblStartDate.setBounds(56, 140, 120, 25);
		contentPane.add(lblStartDate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDescription.setBounds(56, 200, 120, 25);
		contentPane.add(lblDescription);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndDate.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEndDate.setBounds(445, 140, 83, 25);
		contentPane.add(lblEndDate);
		
		JLabel lblBasePrice = new JLabel("Base Price");
		lblBasePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBasePrice.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBasePrice.setBounds(56, 261, 120, 25);
		contentPane.add(lblBasePrice);
		
		JLabel lblAgencyCommission = new JLabel("Commission");
		lblAgencyCommission.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAgencyCommission.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAgencyCommission.setBounds(412, 261, 112, 25);
		contentPane.add(lblAgencyCommission);
		
		SqlDateModel model1 = new SqlDateModel();
		if(!isAdd) {
			model1.setValue(package1.getPkgStartDate());
		}
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model1, p1);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl startDate = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		startDate.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 16));
		startDate.setLocation(196, 140);
		startDate.setSize(new Dimension(200, 23));
		contentPane.add(startDate);
		
		SqlDateModel model2 = new SqlDateModel();
		if(!isAdd) {
			model2.setValue(package1.getPkgEndDate());
		}
		Properties p2 = new Properties();
		p2.put("text.today", "Today");
		p2.put("text.month", "Month");
		p2.put("text.year", "Year");
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl endDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
		endDate.getJFormattedTextField().setFont(new Font("Arial", Font.PLAIN, 16));
		endDate.setLocation(547, 140);
		endDate.setSize(new Dimension(200, 25));
		contentPane.add(endDate);
		
		tfPackName = new JTextField();
		tfPackName.setFont(new Font("Arial", Font.PLAIN, 16));
		tfPackName.setBounds(196, 88, 200, 24);
		contentPane.add(tfPackName);
		tfPackName.setColumns(10);
		
		tfDesc = new JTextField();
		tfDesc.setFont(new Font("Arial", Font.PLAIN, 16));
		tfDesc.setColumns(10);
		tfDesc.setBounds(196, 200, 551, 24);
		contentPane.add(tfDesc);
		
		tfBasePrice = new JTextField();
		tfBasePrice.setFont(new Font("Arial", Font.PLAIN, 16));
		tfBasePrice.setColumns(10);
		tfBasePrice.setBounds(196, 261, 200, 24);
		contentPane.add(tfBasePrice);
		
		tfComm = new JTextField();
		tfComm.setFont(new Font("Arial", Font.PLAIN, 16));
		tfComm.setColumns(10);
		tfComm.setBounds(547, 261, 200, 24);
		contentPane.add(tfComm);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isAdd) {
					if(Validation.isPresent(tfPackName) && Validation.isDate(startDate) && Validation.isDate(endDate) && 
							Validation.isDecimal(tfBasePrice) && Validation.isDecimal(tfComm)){
						Package insert = new Package();
						insert.setPkgName(tfPackName.getText());
						insert.setPkgDesc(tfDesc.getText());
						insert.setPkgBasePrice(new BigDecimal(tfBasePrice.getText()));
						insert.setPkgAgencyCommission(new BigDecimal(tfComm.getText()));
						insert.setPkgStartDate((Date)startDate.getModel().getValue());
						insert.setPkgEndDate((Date)endDate.getModel().getValue());
						try {
							insert.setPackageId(PackagesDB.addPackage(insert));
							for(Product_Supplier ps : newProdSupp) {
								Packages_Products_Suppliers pps = new Packages_Products_Suppliers();
								pps.setPackageId(insert.getPackageId());
								pps.setProductSupplierId(ps.getProductSupplierId());
								PackagesDB.addPackProductSupp(pps);
							}
							
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frmPackages frame = new frmPackages();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						frmAddEditPackage.this.dispose();
					}
					
				}
				else {
					if(Validation.isPresent(tfPackName) && Validation.isDate(startDate) && Validation.isDate(endDate) && 
							Validation.isDecimal(tfBasePrice) && Validation.isDecimal(tfComm)){
						Package newPack = new Package();
						newPack.setPkgName(tfPackName.getText());
						newPack.setPkgDesc(tfDesc.getText());
						newPack.setPkgBasePrice(new BigDecimal(tfBasePrice.getText()));
						newPack.setPkgAgencyCommission(new BigDecimal(tfComm.getText()));
						newPack.setPkgStartDate((Date)startDate.getModel().getValue());
						newPack.setPkgEndDate((Date)endDate.getModel().getValue());
						try {
							PackagesDB.updatePackage(package1, newPack);
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frmPackages frame = new frmPackages();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						frmAddEditPackage.this.dispose();
					}
				}
			}
		});
		btnAccept.setBounds(658, 435, 89, 23);
		contentPane.add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPackages fPackages = new frmPackages();
				fPackages.setLocationRelativeTo(null);
				fPackages.setVisible(true);
				frmAddEditPackage.this.dispose();
			}
		});
		btnCancel.setBounds(658, 384, 89, 23);
		contentPane.add(btnCancel);
		
		try {
			products = PackagesDB.getProductList();
			columnNames = new Vector<String>();
			columnNames.addElement("Products");
			columnNames.addElement("Suppliers");
			
			if(isAdd) {
				prodSup = new DefaultTableModel(null, columnNames);
				
			}
			else {
				prodSup = PackagesDB.getProdSupp(package1.getPackageId());
			}

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(50, 299, 542, 190);
			contentPane.add(panel);
			panel.setLayout(null);
			cbxSuppliers = new JComboBox<>();
			cbxSuppliers.setBounds(6, 108, 174, 20);
			panel.add(cbxSuppliers);
			cbxProducts = new JComboBox<Product>(products);
			cbxProducts.setBounds(6, 41, 174, 20);
			panel.add(cbxProducts);
			cbxProducts.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(cbxProducts.getSelectedIndex() != -1) {
						Product p = (Product)cbxProducts.getSelectedItem();
						try {
							suppliers = PackagesDB.getSupplierList(p.getProductId());
							cbxSuppliers.removeAllItems();
							for(Product_Supplier s : suppliers) {
								cbxSuppliers.addItem(s);
							}
							
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			cbxProducts.setSelectedIndex(-1);
			
			JLabel lblProducts = new JLabel("Products");
			lblProducts.setBounds(6, 16, 120, 25);
			panel.add(lblProducts);
			lblProducts.setFont(new Font("Arial", Font.PLAIN, 16));
			
			JLabel lblSuppliers = new JLabel("Suppliers");
			lblSuppliers.setBounds(6, 83, 120, 25);
			panel.add(lblSuppliers);
			lblSuppliers.setFont(new Font("Arial", Font.PLAIN, 16));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(257, 11, 279, 150);
			panel.add(scrollPane);
			
			tblProdSupp = new JTable();
			tblProdSupp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(tblProdSupp);
			tblProdSupp.setModel(prodSup);
			
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(cbxProducts.getSelectedIndex() != -1) {
						if(isAdd) {
						
							Product_Supplier newitem = (Product_Supplier)cbxSuppliers.getSelectedItem();
							newProdSupp.add(newitem);
							prodSup.addRow(new Object[] {newitem.getProdName(), newitem.getSupName()});
						
						}
						else {
							Product_Supplier newitem = (Product_Supplier)cbxSuppliers.getSelectedItem();
							Packages_Products_Suppliers pps = new Packages_Products_Suppliers();
							pps.setPackageId(package1.getPackageId());
							pps.setProductSupplierId(newitem.getProductSupplierId());
							try {
								PackagesDB.addPackProductSupp(pps);
								prodSup.addRow(new Object[] {newitem.getProdName(), newitem.getSupName()});
								cbxProducts.setSelectedIndex(-1);
								//cbxSuppliers.setSelectedIndex(-1);

								cbxSuppliers.removeAllItems();
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
					else {
						JOptionPane.showMessageDialog(frmAddEditPackage.this, "Please select a Product and Supplier");
						cbxProducts.requestFocus();
					}
					
					
				}
			});
			btnAdd.setBounds(6, 160, 89, 23);
			panel.add(btnAdd);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tblProdSupp.getSelectedRowCount() > 0) {
						if(isAdd) {
							newProdSupp.remove(tblProdSupp.getSelectedRow());
							prodSup.removeRow(tblProdSupp.getSelectedRow());
						}
						else {
							try {
								PackagesDB.deletePackProductSupplier(packProdSupp.get(tblProdSupp.getSelectedRow()));
								packProdSupp.remove(tblProdSupp.getSelectedRow());
								prodSup.removeRow(tblProdSupp.getSelectedRow());
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(frmAddEditPackage.this, "Please Select a row from the Products Suppliers table");
					}
				}
			});
			btnDelete.setBounds(131, 160, 89, 23);
			panel.add(btnDelete);
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(isAdd) {
			setTitle("Add Package");
			lblTitle.setText("Add Package");
		}
		else {
			setTitle("Edit Package");
			lblTitle.setText("Edit Package");
			tfPackName.setText(package1.getPkgName());
			tfDesc.setText(package1.getPkgDesc());
			tfBasePrice.setText(package1.getPkgBasePrice().toString());
			tfComm.setText(package1.getPkgAgencyCommission().toString());
			try {
				packProdSupp = PackagesDB.getPackProdSupp(package1.getPackageId());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}
		
	}
	
	private void onExit() {
		// TODO Auto-generated method stub
		frmPackages frame = new frmPackages();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frmAddEditPackage.this.dispose();
	}

	public class DateLabelFormatter extends AbstractFormatter {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 6785084591335700094L;
		private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
}
