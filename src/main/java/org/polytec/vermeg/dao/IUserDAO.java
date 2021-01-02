package org.polytec.vermeg.dao;

import java.util.List;


import org.polytec.vermeg.model.User;

public interface IUserDAO {
	public User getUserByName(String username);
	

    public List<User>  getAll();
	public User getUserByID(Long idUser);
	public void SignUp(User user);
	public void updateUser(User user);
	public void deleteUser(Long idUser) ;
}
