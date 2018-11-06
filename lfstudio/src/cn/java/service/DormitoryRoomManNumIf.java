package cn.java.service;

import java.util.List;

import cn.java.entity.DormitoryRoomManNum;

public interface DormitoryRoomManNumIf {

	int deleteByPrimaryKey(Integer id);
	
	int insert(DormitoryRoomManNum record);
	
	DormitoryRoomManNum selectByPrimaryKey(Integer id);
	
	List<DormitoryRoomManNum> selectAll();
	
	int updateByPrimaryKey(DormitoryRoomManNum record);
	
	int deletebypid(Integer pid);
	
	int addnum(Integer pid);
	
	int subnum(Integer pid);
}
