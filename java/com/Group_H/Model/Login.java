package com.Group_H.Model;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
*/
public class Login {

	private int Login_id;
	private String User_name;
	private String Password;
	private String Conf_password;

	public Login(int login_id, String user_name, String password, String conf_password) {
		super();
		Login_id = login_id;
		User_name = user_name;
		Password = password;
		Conf_password = conf_password;
	}

	public String getConf_password() {
		return Conf_password;
	}

	public void setConf_password(String conf_password) {
		Conf_password = conf_password;
	}

	public int getLogin_id() {
		return Login_id;
	}

	public String getUser_name() {
		return User_name;
	}

	public String getPassword() {
		return Password;
	}

	public void setLogin_id(int login_id) {
		Login_id = login_id;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Login(int login_id, String user_name, String password) {
		super();
		Login_id = login_id;
		User_name = user_name;
		Password = password;
	}

	public Login() {
		super();
	}

}
