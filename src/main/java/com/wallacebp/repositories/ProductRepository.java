package com.wallacebp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallacebp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
