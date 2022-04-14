package com.Group_H.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Group_H.Model.Login;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include functions for login and authentication*/

public class LoginDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int AddRegister(Login p) {
		String sql = "insert into login(User_name,Password) values(?,?)";
		return template.update(sql, p.getUser_name(), p.getPassword());
	}

	public Login getId(String name) {
		String sql = "select Login_id from Login where User_name=?";
		return template.queryForObject(sql, new Object[] { name }, new BeanPropertyRowMapper<Login>(Login.class));
	}

	public List<Login> getregisters() {
		return template.query("select * from login", new RowMapper<Login>() {
			public Login mapRow(ResultSet rs, int row) throws SQLException {
				Login e = new Login(rs.getInt(1), rs.getString(2), rs.getString(3));
				return e;
			}
		});
	}
}
