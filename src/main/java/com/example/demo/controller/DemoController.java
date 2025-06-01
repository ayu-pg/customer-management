package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;

@Controller
public class DemoController {

	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;

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
			@RequestParam(name = "sort", required = false, defaultValue = "asc") String sortOrder) {

		// 顧客情報一覧リストを取得
		List<CustomerEntity> customerList = customerService.getAllCustomers();

		// 会社名の昇順、降順のソートを設定
		if ("desc".equalsIgnoreCase(sortOrder)) {
			customerList = customerService.getCustomersSortedByCompanyNameDesc();
		} else {
			customerList = customerService.getCustomersSortedByCompanyNameAsc();
		}

		// モデルに渡す（Thymeleafで使うため）
		model.addAttribute("customerList", customerList);

		// 顧客一覧画面に遷移
		return "customerListView";
	}

}
