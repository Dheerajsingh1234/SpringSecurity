package com.jpa.mvcboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.mvcboot.model.user;

@Repository
public  interface myrepository extends JpaRepository<user,Integer>{
	
	 user findByUsername( String username);
       //return new
}
