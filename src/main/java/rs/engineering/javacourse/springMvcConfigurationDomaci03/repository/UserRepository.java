package rs.engineering.javacourse.springMvcConfigurationDomaci03.repository;

import java.util.List;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;


public interface UserRepository {
	void save(User user);
	List<User> getAll();
	User findById(Long id);
}