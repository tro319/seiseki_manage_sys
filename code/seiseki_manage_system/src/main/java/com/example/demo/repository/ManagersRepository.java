package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Manager;

/* ManagersRepositoryクラス (managersテーブル管理)
 * 
 * @author ys
 * 
 */

@Repository

public interface ManagersRepository extends JpaRepository<Manager, Integer> {

	Optional<Manager> findByEmail(String email);
	
}
