package org.polytec.vermeg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUser;
private String username;

private String password;

public long getIdUser() {
	return idUser;
}

public void setIdUser(long idUser) {
	this.idUser = idUser;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public User(long idUser, String username, String password) {
	super();
	this.idUser = idUser;
	this.username = username;
	this.password = password;
}

public User() {
	super();
}

@Override
public String toString() {
	return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + "]";
}


}
