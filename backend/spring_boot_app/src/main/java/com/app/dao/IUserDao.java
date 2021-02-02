package com.app.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
    Collection<User> findAllByRole(String role);
    User findByEmailAndPassword(String email,String password);
}
