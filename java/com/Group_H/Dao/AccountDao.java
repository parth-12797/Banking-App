package com.Group_H.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Group_H.Model.Account;
import com.Group_H.Model.Bill;
import com.Group_H.Model.Profile;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include the all function to access data of account*/

public class AccountDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Profile getProfile(int id) {
		String sql = "select * from profile where Login_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Profile>(Profile.class));
	}

	public int AddAcc_type(Account p, HttpSession session, Profile pf) {

		String sql = "insert into account(Acc_num,Acc_type,Acc_bal,Profile_id) values(?,?,?,?)";

		return template.update(sql, session.getAttribute("acc_num"), p.getAcc_type(), 0, pf.getProfile_id());
	}

	public List<Account> getAccount(HttpSession session) {

		String acc_num = (String) session.getAttribute("acc_num");

		return template.query("select * from account where Acc_num='" + acc_num + "';", new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int row) throws SQLException {

				Account e = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));

				return e;
			}
		});
	}

	public Account getAccountDeposit(int id) {

		String sql = "select * from account where Acc_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Account>(Account.class));
	}

	public List<Bill> getBillHistory(int id) {
		return template.query("select * from customer_bill where Profile_id='" + id + "';", new RowMapper<Bill>() {
			public Bill mapRow(ResultSet rs, int row) throws SQLException {

				Bill e = new Bill(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5));

				return e;
			}
		});

	}

	public int AddDeposit(Account p) {

		// System.out.println(p.getTemp_amount());
		float total_amt = p.getAcc_bal() + p.getTemp_amount();
		String sql = "update account set Acc_num='" + p.getAcc_num() + "',Acc_type='" + p.getAcc_type() + "',Acc_bal='"
				+ total_amt + "',Profile_id='" + p.getProfile_id() + "' where Acc_id='" + p.getAcc_id() + "' ";
		return template.update(sql);
	}

	public int updateSaving(float p, HttpSession session) {

		// System.out.println(p.getTemp_amount());
		String acc_num = (String) session.getAttribute("acc_num");
		String sql = "update account set Acc_bal='" + p + "' where Acc_num='" + acc_num + "' and Acc_type='saving' ";
		return template.update(sql);
	}

	public int updateChequing(float p, HttpSession session) {

		// System.out.println(p.getTemp_amount());
		String acc_num = (String) session.getAttribute("acc_num");
		String sql = "update account set Acc_bal='" + p + "' where Acc_num='" + acc_num + "' and Acc_type='chequing' ";
		return template.update(sql);
	}

	public int AddWithdraw(Account p) {

		// System.out.println(p.getTemp_amount());
		float total_amt = p.getAcc_bal() - p.getTemp_amount();
		String sql = "update account set Acc_num='" + p.getAcc_num() + "',Acc_type='" + p.getAcc_type() + "',Acc_bal='"
				+ total_amt + "',Profile_id='" + p.getProfile_id() + "' where Acc_id='" + p.getAcc_id() + "' ";
		return template.update(sql);
	}

	public int AddBill(Account p) {

		// System.out.println(p.getTemp_amount());
		float total_amt = p.getAcc_bal() - p.getTemp_amount();
		String sql = "update account set Acc_num='" + p.getAcc_num() + "',Acc_type='" + p.getAcc_type() + "',Acc_bal='"
				+ total_amt + "',Profile_id='" + p.getProfile_id() + "' where Acc_id='" + p.getAcc_id() + "' ";
		template.update(sql);

		String sql1 = "insert into customer_bill(Biller_name,Amt,Acc_type,Profile_id) values(?,?,?,?)";
		return template.update(sql1, p.getBiller_name(), p.getTemp_amount(), p.getAcc_type(), p.getProfile_id());
	}

	public List<Account> getAccData(String acc_num) {

		return template.query("select * from account where Acc_num='" + acc_num + "';", new RowMapper<Account>() {
			public Account mapRow(ResultSet rs, int row) throws SQLException {

				Account e = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));

				return e;
			}
		});
	}

	public Account getSaving(HttpSession session) {
		String acc_num = (String) session.getAttribute("acc_num");

		String sql = "select * from account where Acc_num=? and Acc_type='saving' ";
		return template.queryForObject(sql, new Object[] { acc_num },
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	public Account getChequing(HttpSession session) {
		String acc_num = (String) session.getAttribute("acc_num");

		String sql = "select * from account where Acc_num=? and Acc_type='chequing' ";
		return template.queryForObject(sql, new Object[] { acc_num },
				new BeanPropertyRowMapper<Account>(Account.class));
	}

}
