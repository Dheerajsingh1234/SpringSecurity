package com.jpa.mvcboot.databse;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jpa.mvcboot.model.user;

public class detailsdatabase implements UserDetails{

	public String Username;
	public String Password;
	public int Active;
	public List<GrantedAuthority> authorities;
	public detailsdatabase(user users) {
		this.Username= users.getUsername();
		this.Password=users.getPassword();
		this.authorities=Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return Password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
