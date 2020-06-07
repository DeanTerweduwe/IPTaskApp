package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// css, img, js en javascript wel toelaten
		web.ignoring()
				.antMatchers("/resources/**")
				.antMatchers("/style**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.mvcMatchers("/","/login","/signup","/api/tasks/**").permitAll()
				.mvcMatchers(
						"/tasks/new",
						"/tasks/edit/{id}",
						"/tasks/{id}/sub/new"
				).hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/tasks",true)
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessdenied");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
				.passwordEncoder(passwordEncoder);
	}
}
