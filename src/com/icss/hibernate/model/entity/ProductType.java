package com.icss.hibernate.model.entity;

import java.util.Set;

public class ProductType {

	private String id;
	private String num;
	private String name;

	private Set<Product> product;

	public String getId() {
		return id;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
