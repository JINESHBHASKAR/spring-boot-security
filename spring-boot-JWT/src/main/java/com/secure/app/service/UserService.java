package com.secure.app.service;

import java.util.List;

import com.secure.app.model.Role;
import com.secure.app.model.User;

public interface UserService {

	public User saveUser(User user);

	public Role saveRole(Role role);

	public void addRoleToUser(String username, String roleName);

	public User getUser(String username);
	
	public List<User> getUsers();
}
