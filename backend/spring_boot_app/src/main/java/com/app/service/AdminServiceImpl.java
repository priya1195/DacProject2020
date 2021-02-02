package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	// dependency
	@Autowired
	private IAdminDao dao;

	@Override
	public List<Admin> getAllAdminDetails() {
		return dao.findAll();
	}

	@Override
	public Admin addAdminDetails(Admin transientPOJO) {
		return dao.save(transientPOJO);
	}

	@Override
	public Optional<Admin> getAdminDetails(int id) {
		return dao.findById(id);
	}

	@Override
	public Admin updateAdminDetails(int id, Admin a1) {
		Optional<Admin> findById = dao.findById(id);
		Admin admin = findById.get();
		admin.setName(a1.getName());
		admin.setEmail(a1.getEmail());
		admin.setAddress(a1.getAddress());
		return admin;
	}

	@Override
	public void deleteAdminDetails(int id) {
		dao.deleteById(id);

	}

}
