package cn.java.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.DormitoryRoom;
import cn.java.service.impl.DormitoryRoomIfImpl;

@Component
public class OptionDormitoryRoom {
	@Autowired
	DormitoryRoomIfImpl dormitoryRoomIfImpl;
	
	@Transactional
	public int deleteroom(int id) {
		return dormitoryRoomIfImpl.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int insertroom(DormitoryRoom record) {
		return dormitoryRoomIfImpl.insert(record);
	}
}
