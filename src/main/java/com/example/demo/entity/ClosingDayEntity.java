package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 締め日マスタ名称取得エンティティクラス closing_daysテーブルに対応しています
 */

@Entity
@Table(name = "closing_days")
public class ClosingDayEntity {

	@Id
	private Integer id;

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