package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品情報リポジトリー クラス productテーブルに対応しています
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
