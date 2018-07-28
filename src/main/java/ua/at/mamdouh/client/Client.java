package ua.at.mamdouh.client;

import java.util.Date;

public class Client implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cli_number;
	private String cli_name, cli_lastname, cli_register;
	private Date cli_datebirth;
	
	public Client() {

	}

	public Client(int cli_number, String cli_name, String cli_lastname, String cli_register, Date cli_datebirth) {
	
		this.cli_number = cli_number;
		this.cli_name = cli_name;
		this.cli_lastname = cli_lastname;
		this.cli_register = cli_register;
		this.cli_datebirth = cli_datebirth;
	}

	public int getCli_number() {
		return cli_number;
	}

	public void setCli_number(int cli_number) {
		this.cli_number = cli_number;
	}

	public String getCli_name() {
		return cli_name;
	}

	public void setCli_name(String cli_name) {
		this.cli_name = cli_name;
	}

	public String getCli_lastname() {
		return cli_lastname;
	}

	public void setCli_lastname(String cli_lastname) {
		this.cli_lastname = cli_lastname;
	}

	public String getCli_register() {
		return cli_register;
	}

	public void setCli_register(String cli_register) {
		this.cli_register = cli_register;
	}

	public Date getCli_datebirth() {
		return cli_datebirth;
	}

	public void setCli_datebirth(Date cli_datebirth) {
		this.cli_datebirth = cli_datebirth;
	}
	
	
	
	
	
	
	

}
