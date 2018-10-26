package cn.java.service;

import java.util.List;

import cn.java.entity.DormitoryRoom;

public interface DormitoryRoomIf {
	int deleteByPrimaryKey(Integer id);
	
	int insert(DormitoryRoom record);
	
	DormitoryRoom selectByPrimaryKey(Integer id);
	
	List<DormitoryRoom> selectAll();
	
	int updateByPrimaryKey(DormitoryRoom record);
	
	List<DormitoryRoom> selectroomAll(Integer pid);
	
	DormitoryRoom selectroomname(String name,Integer pid);
}
