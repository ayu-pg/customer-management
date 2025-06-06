package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	/**
	 * 商品情報一覧リスト取得処理
	 * 
	 * @return
	 */
	public List<ProductEntity> getAllProduct() {
		return productRepository.findAll();
	}

	/**
	 * 商品名の昇順：降順ソート＋ページングを処理
	 * 
	 * @param pageable
	 * @param sortOrder
	 * @return
	 */
	public Page<ProductEntity> getProductPage(Pageable pageable, String sortOrder) {
		if ("desc".equalsIgnoreCase(sortOrder)) {
			return productRepository.findAllByOrderByProductNameDesc(pageable);
		} else {
			return productRepository.findAllByOrderByProductNameAsc(pageable);
		}
	}

}
