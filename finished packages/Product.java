
public class Product {
	
	private int ProductId;
	private String ProdName;
	
	public Product () { }

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProdName() {
		return ProdName;
	}

	public void setProdName(String prodName) {
		ProdName = prodName;
	}

	@Override
	public String toString() {
		return ProdName;
	}
	
	

}
