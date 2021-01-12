package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILoginDetailsDao;
import com.app.pojos.LoginDetails;

@Service
@Transactional
public class LoginDetailsServiceImpl implements ILoginDetailsService {
	// dependency
	@Autowired
	private ILoginDetailsDao dao;

	@Override
	public List<LoginDetails> getAllLoginDetails() {
		return dao.findAll();
	}

	@Override
	public LoginDetails addLoginDetails(LoginDetails transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Optional<LoginDetails> getLoginDetails(int Loginid) {
		return dao.findById(Loginid);
	}

	@Override
	public LoginDetails updateLoginDetails(int LoginId, LoginDetails l1) {
		Optional<LoginDetails> findById = dao.findById(LoginId);
		LoginDetails loginDetails = findById.get();
		loginDetails.setEmail(l1.getEmail());
		loginDetails.setPassword(l1.getPassword());
		loginDetails.setRole(l1.getRole());
		return loginDetails;
	}

	@Override
	public void deleteLoginDetails(int Loginid) {
		dao.deleteById(Loginid);

	}

}
