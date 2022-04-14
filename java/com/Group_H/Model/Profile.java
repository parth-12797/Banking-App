package com.Group_H.Model;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
*/
public class Profile {

	private int Profile_id;
	private String Name;
	private String Address;
	private String State;
	private String Country;
	private String Postalcode;
	private String Mobile;
	private String Acc_num;

	public String getAcc_num() {
		return Acc_num;
	}

	public void setAcc_num(String acc_num) {
		Acc_num = acc_num;
	}

	private int Login_id;

	public int getProfile_id() {
		return Profile_id;
	}

	public void setProfile_id(int profile_id) {
		Profile_id = profile_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostalcode() {
		return Postalcode;
	}

	public void setPostalcode(String postalcode) {
		Postalcode = postalcode;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public int getLogin_id() {
		return Login_id;
	}

	public void setLogin_id(int login_id) {
		Login_id = login_id;
	}

	public Profile(int profile_id, String name, String address, String state, String country, String postalcode,
			String mobile, String acc_num, int login_id) {
		super();
		Profile_id = profile_id;
		Name = name;
		Address = address;
		State = state;
		Country = country;
		Postalcode = postalcode;
		Mobile = mobile;
		Acc_num = acc_num;
		Login_id = login_id;
	}

	public Profile() {
		super();
	}

}
