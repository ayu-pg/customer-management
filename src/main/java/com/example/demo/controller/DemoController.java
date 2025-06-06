package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.ClosingDayEntity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.PaymentMethodsEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

@Controller
public class DemoController {

	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@PostMapping("/login")

	/**
	 * ログイン認証処理
	 * 
	 * @param userId
	 * @param password
	 * @param model
	 * @return
	 */
	public String login(@RequestParam("userid") String userId, @RequestParam("password") String password, Model model,
			HttpSession session) {

		// ユーザー情報を格納
		UserEntity user = userService.findByUserIdAndPassword(userId, password);

		if (user != null) {

			// ユーザー情報をセッションに保存
			session.setAttribute("user", user);
			// ログイン成功時にTopページへ遷移
			return "redirect:/topView";
		} else {
			model.addAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています");
			// ログイン失敗時はログイン画面に戻す
			return "loginView";
		}

	}

	/**
	 * Topページ初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/topView")
	public String readForm(Model model) {

		// Viewへ返す
		return "topView";
	}

	/**
	 * ログイン画面初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/loginView")
	private String readLogin(Model model) {

		// Viewへ返す
		return "loginView";
	}

	/**
	 * 「ログアウト」ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		// セッションを破棄
		session.invalidate();
		// ログイン画面にリダイレクト
		return "redirect:/loginView";
	}

	/**
	 * 「メニューへ戻る」ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/menuback")
	public String menuback(HttpSession session) {

		// TOP画面にリダイレクト
		return "redirect:/topView";
	}

	/**
	 * 「メニュー：顧客登録」ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/insertCustomerView")
	public String insertUserClick(HttpSession session) {

		// 顧客登録画面に遷移
		return "insertCustomerView";
	}

	/**
	 * 「メニュー：顧客一覧」ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/customerListView")
	public String listUserClick(HttpSession session, Model model,
			@RequestParam(name = "sort", required = false, defaultValue = "asc") String sortOrder,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", required = false) String keyword) {

		// ページングと会社名の昇順、降順ソートを同時に設定して取得
		Pageable pageable = PageRequest.of(page, 10);
		Page<CustomerEntity> customerPage;

		// 会社名検索処理（部分一致）
		if (keyword != null && !keyword.isEmpty()) {
			customerPage = customerService.searchCustomersByCompanyName(keyword, pageable, sortOrder);
			model.addAttribute("keyword", keyword);
		} else {
			customerPage = customerService.getCustomersPage(pageable, sortOrder);
		}

		// 一覧の締め日マスタと支払方法マスタのnull補正処理
		List<CustomerEntity> fixedContent = customerPage.stream().map(customer -> {
			if (customer.getClosingDayEntity() == null) {
				customer.setClosingDayEntity(new ClosingDayEntity()); // 空オブジェクトをセット
			}
			if (customer.getPaymentMethodsEntity() == null) {
				customer.setPaymentMethodsEntity(new PaymentMethodsEntity()); // 空オブジェクトをセット
			}
			return customer;
		}).collect(Collectors.toList());

		Page<CustomerEntity> fixedCustomerPage = new PageImpl<>(fixedContent, pageable,
				customerPage.getTotalElements());

		// モデルに渡す（Thymeleafで使うため）
		model.addAttribute("customerPage", fixedCustomerPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("sortOrder", sortOrder);

		return "customerListView";
	}

	/**
	 * メニュー：商品登録」ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/insertProductView")
	public String insertProductClick(HttpSession session) {

		// 商品登録画面に遷移
		return "insertProductView";
	}

	/**
	 * メニュー：商品一覧ボタン押下処理
	 * 
	 * @param session
	 * @param model
	 * @return 商品一覧画面のテンプレート名
	 */
	@GetMapping("/productListView")
	public String listProductClick(HttpSession session, Model model,
			@RequestParam(name = "sort", required = false, defaultValue = "asc") String sortOrder,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "keyword", required = false) String keyword) {

		// 商品一覧リストを設定
		// List<ProductEntity> products = productService.getAllProduct();
		// model.addAttribute("products", products);

		// ソート条件（商品名で昇順または降順）
		Sort sort = "desc".equalsIgnoreCase(sortOrder) ? Sort.by("productName").descending()
				: Sort.by("productName").ascending();

		// ページング＋ソート条件
		Pageable pageable = PageRequest.of(page, 12, sort);

		// サービス呼び出し（ソート順も渡す）
		Page<ProductEntity> productPage = productService.getProductPage(pageable, sortOrder);

		// 商品名検索処理（部分一致）
		if (keyword != null && !keyword.isEmpty()) {
			productPage = productService.searchProductByProductName(keyword, pageable, sortOrder);
			model.addAttribute("keyword", keyword);
		} else {
			productPage = productService.getProductPage(pageable, sortOrder);
		}

		// モデルに渡す
		model.addAttribute("productPage", productPage);
		model.addAttribute("sortOrder", sortOrder);

		// 商品一覧画面に遷移
		return "productListView";
	}

	/**
	 * 「メニュー：顧客一覧」 削除ボタン押下処理
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomerById(id);

		// 削除完了メッセージをフラッシュ属性にセット
		redirectAttributes.addFlashAttribute("deleteMessage", "顧客情報の削除が完了しました。");
		return "redirect:/customerListView";
	}

	/**
	 * 「メニュー：顧客一覧」編集ボタン押下処理
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/editCustomerView")
	public String editUserClick(@RequestParam("id") Long id, Model model) {
		Optional<CustomerEntity> customerOpt = customerService.findById(id);
		if (customerOpt.isPresent()) {
			model.addAttribute("customer", customerOpt.get());
			return "editCustomerView";
		} else {
			// IDが見つからなかった場合の処理（エラー画面など）
			return "redirect:/customerListView"; // 一覧画面に遷移する
		}
	}

}
