package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 支払方法マスタ名称取得エンティティクラス payment_methodsテーブルに対応しています
 */

@Entity
@Table(name = "payment_methods")
public class PaymentMethodsEntity {

	@Id
	private Integer id;
	/** 支払方法名称 */
	@Column(name = "name")
	private String name;

	// getter/setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}