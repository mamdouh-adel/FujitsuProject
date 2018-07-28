package ua.at.mamdouh.model;

public class Product  implements java.io.Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private String prod_code, prod_comp, prod_type, prod_model;
	
	

	public Product() {

	}

	public Product(String prod_code, String prod_comp, String prod_type, String prod_model) {

		this.prod_code = prod_code;
		this.prod_comp = prod_comp;
		this.prod_type = prod_type;
		this.prod_model = prod_model;
	}

	public String getProd_code() {
		return prod_code;
	}

	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}

	public String getProd_comp() {
		return prod_comp;
	}

	public void setProd_comp(String prod_comp) {
		this.prod_comp = prod_comp;
	}

	public String getProd_type() {
		return prod_type;
	}

	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}

	public String getProd_model() {
		return prod_model;
	}

	public void setProd_model(String prod_model) {
		this.prod_model = prod_model;
	}
	
	
	
	

}
