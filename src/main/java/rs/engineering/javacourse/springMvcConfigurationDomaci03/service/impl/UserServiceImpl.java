package rs.engineering.javacourse.springMvcConfigurationDomaci03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.repository.UserRepository;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
