package ua.at.mamdouh.model;

public class Product_Details  implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String prod_size, prod_degree, prod_color, prod_code, prod_model;
	
	

	public Product_Details() {

	}


	public Product_Details(long id, String prod_size, String prod_degree, String prod_color, String prod_code,
			String prod_model) {

		this.id = id;
		this.prod_size = prod_size;
		this.prod_degree = prod_degree;
		this.prod_color = prod_color;
		this.prod_code = prod_code;
		this.prod_model = prod_model;
	}
	
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getProd_size() {
		return prod_size;
	}

	public void setProd_size(String prod_size) {
		this.prod_size = prod_size;
	}

	public String getProd_degree() {
		return prod_degree;
	}

	public void setProd_degree(String prod_degree) {
		this.prod_degree = prod_degree;
	}

	public String getProd_color() {
		return prod_color;
	}

	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}

	public String getProd_code() {
		return prod_code;
	}

	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}

	public String getProd_model() {
		return prod_model;
	}

	public void setProd_model(String prod_model) {
		this.prod_model = prod_model;
	}
	
	
	

}
