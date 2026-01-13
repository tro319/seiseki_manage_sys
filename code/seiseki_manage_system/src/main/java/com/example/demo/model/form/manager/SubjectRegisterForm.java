package com.example.demo.model.form.manager;

import java.util.List;

import lombok.Data;

/* 教科登録フォームクラス
 * 
 * @author ys
 * 
 */

@Data

public class SubjectRegisterForm {
	
	private String name;
	
	private String kana;
	
	private List<Integer>  targetClassIds;

}
