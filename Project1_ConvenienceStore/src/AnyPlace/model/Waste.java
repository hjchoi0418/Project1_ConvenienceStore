package AnyPlace.model;

public class Waste {
	private String waste_no;
	private String product_no;
	private String waste_date;
	public String getWaste_no() {
		return waste_no;
	}
	public void setWaste_no(String waste_no) {
		this.waste_no = waste_no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}

	public String getWaste_date() {
		return waste_date;
	}
	public void setWaste_date(String waste_date) {
		this.waste_date = waste_date;
	}
	@Override
	public String toString() {
		return "Waste [waste_no=" + waste_no + ", product_no=" + product_no + ", waste_date=" + waste_date + "]";
	}

}