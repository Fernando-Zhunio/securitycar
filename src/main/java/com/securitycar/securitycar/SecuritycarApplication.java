package com.securitycar.securitycar;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.securitycar.securitycar.core.users.domain.UserEntity;
import com.securitycar.securitycar.models.RoleEntity;
import com.securitycar.securitycar.repositories.UserRepository;
import com.securitycar.securitycar.util.RoleEnum;

@SpringBootApplication
public class SecuritycarApplication {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecuritycarApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			UserEntity user = UserEntity.builder()
					.email("fzhunio@novicompu.com")
					.username("fernando")
					.password(passwordEncoder.encode("fernando1991"))
					.roles(Set.of(RoleEntity.builder()
							.name(RoleEnum.valueOf(RoleEnum.ADMIN.name()))
							.build()))
					.build();

			userRepository.save(user);
		};
	}
}
