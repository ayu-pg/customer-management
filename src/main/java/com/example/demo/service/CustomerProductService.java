package com.example.demo.service;

import com.example.demo.entity.CustomerProductEntity;
import com.example.demo.repository.CustomerProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 顧客商品情報サービスクラス
 * <p>
 * 
 */

@Service
public class CustomerProductService {

	@Autowired
	private CustomerProductRepository customersProductRepository;

	/**
	 * 顧客商品情報登録処理
	 * 
	 * @param customer
	 * @return
	 */
	public CustomerProductEntity registerProduct(CustomerProductEntity product) {
		return customersProductRepository.save(product);
	}

	/**
	 * 商品情報一覧リスト取得処理
	 * 
	 * @return
	 */
	/*
	 * public List<ProductEntity> getAllProduct() { return
	 * productRepository.findAll(); }
	 * 
	 *//**
		 * ページング処理
		 * 
		 * @param pageable
		 * @return
		 */
	/*
	 * 
	 * public Page<ProductEntity> getProductPage(Pageable pageable) { return
	 * productRepository.findAll(pageable); }
	 * 
	 *//**
		 * 商品名の昇順：降順ソート＋ページングを処理
		 * 
		 * @param pageable
		 * @param sortOrder
		 * @return
		 */
	/*
	 * public Page<ProductEntity> getProductPage(Pageable pageable, String
	 * sortOrder) { if ("desc".equalsIgnoreCase(sortOrder)) { return
	 * productRepository.findAllByOrderByProductNameDesc(pageable); } else { return
	 * productRepository.findAllByOrderByProductNameAsc(pageable); } }
	 * 
	 *//**
		 * 商品名検索処理（部分一致）
		 * 
		 * @param keyword
		 * @param pageable
		 * @param sortOrder
		 * @return
		 */
	/*
	 * public Page<ProductEntity> searchProductByProductName(String keyword,
	 * Pageable pageable, String sortOrder) { if
	 * ("desc".equalsIgnoreCase(sortOrder)) { pageable =
	 * PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
	 * Sort.by("productName").descending()); } else { pageable =
	 * PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
	 * Sort.by("productName").ascending()); }
	 * 
	 * return productRepository.findByProductNameContaining(keyword, pageable); }
	 * 
	 *//**
		 * 商品一覧削除処理
		 * 
		 * @param id
		 *//*
			 * public void deleteCustomerById(Long id) { productRepository.deleteById(id); }
			 */
}
