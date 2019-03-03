package com.example.TestCreateProject.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.TestCreateProject.Model.User;

@Repository
public class UserRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL = "select * from user";

	// get all user
	public List<User> getAllUser() {

		List<User> users = new ArrayList<User>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

		for (Map<String, Object> row : rows) {
			User user = new User();
			user.setId_user((int) row.get("id_user"));
			user.setName((String) row.get("name"));
			user.setLastname((String) row.get("lastname"));
			user.setBirthday((java.util.Date) row.get("birthday"));
			user.setApplication_date((java.util.Date) row.get("application_date"));
			user.setAvatar((String) row.get("avatar"));
			user.setBan_day((java.util.Date) row.get("ban_day"));
			user.setEmail((String) row.get("email"));
			user.setPanname((String) row.get("panname"));
			user.setPassword((String) row.get("password"));
			user.setStatus((int) row.get("status"));
			users.add(user);
		}

		return users;
	}

	public int createUser(User user) {

		String sql = "INSERT INTO user (name, lastname, birthday, avatar, email, password, panname) VALUES (?, ?, ?, ?, ?, ?, ?) ";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int insert = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getLastname());
				ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
				ps.setString(4, user.getAvatar());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getPassword());
				ps.setString(7, user.getPanname());
				return ps;
			}
		}, keyHolder);

		if (insert == 1) {
			return keyHolder.getKey().intValue();
		} else {
			return 0;
		}
	}

	public List<User> findByEmail(User user) {

		String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
		// List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, email);
		List<User> users = new ArrayList<User>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				new Object[] { user.getEmail(), user.getPassword() });
		// List<User> userTemp = jdbcTemplate.queryForObject(sql, new Object[] {
		// user.getEmail(), user.getPassword() }, new
		// BeanPropertyRowMapper<User>(User.class));

		// return userTemp;

		for (Map<String, Object> row : rows) {
			User userTemp = new User();
			userTemp.setId_user((int) row.get("id_user"));
			userTemp.setName((String) row.get("name"));
			userTemp.setLastname((String) row.get("lastname"));
			userTemp.setBirthday((java.util.Date) row.get("birthday"));
			userTemp.setApplication_date((java.util.Date) row.get("application_date"));
			userTemp.setAvatar((String) row.get("avatar"));
			userTemp.setBan_day((java.util.Date) row.get("ban_day"));
			userTemp.setEmail((String) row.get("email"));
			userTemp.setPanname((String) row.get("panname"));
			userTemp.setPassword((String) row.get("password"));
			userTemp.setStatus((int) row.get("status"));
			users.add(userTemp);
		}

		return users;

	}
}
