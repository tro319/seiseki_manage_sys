package com.example.demo.service.manager;

import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Major;
import com.example.demo.model.form.manager.MajorRegisterForm;
import com.example.demo.repository.MajorsRepository;

import lombok.RequiredArgsConstructor;



/* MajorServiceクラス (major情報関係サービスクラス)
 * 
 * @author ys
 * 
 */

@Service
@RequiredArgsConstructor

public class MajorService {
	
	private final MajorsRepository repository;
	
	private final DozerBeanMapper mapper;
	
	
	/* すべてのmajorエンティティ群を取得
	 * 
	 * @return 専攻一覧情報
	 * 
	 */
	
	public List<Major> getMajors() {
		
		List<Major> majorsInfo = repository.findAll();
		
		return majorsInfo;
		
	}
	
	
	/* idからmajorエンティティ1件を取得
	 * 
	 * @param id 指定された専攻id
	 * @return majorエンティティ1件
	 * 
	 */
	
	public Major getMajor(Integer id) {
		
		Major majorInfo = repository.findById(id).orElse(null);
		
		return majorInfo;
		
	}
	
	
	/* nameからmajorエンティティ1件を取得
	 * 
	 * @param name 指定された専攻名
	 * @return majorエンティティ1件
	 * 
	 */
	
	public Major getMajorByName(String name) {
		
		Major majorInfo = repository.findByName(name).orElse(null);
		
		return majorInfo;
		
	}
	
	/* nameから専攻情報重複チェック
	 * 
	 * @param name 入力された専攻名
	 * @return 重複していたかのT/F
	 * 
	 */
	
	public Boolean checkDouble(String name) {
		
		Boolean doubleCheck = repository.existsByName(name);
		
		return doubleCheck;
		
		
	}
	
	
	/* form入力情報から、専攻登録
	 * 
	 * @param form 
	 * @param updates 対象の更新情報
	 * @return majorエンティティ1件
	 * 
	 */
	
	public Major registerMajor(MajorRegisterForm form) {
		
		Major majorInfo = mapper.map(form,  Major.class);
		
		return repository.save(majorInfo);
		
		
	}
	
	
	/* idからmajorエンティティ1件を削除
	 * 
	 * @param id 指定された専攻id
	 * 
	 */
	
	public void deleteMajor(Integer id) {
		
		repository.deleteById(id);
		
		
	}
	
	
	/* idと、更新情報からmajorエンティティ1件を更新
	 * 
	 * @param id 指定された専攻id
	 * @param updates 対象の更新情報
	 * @return majorエンティティ1件
	 * 
	 */
	
	public Major updateMajor(Integer id, Map<String, String>updates) {
		
		Major majorInfo = repository.findById(id).orElse(null);
		
		updates.forEach((key, value) -> {
			
			
			switch (key) {
			
			
				case "name":
					majorInfo.setName(value);
					break;
					
				case "kana":
					majorInfo.setKana(value);
					break;			
				
			
			
			}
			
			
		});
		
		
		return repository.save(majorInfo);
		
		
	}
	
	
	

}
