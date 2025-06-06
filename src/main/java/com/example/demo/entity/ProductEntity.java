package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商品マスタエンティティクラス productテーブルに対応しています
 */

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 商品名 */
	@Column(name = "product_name")
	private String productName;
	/** サイズ */
	@Column(name = "size")
	private Integer size;
	/** 通常価格 */
	@Column(name = "regular_price")
	private BigDecimal regularPrice;
	
	/** 商品サイズマスタ（名称を取得するためのリレーション） */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "size", referencedColumnName = "id", insertable = false, updatable = false)
	private ProductSizeEntity productSizeEntity;


	// getter/setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public BigDecimal getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(BigDecimal regularPrice) {
		this.regularPrice = regularPrice;
	}
	
	public ProductSizeEntity getProductSizeEntity() {
		return productSizeEntity;
	}

	public void setClosingDayEntity(ProductSizeEntity productSizeEntity) {
		this.productSizeEntity = productSizeEntity;
	}
}