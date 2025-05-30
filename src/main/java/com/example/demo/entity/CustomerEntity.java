package com.example.demo.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 顧客情報エンティティクラス customersテーブルに対応しています
 */

@Entity
@Table(name = "customers")

public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/* 会社名 */
	@Column(name = "company_name", nullable = false, length = 100)
	private String companyName;

	/* 郵便番号 */
	@Column(name = "postal_code", length = 10)
	private String postalCode;

	/* 住所 */
	@Column(length = 255)
	private String address;

	/* 電話番号 */
	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	/* FAX */
	@Column(name = "fax_number", length = 20)
	private String faxNumber;

	/* 締め日（ID） */
	@Column(name = "closing_day")
	private Integer closingDay;

	/* 支払日 */
	@Column(name = "payment_day")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDay;

	/* 支払方法 */
	@Column(name = "payment_method")
	private Integer paymentMethod;

	/** 締め日マスタ（名称を取得するためのリレーション） */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "closing_day", referencedColumnName = "id", insertable = false, updatable = false)
	private ClosingDayEntity closingDayEntity;

	/** 支払方法マスタ（名称を取得するためのリレーション） */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_method", referencedColumnName = "id", insertable = false, updatable = false)
	private PaymentMethodsEntity paymentMethodsEntity;

	// --- getter/setter ---

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Integer getClosingDay() {
		return closingDay;
	}

	public void setClosingDay(Integer closingDay) {
		this.closingDay = closingDay;
	}

	public LocalDate getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(LocalDate paymentDay) {
		this.paymentDay = paymentDay;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ClosingDayEntity getClosingDayEntity() {
		return closingDayEntity;
	}

	public void setClosingDayEntity(ClosingDayEntity closingDayEntity) {
		this.closingDayEntity = closingDayEntity;
	}

	public PaymentMethodsEntity getPaymentMethodsEntity() {
		return paymentMethodsEntity;
	}

	public void setPaymentMethodsEntity(PaymentMethodsEntity paymentMethodsEntity) {
		this.paymentMethodsEntity = paymentMethodsEntity;
	}
}