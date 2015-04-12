import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class PackagesDB {

	public static DefaultListModel<Package>  getPackages() throws ClassNotFoundException, SQLException {
		DefaultListModel<Package> packages = new DefaultListModel<>();
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select * FROM Packages";

		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Package p = new Package();
				p.setPackageId(rs.getInt("PackageId"));
				p.setPkgName(rs.getString("PkgName"));
				p.setPkgStartDate(rs.getDate("PkgStartDate"));
				p.setPkgEndDate(rs.getDate("PkgEndDate"));
				p.setPkgDesc(rs.getString("PkgDesc"));
				p.setPkgBasePrice(rs.getBigDecimal("PkgBasePrice"));
				p.setPkgAgencyCommission(rs.getBigDecimal("PkgAgencyCommission"));
				packages.addElement(p);
			}
			rs.close();
			
			return packages;
		}
		finally { conn.close(); }

	}
	
	public static ArrayList<Package>  getList() throws ClassNotFoundException, SQLException {
		ArrayList<Package> packages = new ArrayList<>();
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select * FROM Packages";

		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Package p = new Package();
				p.setPackageId(rs.getInt("PackageId"));
				p.setPkgName(rs.getString("PkgName"));
				p.setPkgStartDate(rs.getDate("PkgStartDate"));
				p.setPkgEndDate(rs.getDate("PkgEndDate"));
				p.setPkgDesc(rs.getString("PkgDesc"));
				p.setPkgBasePrice(rs.getBigDecimal("PkgBasePrice"));
				p.setPkgAgencyCommission(rs.getBigDecimal("PkgAgencyCommission"));
				packages.add(p);
			}
			rs.close();
			
			return packages;
		}
		finally { conn.close(); }

	}
	
	public static DefaultTableModel getTableModel() throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select PackageId as ID, PkgName as Name, PkgDesc as Description, PkgBasePrice as BasePrice, PkgAgencyCommission as Commission FROM Packages";
		DefaultTableModel packages;

		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			packages = resultSetToTableModel(rs);
			return packages;
		}
		finally { conn.close(); }

	}
	
	public static DefaultTableModel getProdSupp(int packId) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "Select ProdName AS Products, SupName AS Suppliers " + 
				"FROM Suppliers s, products_suppliers ps, products p, packages_products_suppliers pps " +
				"where s.SupplierId = ps.SupplierId AND ps.ProductId = p.ProductId AND ps.ProductSupplierId = pps.ProductSupplierId AND PackageId = " + packId;
		DefaultTableModel prodsupp;
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			prodsupp = resultSetToTableModel(rs);
			return prodsupp;
		}
		finally { conn.close(); }
	}
	
	public static Vector<Packages_Products_Suppliers> getPackProdSupp(int packid) throws ClassNotFoundException, SQLException {
		
		Vector<Packages_Products_Suppliers> packProdSupp = new Vector<>();
		Connection conn = TravelExpertsDB.Connect();
		String sql = "SELECT * from Packages_Products_Suppliers WHERE PackageId = " + packid;
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Packages_Products_Suppliers pps = new Packages_Products_Suppliers();
				pps.setPackageId(rs.getInt("PackageId"));
				pps.setProductSupplierId(rs.getInt("ProductSupplierId"));
				packProdSupp.add(pps);
			}
			rs.close();
			
		}
		finally { conn.close(); }
		
		return packProdSupp;
	}
	
	
	public static Package getPackage(int PackageId) throws ClassNotFoundException, SQLException {
		Package pack = new Package();
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "SELECT * FROM Packages WHERE PackageId = " + PackageId;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			pack.setPackageId(rs.getInt("PackageId"));
			pack.setPkgName(rs.getString("PkgName"));
			pack.setPkgStartDate(rs.getDate("PkgStartDate"));
			pack.setPkgEndDate(rs.getDate("PkgEndDate"));
			pack.setPkgDesc(rs.getString("PkgDesc"));
			pack.setPkgBasePrice(rs.getBigDecimal("PkgBasePrice"));
			pack.setPkgAgencyCommission(rs.getBigDecimal("PkgAgencyCommission"));
			rs.close();
			return pack;
			
		}
		finally { conn.close(); }
	}
	
	
	public static int addPackage(Package pack) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		//String sql = "INSERT INTO Packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			String sql = "INSERT INTO Packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission) Values('" + 
					pack.getPkgName() + "', '" + pack.getPkgStartDate() + "', '" + pack.getPkgEndDate() + 
					"', '" + pack.getPkgDesc() + "', " + pack.getPkgBasePrice() + ", " + pack.getPkgAgencyCommission() + ")";
			
			Statement stmt = conn.createStatement();
			stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			
			rs.close();
			return id;
		}
		finally { conn.close(); }

	}
	
	public static boolean deletePackage(Package pack) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "DELETE FROM Packages WHERE PackageId = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pack.getPackageId());
			int count = stmt.executeUpdate();
			if(count > 0)
				return true;
			else 
				return false;
		}
		finally { conn.close(); }

	}
	
	public static boolean updatePackage(Package oldPack, Package newPack) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "UPDATE Packages SET PkgName = ?, PkgStartDate = ?, PkgEndDate = ?, " +
                "PkgDesc = ?, PkgBasePrice = ?, PkgAgencyCommission = ?" +
                " WHERE PackageId = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newPack.getPkgName());
			stmt.setDate(2, newPack.getPkgStartDate());
			stmt.setDate(3, newPack.getPkgEndDate());
			stmt.setString(4, newPack.getPkgDesc());
			stmt.setBigDecimal(5, newPack.getPkgBasePrice());
			stmt.setBigDecimal(6, newPack.getPkgAgencyCommission());
			stmt.setInt(7, oldPack.getPackageId());
			int count = stmt.executeUpdate();
			
			if(count > 0)
				return true;
			else 
				return false;
					
		}
		finally { conn.close(); }

	}
	
	// get a list of products for the combobox
	public static Vector<Product> getProductList() throws ClassNotFoundException, SQLException {
		
		Vector<Product> products = new Vector<>();
		Connection conn = TravelExpertsDB.Connect();
		String sql = "SELECT * FROM Products";
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt("ProductId"));
				p.setProdName(rs.getString("ProdName"));
				products.add(p);
			}
			rs.close();
			return products;
		}
		finally { conn.close(); }
	}
	
	// return a vector of suppliers based on the product selected for a combo box
	public static Vector<Product_Supplier> getSupplierList(int productId) throws ClassNotFoundException, SQLException {
		
		Vector<Product_Supplier> suppliers = new Vector<>();
		Connection conn = TravelExpertsDB.Connect();
		String sql = "SELECT * FROM Suppliers s, Products_Suppliers ps, Products p WHERE s.SupplierId = ps.SupplierId AND ps.ProductId = p.ProductId AND ps.ProductId = " + productId;
		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product_Supplier s = new Product_Supplier();
				s.setSupplierId(rs.getInt("SupplierId"));
				s.setSupName(rs.getString("SupName"));
				s.setProductSupplierId(rs.getInt("ProductSupplierId"));
				s.setProductId(rs.getInt("ProductId"));
				s.setProdName(rs.getString("ProdName"));
				suppliers.add(s);
			}
			rs.close();
			return suppliers;
		}
		finally { conn.close(); }
		
	}
	
	public static void addPackProductSupp(Packages_Products_Suppliers packProdSupp) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "INSERT INTO Packages_Products_Suppliers VALUES(" + packProdSupp.getPackageId() + ", " + packProdSupp.getProductSupplierId() + ")";
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		}
		finally { conn.close(); }
	}
	
	public static boolean deletePackProductSupplier(Packages_Products_Suppliers packProdSupp) throws ClassNotFoundException, SQLException {
		
		Connection conn = TravelExpertsDB.Connect();
		String sql = "DELETE FROM Packages_Products_Suppliers "
				+ "WHERE PackageId = " + packProdSupp.getPackageId() + " AND ProductSupplierId = " + packProdSupp.getProductSupplierId();
		
		try {
			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			if (count > 0)
				return true;
			else 
				return false;
		}
		finally { conn.close(); }
	}
	
	public static DefaultTableModel resultSetToTableModel(ResultSet rs) {
		try {
		    ResultSetMetaData metaData = rs.getMetaData();
		    int numberOfColumns = metaData.getColumnCount();
		    Vector<String> columnNames = new Vector<String>();

		    // Get the column names
		    for (int column = 0; column < numberOfColumns; column++) {
			columnNames.addElement(metaData.getColumnLabel(column + 1));
		    }

		    // Get all rows.
		    Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

		    while (rs.next()) {
			Vector<Object> newRow = new Vector<Object>();

			for (int i = 1; i <= numberOfColumns; i++) {
			    newRow.addElement(rs.getObject(i));
			}

			rows.addElement(newRow);
		    }

		    return new DefaultTableModel(rows, columnNames) {
		    	/**
				 * 
				 */
				private static final long serialVersionUID = -2366367103612947008L;

				@Override
		        public boolean isCellEditable(int row, int column) {
		           //all cells false
		           return false;
		        }
		    };
		} catch (Exception e) {
		    e.printStackTrace();

		    return null;
		}
	}
}
