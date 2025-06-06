package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品情報リポジトリー クラス productテーブルに対応しています
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	// 商品名のソート順
	List<ProductEntity> findAllByOrderByProductNameAsc();
	List<ProductEntity> findAllByOrderByProductNameDesc();

	// ページング処理
	// ページング＋ソート処理
	Page<ProductEntity> findAllByOrderByProductNameAsc(Pageable pageable);
	Page<ProductEntity> findAllByOrderByProductNameDesc(Pageable pageable);
	
	// 商品名に指定した文字列が部分一致する顧客情報を取得（ページング対応）
	Page<ProductEntity> findByProductNameContaining(String productName, Pageable pageable);
}
