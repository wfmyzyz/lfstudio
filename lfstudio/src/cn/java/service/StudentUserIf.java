package cn.java.service;

import java.util.List;

import cn.java.entity.AdminUser;
import cn.java.entity.StudentUser;

public interface StudentUserIf {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(StudentUser record);
	
	StudentUser selectByPrimaryKey(Integer id);
	
	List<StudentUser> selectAll();
	
	int updateByPrimaryKey(StudentUser record);
	
	StudentUser selectadminif(String name);
	
	List<StudentUser> selectlikeAll(String name);
}
