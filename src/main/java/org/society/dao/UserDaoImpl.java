package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionOfficer;
import org.society.entities.User;
import org.society.exceptions.DuplicateEntityFoundException;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.UserNotFoundException;
import org.society.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		if(repository.existsById(user.getId())) {
			throw new DuplicateEntityFoundException("Save user", "User is duplicate");
			
		}

		return repository.save(user);
	}

	@Override
	public User update(User user) {
		if(repository.existsById(user.getId())) {
			return repository.save(user);
			
		}
		throw new UserNotFoundException("User not found to update!");
		
	}

	@Override
	public boolean delete(long userId){
		if(repository.existsById(userId)) {
			repository.deleteById(userId);
			return true;
		}

		throw new UserNotFoundException("User not found to delete!");
	}

	@Override
	public List<User> viewUserList() {
		List<User> userList = repository.findAll();
		return userList;
	}

	@Override
	public User findByUserId(long userId) {
		Optional<User> user = repository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else
			throw new UserNotFoundException("User not found!");
	}

}
