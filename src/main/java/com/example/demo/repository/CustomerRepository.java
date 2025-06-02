package com.example.demo.repository;

import com.example.demo.entity.CustomerEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

/**
 * 顧客情報リポジトリー クラス customersテーブルに対応しています
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>
{

	// 会社名のソート順
	List<CustomerEntity> findAllByOrderByCompanyNameAsc();
	List<CustomerEntity> findAllByOrderByCompanyNameDesc();

	// ページング処理
	// ページング＋ソート処理
	Page<CustomerEntity> findAllByOrderByCompanyNameAsc(Pageable pageable);
	Page<CustomerEntity> findAllByOrderByCompanyNameDesc(Pageable pageable);

	// 会社名に指定した文字列が部分一致する顧客情報を取得（ページング対応）
	Page<CustomerEntity> findByCompanyNameContaining(String companyName, Pageable pageable);
	
	

}

