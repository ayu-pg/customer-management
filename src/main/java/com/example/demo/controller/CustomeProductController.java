package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CustomerProductEntity;
import com.example.demo.form.CustomersProductForm;
import com.example.demo.service.CustomerProductService;
import com.example.demo.service.CustomerService;

/**
 * 顧客商品情報登録・更新コントローラークラス
 * <p>
 * 
 */

@Controller
public class CustomeProductController {

	@Autowired
	private CustomerProductService customersproductService;
	@Autowired
	private CustomerService customerService;

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
	 * 顧客商品更新処理 更新ボタン押下
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/updateProduct")
	public String updateCustomer(@ModelAttribute CustomerProductEntity product, RedirectAttributes redirectAttributes) {
		customersproductService.registerProduct(product);

		// 更新完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("successMessage", "顧客商品情報の更新が完了しました。");
		return "redirect:/productListView"; // 更新完了後の遷移先ページ
	}

	/**
	 * 「メニュー：商品一覧」 削除ボタン押下処理
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		customersproductService.deleteCustomerById(id);

		// 削除完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("deleteMessage", "顧客情報の削除が完了しました。");
		return "redirect:/productListView";
	}

	/**
	 * 「メニュー：商品一覧」編集ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/editProductView")
	public String editUserClick(@RequestParam("id") Long id, Model model) {
		Optional<CustomerProductEntity> productOpt = customersproductService.findById(id);
		if (productOpt.isPresent()) {
			CustomerProductEntity product = productOpt.get();

			// ★ エンティティの内容をフォームにコピーする
			CustomersProductForm form = new CustomersProductForm();
			form.setId(product.getId()); // IDはhiddenで保持する用
			form.setCustomerId(product.getCustomerId()); // 外部キーのID
			form.setProductName(product.getProductName());
			form.setPrice(product.getPrice());
			form.setSize(product.getSize());

			model.addAttribute("productForm", form); // フォームにセット
			model.addAttribute("customers", customerService.findAll()); // プルダウン用の会社名一覧

			return "editProductView";
		} else {
			return "redirect:/productListView";
		}

	}

}