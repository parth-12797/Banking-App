package com.Group_H.Model;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
*/
public class Bill {

	private int Bill_id;
	private String Biller_name;
	private float Amt;
	private String Acc_type;
	private int profile_id;

	public int getBill_id() {
		return Bill_id;
	}

	public void setBill_id(int bill_id) {
		Bill_id = bill_id;
	}

	public String getBiller_name() {
		return Biller_name;
	}

	public void setBiller_name(String biller_name) {
		Biller_name = biller_name;
	}

	public float getAmt() {
		return Amt;
	}

	public void setAmt(float amt) {
		Amt = amt;
	}

	public String getAcc_type() {
		return Acc_type;
	}

	public void setAcc_type(String acc_type) {
		Acc_type = acc_type;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public Bill(int bill_id, String biller_name, float amt, String acc_type, int profile_id) {
		super();
		Bill_id = bill_id;
		Biller_name = biller_name;
		Amt = amt;
		Acc_type = acc_type;
		this.profile_id = profile_id;
	}

	public Bill() {
		super();
	}

}
