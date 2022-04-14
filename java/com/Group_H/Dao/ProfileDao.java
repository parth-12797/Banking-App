package com.Group_H.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Group_H.Model.Profile;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include function to access profile of user*/

public class ProfileDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int Addprofile(Profile p, HttpSession session) {

		String sql = "insert into profile(Name,Address,State,Country,Postalcode,Mobile,Acc_num,Login_id) values(?,?,?,?,?,?,?,?)";

		return template.update(sql, p.getName(), p.getAddress(), p.getState(), p.getCountry(), p.getPostalcode(),
				p.getMobile(), p.getAcc_num(), session.getAttribute("Login_id"));
	}

	public List<Profile> getProfile(HttpSession session) {

		int login_id = (Integer) session.getAttribute("Login_id");
		return template.query("select * from profile where Login_id='" + login_id + "'", new RowMapper<Profile>() {
			public Profile mapRow(ResultSet rs, int row) throws SQLException {
				Profile e = new Profile(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				return e;
			}
		});
	}

	public Profile getProfileById(int id) {
		String sql = "select * from profile where Profile_id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Profile>(Profile.class));
	}

	public int UpdateProfile(Profile p) {

		String sql = "update profile set Name='" + p.getName() + "',Address='" + p.getAddress() + "',State='"
				+ p.getState() + "',Country='" + p.getCountry() + "',Postalcode='" + p.getPostalcode() + "',Mobile='"
				+ p.getMobile() + "' where Profile_id='" + p.getProfile_id() + "' ";
		return template.update(sql);
	}

}
