package com.Group_H.Model;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
*/
public class Account {

	private int Acc_id;
	private String Acc_num;
	private String Acc_type;
	private float Acc_bal;
	private String ac_temp1;
	private String ac_temp2;

	public String getAc_temp1() {
		return ac_temp1;
	}

	public void setAc_temp1(String ac_temp1) {
		this.ac_temp1 = ac_temp1;
	}

	public String getAc_temp2() {
		return ac_temp2;
	}

	public void setAc_temp2(String ac_temp2) {
		this.ac_temp2 = ac_temp2;
	}

	private float Temp_amount;
	private String Biller_name;

	public String getBiller_name() {
		return Biller_name;
	}

	public void setBiller_name(String biller_name) {
		Biller_name = biller_name;
	}

	public float getTemp_amount() {
		return Temp_amount;
	}

	public void setTemp_amount(float temp_amount) {
		Temp_amount = temp_amount;
	}

	private int Profile_id;

	public int getAcc_id() {
		return Acc_id;
	}

	public void setAcc_id(int acc_id) {
		Acc_id = acc_id;
	}

	public String getAcc_num() {
		return Acc_num;
	}

	public void setAcc_num(String acc_num) {
		Acc_num = acc_num;
	}

	public String getAcc_type() {
		return Acc_type;
	}

	public void setAcc_type(String acc_type) {
		Acc_type = acc_type;
	}

	public float getAcc_bal() {
		return Acc_bal;
	}

	public void setAcc_bal(float acc_bal) {
		Acc_bal = acc_bal;
	}

	public int getProfile_id() {
		return Profile_id;
	}

	public void setProfile_id(int profile_id) {
		Profile_id = profile_id;
	}

	public Account(int acc_id, String acc_num, String acc_type, float acc_bal, int profile_id) {
		super();
		Acc_id = acc_id;
		Acc_num = acc_num;
		Acc_type = acc_type;
		Acc_bal = acc_bal;
		Profile_id = profile_id;
	}

	public Account(String acc_num, String acc_type, float acc_bal, int profile_id) {
		super();
		Acc_num = acc_num;
		Acc_type = acc_type;
		Acc_bal = acc_bal;
		Profile_id = profile_id;
	}

	public Account() {
		super();
	}

}
