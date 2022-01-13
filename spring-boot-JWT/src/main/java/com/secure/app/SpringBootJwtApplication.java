package com.secure.app;

import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.secure.app.model.Role;
import com.secure.app.model.User;
import com.secure.app.service.UserService;

@SpringBootApplication
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/**
	@Bean
	CommandLineRunner run(UserService userService) {
		return args->{
			 userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
		
			userService.saveUser(new User(null, "Jinesh KP","jineshkp","12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Aravind KP","aravid","12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Vipin K","vipin","12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Haritha","Haritha","12345", new ArrayList<>()));
			
			userService.addRoleToUser("jineshkp", "ROLE_USER");
			
			userService.addRoleToUser("aravid", "ROLE_MANAGER");
			userService.addRoleToUser("vipin", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Haritha", "ROLE_ADMIN");
			userService.addRoleToUser("aravid", "ROLE_USER");
		};
	}
	**/

}
