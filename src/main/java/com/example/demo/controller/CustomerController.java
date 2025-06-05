package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.service.CustomerService;

/**
 * 顧客情報登録・更新コントローラークラス
 * <p>
 * 
 */

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * 顧客情報登録処理 登録ボタン押下
	 */
	@PostMapping("/customer/register")
	public String registerCustomer(@ModelAttribute CustomerEntity customer, RedirectAttributes redirectAttributes) {
		customerService.registerCustomer(customer);

		// 登録完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("successMessage", "顧客情報の登録が完了しました。");
		return "redirect:/insertCustomerView"; // 登録完了後の遷移先ページ
	}

	@GetMapping("/customer/form")
	public String showForm(Model model) {
		model.addAttribute("customerEntity", new CustomerEntity());
		return "customerForm";
	}

	/**
	 * 顧客情報更新処理 更新ボタン押下
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute CustomerEntity customer, RedirectAttributes redirectAttributes) {
		customerService.registerCustomer(customer);

		// 更新完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("successMessage", "顧客情報の更新が完了しました。");
		return "redirect:/customerListView"; // 更新完了後の遷移先ページ
	}

}