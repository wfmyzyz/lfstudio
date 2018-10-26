package cn.java.service;

import java.util.List;

import cn.java.entity.StudentPerson;


public interface StudentPersonIf {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(StudentPerson record);
	
	StudentPerson selectByPrimaryKey(Integer id);
	
	List<StudentPerson> selectAll();
	
	int updateByPrimaryKey(StudentPerson record);
	
	List<StudentPerson> selectmajorclassAll(Integer college,Integer major,Integer majorclass);
	
	StudentPerson selectonebyid(String id);
	
	int deleteonebyid(String id);
	
	int updateonebyid(StudentPerson record);
}
