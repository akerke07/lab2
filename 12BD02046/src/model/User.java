package model;
import java.io.Serializable;
import java.util.Vector;

public class User{

	private String login;
	private String password;
	private String name;
	
	public User(String name,String login,String password){
		this.name=name;
		this.login=login;
		this.password=password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setEmail(String name) {
		this.name = name;
	}
}
