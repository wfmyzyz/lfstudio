package cn.java.service;

import java.util.List;

import cn.java.entity.DormitoryDdmintext;

public interface DormitoryAdminTextIf {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(DormitoryDdmintext record);
	
	DormitoryDdmintext selectByPrimaryKey(Integer id);
	
	List<DormitoryDdmintext> selectAll();
	
	int updateByPrimaryKey(DormitoryDdmintext record);
	
	List<DormitoryDdmintext> selectByTitleAll(String title);
}
