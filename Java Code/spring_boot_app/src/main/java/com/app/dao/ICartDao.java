package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cart;

public interface ICartDao extends JpaRepository<Cart, Integer> {

}
