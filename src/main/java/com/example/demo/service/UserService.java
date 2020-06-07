package com.example.demo.service;

import com.example.demo.dto.CreateUserDTO;
import com.example.demo.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDTO createUser(CreateUserDTO userDTO);
}
