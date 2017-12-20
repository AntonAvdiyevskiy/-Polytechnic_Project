package ua.com.dto;

public class CustomerDto {
	private int id;
	
	private String login;
	private String mail;
	public CustomerDto() {
		super();
	}
	public CustomerDto(String login, String mail) {
		super();
		this.login = login;
		this.mail = mail;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
