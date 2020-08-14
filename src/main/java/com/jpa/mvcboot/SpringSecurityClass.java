package com.jpa.mvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SpringSecurityClass extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService;
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception
	 {
			 auth.userDetailsService(userDetailsService);
			 	
	 }
	 
	 @Bean
	 public PasswordEncoder getPaas()
	 {
		 return NoOpPasswordEncoder.getInstance();
	 }
	 @Override
	 public void configure(HttpSecurity http) throws Exception
	 {
		 http
		 		.authorizeRequests()
		 		.antMatchers("/").permitAll()
		 		.antMatchers("/admin").hasAuthority("ADMIN")
		 		.antMatchers("/user").hasAuthority("USER").
		 		anyRequest().authenticated()
		 		
		 		
		 		.and().formLogin().permitAll()
		 		.loginPage("/login").permitAll()
		 		.loginProcessingUrl("/signin")
		 		
		 		
		 		.and().logout().
		 		logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
		 		logoutSuccessUrl("/login")
		 		.and()
		 		.rememberMe();
		 		http.oauth2Login();
	 }
	 
}
