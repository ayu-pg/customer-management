package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CustomerProductEntity;
import com.example.demo.service.CustomerProductService;

/**
 * 顧客商品情報登録・更新コントローラークラス
 * <p>
 * 
 */

@Controller
public class CustomeProductController {

	@Autowired
	private CustomerProductService customersproductService;

	/**
	 * 顧客商品登録処理 登録ボタン押下
	 */
	@PostMapping("/customerProduct/register")
	public String registerProduct(@ModelAttribute CustomerProductEntity product,
			RedirectAttributes redirectAttributes) {
		customersproductService.registerProduct(product);

		// 登録完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("successMessage", "商品情報の登録が完了しました。");
		return "redirect:/insertProductView"; // 登録完了後の遷移先ページ
	}

	/**
	 * 「メニュー：商品一覧」 削除ボタン押下処理
	 * 
	 * @param id
	 * @return
	 *//*
		 * @PostMapping("/deleteProduct") public String
		 * deleteProduct(@RequestParam("id") Long id, RedirectAttributes
		 * redirectAttributes) { productService.deleteCustomerById(id);
		 * 
		 * // 削除完了メッセージをフラッシュ属性にセット
		 * redirectAttributes.addFlashAttribute("deleteMessage", "顧客情報の削除が完了しました。");
		 * return "redirect:/productListView"; }
		 */

}