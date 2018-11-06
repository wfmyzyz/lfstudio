package cn.java.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	List<StudentPerson> selectroomAll(Integer dormitory,Integer room);
	
	List<StudentPerson> selectByroomnum(Integer room);
	
	int updatemoreroom(List<StudentPerson> list);
}
