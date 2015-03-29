import java.math.BigDecimal;
import java.sql.Date;


public class Package {
	
	private int PackageId;
	private String PkgName;
	private Date PkgStartDate;
	private Date PkgEndDate;
	private String PkgDesc;
	private BigDecimal PkgBasePrice;
	private BigDecimal PkgAgencyCommission;
	
	public Package () { }

	public int getPackageId() {
		return PackageId;
	}

	public void setPackageId(int packageId) {
		PackageId = packageId;
	}

	public String getPkgName() {
		return PkgName;
	}

	public void setPkgName(String pkgName) {
		PkgName = pkgName;
	}

	public Date getPkgStartDate() {
		return PkgStartDate;
	}

	public void setPkgStartDate(Date pkgStartDate) {
		PkgStartDate = pkgStartDate;
	}

	public Date getPkgEndDate() {
		return PkgEndDate;
	}

	public void setPkgEndDate(Date pkgEndDate) {
		PkgEndDate = pkgEndDate;
	}

	public String getPkgDesc() {
		return PkgDesc;
	}

	public void setPkgDesc(String pkgDesc) {
		PkgDesc = pkgDesc;
	}

	public BigDecimal getPkgBasePrice() {
		return PkgBasePrice;
	}

	public void setPkgBasePrice(BigDecimal pkgBasePrice) {
		PkgBasePrice = pkgBasePrice;
	}

	public BigDecimal getPkgAgencyCommission() {
		return PkgAgencyCommission;
	}

	public void setPkgAgencyCommission(BigDecimal pkgAgencyCommission) {
		PkgAgencyCommission = pkgAgencyCommission;
	}

	@Override
	public String toString() {
		return PkgName
				+ ", PkgStartDate=" + PkgStartDate + ", PkgEndDate="
				+ PkgEndDate + ", PkgDesc=" + PkgDesc + ", PkgBasePrice="
				+ PkgBasePrice + ", PkgAgencyCommission=" + PkgAgencyCommission
				+ "]";
	}
	
	

}
