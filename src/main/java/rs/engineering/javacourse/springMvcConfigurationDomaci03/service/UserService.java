package rs.engineering.javacourse.springMvcConfigurationDomaci03.service;

import java.util.List;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;

public interface UserService {
	void save(User user);
	List<User> getAll();
	User findById(Long id);
}
