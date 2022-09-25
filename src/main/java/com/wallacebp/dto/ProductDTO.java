package com.wallacebp.dto;

import java.io.Serializable;

import com.wallacebp.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Integer stock;
	private Integer quantity;

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Integer stock, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.quantity = quantity;
	}

	public ProductDTO(Product entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.stock = entity.getStock();
		this.quantity = entity.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
