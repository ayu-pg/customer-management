package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;

/**
 * 商品情報登録・更新コントローラークラス
 * <p>
 * 
 */

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 商品登録処理 登録ボタン押下
	 */
	@PostMapping("/product/register")
	public String registerProduct(@ModelAttribute ProductEntity product, RedirectAttributes redirectAttributes) {
		productService.registerProduct(product);

		// 登録完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("successMessage", "商品情報の登録が完了しました。");
		return "redirect:/insertProductView"; // 登録完了後の遷移先ページ
	}

	/*
	 * @GetMapping("/customer/form") public String showForm(Model model) {
	 * model.addAttribute("customerEntity", new CustomerEntity()); return
	 * "customerForm"; }
	 */

}