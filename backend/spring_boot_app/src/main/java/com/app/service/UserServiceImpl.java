package com.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	// dependency
	@Autowired
	private IUserDao dao;

	@Override
	public List<User> getAllUserDetails() {
		return dao.findAll();
	}

	@Override
	public User addUserDetails(User transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Optional<User> getUserDetails(int Loginid) {
		return dao.findById(Loginid);
	}

	@Override
	public User updateUserDetails(int LoginId, User l1) {
		Optional<User> findById = dao.findById(LoginId);
		User loginDetails = findById.get();
		loginDetails.setEmail(l1.getEmail());
		loginDetails.setPassword(l1.getPassword());
		loginDetails.setRole(l1.getRole());
		return loginDetails;
	}

	@Override
	public void deleteUserDetails(int Loginid) {
		dao.deleteById(Loginid);

	}

	@Override
	public User fetchUserByEmailAndPassword(String email,String password) {
		return dao.findByEmailAndPassword(email, password);
	}

	@Override
	public Collection<User> findByRole(String role) {
		return dao.findAllByRole(role);
	}

}
