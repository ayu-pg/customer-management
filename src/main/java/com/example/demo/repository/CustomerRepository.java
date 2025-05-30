package com.example.demo.repository;

import com.example.demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 顧客情報リポジトリー クラス
 * customersテーブルに対応しています
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}