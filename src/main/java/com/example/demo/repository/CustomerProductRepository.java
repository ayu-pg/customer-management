package com.example.demo.repository;

import com.example.demo.entity.CustomerProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 顧客商品情報リポジトリー クラス customer_productテーブルに対応しています
 */
@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProductEntity, Long> {

	/*
	 * // 商品名のソート順 List<ProductEntity> findAllByOrderByProductNameAsc();
	 * List<ProductEntity> findAllByOrderByProductNameDesc();
	 * 
	 * // ページング処理 // ページング＋ソート処理 Page<ProductEntity>
	 * findAllByOrderByProductNameAsc(Pageable pageable); Page<ProductEntity>
	 * findAllByOrderByProductNameDesc(Pageable pageable);
	 * 
	 * // 商品名に指定した文字列が部分一致する顧客情報を取得（ページング対応） Page<ProductEntity>
	 * findByProductNameContaining(String productName, Pageable pageable);
	 */
}
