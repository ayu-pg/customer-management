package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	/**
	 * ログイン認証サービスクラス
	 * <p>
	 * 
	 */

	@Autowired
	private UserRepository userRepository;

	public UserEntity findByUserIdAndPassword(String userId, String password) {

		UserEntity user = userRepository.findByUserId(userId);

		if (user != null && user.getPassword().trim().equals(password.trim())) {
			return user; // ← ログイン成功時にユーザー情報を返す
		}
		return null; // ← ログイン失敗時は null を返す
	}

}
