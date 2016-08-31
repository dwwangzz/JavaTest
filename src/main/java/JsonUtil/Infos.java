package JsonUtil;


public class Infos {
	
	private int rightType;
	
	private boolean hasFlg;
	
	private String beginDate;
	
	private String endDate;
	
	private String productName;

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public boolean isHasFlg() {
		return hasFlg;
	}

	public void setHasFlg(boolean hasFlg) {
		this.hasFlg = hasFlg;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Infos [rightType=" + rightType + ", hasFlg=" + hasFlg + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", productName=" + productName + "]";
	}

}
