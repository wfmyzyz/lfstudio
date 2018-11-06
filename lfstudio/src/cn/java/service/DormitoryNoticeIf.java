package cn.java.service;

import java.util.List;

import cn.java.entity.DormitorNotice;

public interface DormitoryNoticeIf {
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(DormitorNotice record);
	
	DormitorNotice selectByPrimaryKey(Integer id);
	
	List<DormitorNotice> selectAll();
	
	int updateByPrimaryKey(DormitorNotice record);
}
