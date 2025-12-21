package com.example.demo.service.manager;

import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Manager;
import com.example.demo.model.entity.Subject;
import com.example.demo.model.form.manager.SubjectRegisterForm;
import com.example.demo.repository.ManagersRepository;
import com.example.demo.repository.SubjectsRepository;

import lombok.RequiredArgsConstructor;



/* SubjectServiceクラス (subject情報関係サービスクラス)
 * 
 * @author ys
 * 
 */

@Service
@RequiredArgsConstructor

public class SubjectService {
	
	private final SubjectsRepository repository;
	
	private final ManagersRepository managersRepository;
	
	private final DozerBeanMapper mapper;
	
	
	/* すべてのsubjectエンティティ群を取得
	 * 
	 * @return 教科一覧情報
	 * 
	 */
	
	public List<Subject> getSubjects() {
		
		List<Subject> subjectsInfo = repository.findAll();
		
		return subjectsInfo;
		
	}
	
	
	/* idからsubjectエンティティ1件を取得
	 * 
	 * @param id 指定された教科id
	 * @return subjectエンティティ1件
	 * 
	 */
	
	public Subject getSubjectById(Integer id) {
		
		Subject subjectInfo = repository.findById(id).orElse(null);
		
		return subjectInfo;
		
	}
	
	
	/* nameからsubjectエンティティ1件を取得
	 * 
	 * @param name 指定された教科名
	 * @return subjectエンティティ1件
	 * 
	 */
	
	public Subject getSubjectByName(String name) {
		
		Subject subjectInfo = repository.findByName(name).orElse(null);
		
		return subjectInfo;
		
	}
	
	/* nameから教科情報重複チェック
	 * 
	 * @param name 入力された教科名
	 * @return 重複していたかのT/F
	 * 
	 */
	
	public Boolean checkDouble(String name) {
		
		Boolean doubleCheck = repository.existsByName(name);
		
		return doubleCheck;
		
		
	}
	
	
	/* form入力情報から、教科登録
	 * 
	 * @param form フォーム入力情報
	 * @param managerId 対象のマネージャーid
	 * @return subjectエンティティ1件
	 * 
	 */
	
	public Subject registerSubject(SubjectRegisterForm form, Integer managerId) {
		
		Subject subjectInfo = mapper.map(form,  Subject.class);
		
		Manager managerInfo = managersRepository.findById(managerId).orElse(null);
		
		subjectInfo.setManager(managerInfo);
		
		return repository.save(subjectInfo);
		
		
	}
	
	
	/* idからsubjectエンティティ1件を削除
	 * 
	 * @param id 指定された教科id
	 * 
	 */
	
	public void deleteSubject(Integer id) {
		
		repository.deleteById(id);
		
		
	}
	
	
	/* idと、更新情報からsubjectエンティティ1件を更新
	 * 
	 * @param id 指定された教科id
	 * @param updates 対象の更新情報
	 * @return majorエンティティ1件
	 * 
	 */
	
	public Subject updateSubject(Integer id, Map<String, String>updates, Integer managerId) {
		
		Subject subjectInfo = repository.findById(id).orElse(null);
		
		updates.forEach((key, value) -> {
			
			
			switch (key) {
			
			
				case "name":
					subjectInfo.setName(value);
					break;
					
				case "kana":
					subjectInfo.setKana(value);
					break;			
				
			
			
			}
			
			
		});
		
		Manager managerInfo = managersRepository.findById(managerId).orElse(null);
		
		subjectInfo.setManager(managerInfo);
		
		
		return repository.save(subjectInfo);
		
		
	}
	
	
	

}
