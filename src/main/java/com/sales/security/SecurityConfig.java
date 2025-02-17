package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sales.services.OrderService;

// Reference for logging in functionality: https://stackoverflow.com/questions/49847791/java-spring-security-user-withdefaultpasswordencoder-is-deprecated
// Reference for logging out functionality: https://stackoverflow.com/questions/23661492/implement-logout-functionality-in-spring-boot
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	OrderService os;
	
	//Used for login form and handling logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		os.updateQuantity();
		
        http
			.authorizeRequests()
			.antMatchers("/", "/index.html", "/showProducts.html", "/showOrders.html", "/showCustomers.html", "/addProduct.html", "/newOrder.html", "/addCustomer.html")
			.authenticated()
			.and()
			.formLogin()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");		
	}
	
	//Allows for user to login with the username and password: user
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication() 
			.passwordEncoder(passwordEncoder())
			.withUser("user")
			.password(passwordEncoder().encode("user"))
			.roles("USER");
		
	}

	//encodes the password: user which is passed in from the function above
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}