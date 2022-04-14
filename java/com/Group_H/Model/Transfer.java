package com.Group_H.Model;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
*/

public class Transfer {

	private int Trans_id;

	private float Amt_temp;
	private String From;
	private String To;

	public int getTrans_id() {
		return Trans_id;
	}

	public void setTrans_id(int trans_id) {
		Trans_id = trans_id;
	}

	public float getAmt_temp() {
		return Amt_temp;
	}

	public void setAmt_temp(float amt_temp) {
		Amt_temp = amt_temp;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public Transfer(int trans_id, float amt_temp, String from, String to) {
		super();
		Trans_id = trans_id;
		Amt_temp = amt_temp;
		From = from;
		To = to;
	}

	public Transfer() {
		super();
	}

	public Transfer(float amt_temp, String from, String to) {
		super();
		Amt_temp = amt_temp;
		From = from;
		To = to;
	}

}
