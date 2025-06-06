package com.example.demo.repository;

import com.example.demo.entity.CustomerProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

/**
 * 顧客商品情報リポジトリー クラス customer_productテーブルに対応しています
 */
@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProductEntity, Long> {

	// 会社名に指定した文字列が部分一致する顧客情報を取得（ページング対応）
	Page<CustomerProductEntity> findByCustomerEntityCompanyNameContaining(String keyword, Pageable pageable);

}
