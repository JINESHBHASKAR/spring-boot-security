package com.secure.app.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.secure.app.model.Role;
import com.secure.app.model.User;
import com.secure.app.repository.RoleRepository;
import com.secure.app.repository.UserRepository;
import com.secure.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	public UserServiceImpl() {

	}

	@Override
	public User saveUser(User user) {
		log.info("Saving new user {} to the database", user.getName());
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to the database", role.getName());
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {

		log.info("Adding role {} to user ", roleName, username);

		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {

		log.info("fetching user {} ", username);

		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		log.info("fetching all user");
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found inthe database");
		}else {
			log.info("User found in the database:{}", username);
		}
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
	}

}
