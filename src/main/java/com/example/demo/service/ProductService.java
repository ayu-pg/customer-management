package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品情報サービスクラス
 * <p>
 * 
 */

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 商品情報登録処理
	 * 
	 * @param customer
	 * @return
	 */
	public ProductEntity registerProduct(ProductEntity product) {
		return productRepository.save(product);
	}

}
