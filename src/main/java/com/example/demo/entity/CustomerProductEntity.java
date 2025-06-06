package com.example.demo.entity;

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
 * 顧客商品情報マスタエンティティクラス customer_productテーブルに対応しています
 */

@Entity
@Table(name = "customer_product")
public class CustomerProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** 顧客ID */
	@Column(name = "customer_id")
	private Long customerId;
	/** 商品名 */
	@Column(name = "product_name")
	private String productName;
	/** サイズ */
	@Column(name = "size")
	private Integer size;
	/** 通常価格 */
	@Column(name = "price")
	private Integer price;

	/** 商品サイズマスタ（名称を取得するためのリレーション） */
	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "size", referencedColumnName = "id", insertable = false, updatable = false)
	private ProductSizeEntity productSizeEntity;

	/** 顧客情報マスタ（名称を取得するためのリレーション） */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CustomerEntity customerEntity;

	// getter/setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public ProductSizeEntity getProductSizeEntity() {
		return productSizeEntity;
	}

	public void setClosingDayEntity(ProductSizeEntity productSizeEntity) {
		this.productSizeEntity = productSizeEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
}