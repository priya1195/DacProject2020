package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Restaurent;

public interface IRestaurentDao extends JpaRepository<Restaurent, Integer>{

}
