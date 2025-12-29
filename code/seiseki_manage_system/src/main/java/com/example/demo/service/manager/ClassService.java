package com.example.demo.service.manager;

import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.ClassEntity;
import com.example.demo.model.entity.Major;
import com.example.demo.model.entity.Manager;
import com.example.demo.model.form.manager.ClassRegisterForm;
import com.example.demo.repository.ClassesRepository;
import com.example.demo.repository.MajorsRepository;
import com.example.demo.repository.ManagersRepository;

import lombok.RequiredArgsConstructor;



/* ClassServiceクラス (class情報関係サービスクラス)
 * 
 * @author ys
 * 
 */

@Service
@RequiredArgsConstructor

public class ClassService {
	
	private final ClassesRepository repository;
	
	private final ManagersRepository managersRepository;
	
	private final MajorsRepository majorsRepository;
	
	private final DozerBeanMapper mapper;
	
	
	/* すべてのクラスエンティティ群を取得
	 * 
	 * @return クラス一覧情報
	 * 
	 */
	
	public List<ClassEntity> getClasses() {
		
		List<ClassEntity> classesInfo = repository.findAll();
		
		return classesInfo;
		
	}
	
	
	/* idからクラスエンティティ1件を取得
	 * 
	 * @param id 指定されたクラスid
	 * @return クラスエンティティ1件
	 * 
	 */
	
	public ClassEntity getClassById(Integer id) {
		
		ClassEntity classInfo = repository.findById(id).orElse(null);
		
		return classInfo;
		
	}
	
	
	/* startYearからクラスエンティティ群を取得
	 * 
	 * @param startYear 開始年
	 * @return 対象のクラス一覧情報
	 * 
	 */
	
	public List<ClassEntity> getClassesByStartYear(Integer startYear) {
		
		List<ClassEntity> classesInfo = repository.findByStartYear(startYear);
		
		return classesInfo;
		
	}
	
	
	/* nameからmajorエンティティ1件を取得
	 * 
	 * @param name 指定された専攻名
	 * @return 専攻エンティティ1件
	 * 
	 */
	
	public Major getMajorByName(String name) {
		
		Major majorInfo = majorsRepository.findByName(name).orElse(null);
		
		return majorInfo;
		
	}
	
	
	
	/* form入力情報、マネージャーid、専攻idから、クラス登録
	 * 
	 * @param form フォーム入力情報
	 * @param managerId 対象のマネージャーid
	 * @param majorId 対象の専攻id
	 * @return クラスエンティティ1件
	 * 
	 */
	
	public ClassEntity registerClass(ClassRegisterForm form, Integer managerId, Integer majorId) {
		
		ClassEntity classInfo = mapper.map(form,  ClassEntity.class);
		
		Manager managerInfo = managersRepository.findById(managerId).orElse(null);
		
		classInfo.setManager(managerInfo);
		
		Major majorInfo = majorsRepository.findById(majorId).orElse(null);
		
		classInfo.setMajor(majorInfo);
		
		return repository.save(classInfo);
		
		
	}
	
	
	/* idからクラスエンティティ1件を削除
	 * 
	 * @param id 指定されたクラスid
	 * 
	 */
	
	public void deleteClass(Integer id) {
		
		repository.deleteById(id);
		
		
	}
	
	
	/* idと、更新情報、マネージャーid からクラスエンティティ1件を更新
	 * 
	 * @param id 指定されたクラスid
	 * @param updates 対象の更新情報
	 * @param managerId 指定されたマネージャーid
	 * @return クラスエンティティ1件
	 * 
	 */
	
	public ClassEntity updateClass(Integer id, Map<String, String> updates, Integer managerId) {
		
		ClassEntity classInfo = repository.findById(id).orElse(null);
		
		
		updates.forEach((key, value) -> {
			
			
			switch (key) {
			
			
				case "start_year":
					
					classInfo.setStartYear(Integer.parseInt(value));
					
					break;
					
				case "major_name":
					
					Major majorInfo = majorsRepository.findByName(value).orElse(null);
					
					classInfo.setMajor(majorInfo);
					
					break;			
				
			
			}
			
			
		});
		
		
		Manager managerInfo = managersRepository.findById(managerId).orElse(null);
		
		classInfo.setManager(managerInfo);
		
		return repository.save(classInfo);
		
		
	}
	
	
	/* すべてのmajorエンティティ群を取得
	 * 
	 * @return 専攻一覧情報
	 * 
	 */
	
	public List<Major> getMajors() {
		
		List<Major> majorsInfo = majorsRepository.findAll();
		
		return majorsInfo;
		
	}
	
	
	

}
