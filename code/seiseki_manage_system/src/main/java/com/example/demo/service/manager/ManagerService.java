package com.example.demo.service.manager;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Manager;
import com.example.demo.repository.ManagersRepository;

import lombok.RequiredArgsConstructor;

/* ManagerServiceクラス (manager情報関係サービスクラス)
 * 
 * @author ys
 * 
 */

@Service
@RequiredArgsConstructor

public class ManagerService {

	private final ManagersRepository repository;
	
	/* emailからmanagerエンティティ1件を取得
	 * 
	 * @param email 入力されたメールアドレス
	 * @return managerエンティティ1件
	 * 
	 */
	
	public Manager getManagerByEmail(String email) {
		
		Manager managerInfo = repository.findByEmail(email).orElse(null);
		
		return managerInfo;
		
	}
	
}
