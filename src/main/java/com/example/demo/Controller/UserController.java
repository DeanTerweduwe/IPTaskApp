package com.example.demo.Controller;


import com.example.demo.Domain.UserRole;
import com.example.demo.dto.CreateUserDTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;
		this.userService.createUser(new CreateUserDTO("admin","admin", UserRole.ADMIN));
		this.userService.createUser(new CreateUserDTO("student","t",UserRole.MEMBER));
	}

	@GetMapping("/signup")
	public String getCreateUser(Model model) {
		model.addAttribute("user", new CreateUserDTO());
		return "signupform";
	}

	@PostMapping("/signup")
	public String postCreateUser(@ModelAttribute("user") @Valid CreateUserDTO user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signupform";
		}
		userService.createUser(user);
		System.out.println(user.getRole());
		System.out.println(user.getUsername());
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "signinform";
	}

	@GetMapping("/accessdenied")
	public String accessdenied(){
		return "accessdenied";
	}
}
