package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.LoginDetails;

public interface ILoginDetailsDao extends JpaRepository<LoginDetails, Integer>{

}
