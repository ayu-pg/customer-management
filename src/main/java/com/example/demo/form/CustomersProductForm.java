package com.example.demo.form;

/**
 * 商品登録フォームのデータを保持するクラス
 * 
 * @author mikek
 *
 */

public class CustomersProductForm {

	/** 商品ID（編集時に必要） */
	private Long id;

	/** 顧客ID */
	private Long customerId;
	/** 商品名 */
	private String productName;
	/** サイズ */
	private Integer size;
	/** 単価 */
	private Integer price;

	// getter, setter

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

}
