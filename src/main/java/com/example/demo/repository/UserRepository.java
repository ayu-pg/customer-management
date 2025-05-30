package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ログイン認証リポジトリークラス
 * <p>
 * userlistテーブルに対応したリポジトリーで、DB操作を行います。
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(String userId);
}