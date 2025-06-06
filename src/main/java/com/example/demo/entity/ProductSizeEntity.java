package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * サイズ名称取得エンティティクラス product_sizeテーブルに対応しています
 */

@Entity
@Table(name = "product_size")
public class ProductSizeEntity {

	@Id
	private Integer id;
	/** サイズ名称 */
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