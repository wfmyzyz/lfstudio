package cn.java.service;

import java.util.List;

import cn.java.entity.Dormitory;

public interface DormitoryIf {
	int deleteByPrimaryKey(Integer id);
	
	int insert(Dormitory record);
	
	Dormitory selectByPrimaryKey(Integer id);
	
	List<Dormitory> selectAll();
	
	int updateByPrimaryKey(Dormitory record);
	
	Dormitory selectdormitoryname(String name);
}
