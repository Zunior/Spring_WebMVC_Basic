package rs.engineering.javacourse.springMvcConfigurationDomaci03.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.repository.UserRepository;

@Repository(value = "userJdbcRepository")
public class UserJdbcRepository implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		System.out.println("UserJdbcRepository......save().....");
		jdbcTemplate.update("INSERT INTO user (firstname, lastname, username, password) " + "VALUES (?, ?, ?, ?)",
				user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword());
	}

	@Override
	public List<User> getAll() {
		String query = "SELECT * FROM user";
		return jdbcTemplate.query(query, new UserMapper());
	}

	@Override
	public User findById(Long id) {
		String query = "SELECT * FROM user WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new UserMapper());
	}
	
	//Klasa koja se koristi kod querija
	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}

	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
	}

}
