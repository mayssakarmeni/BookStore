package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.UserImp;

import org.polytec.vermeg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {
	@Autowired
	UserImp userImp;
	@Transactional
	public List<User> getAllUsers() {
		return userImp.getAll();
	}

	@Transactional
	public User getUserByID(Long idUser) {
		return userImp.getUserByID(idUser);
	}
	@Transactional
	public User getUserByName(String username) {
		return userImp.getUserByName(username);
	}
	@Transactional
	public void SignUp(User user) {
		userImp.SignUp(user);
	}

	@Transactional
	public void updateUser(User user) {
		userImp.updateUser(user);

	}

	@Transactional
	public void deleteUser(Long idUser) {
		userImp.deleteUser(idUser);;
	}

}
