package cn.java.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.Dormitory;
import cn.java.service.impl.DormitoryIfImpl;

@Component
public class OptionDormitory {
	@Autowired
	DormitoryIfImpl dormitoryIfImpl;
	
	@Transactional
	public int deletedormitory(Integer id) {
		int back = dormitoryIfImpl.deleteByPrimaryKey(id);
		return back;
		
	}
	
	@Transactional
	public int insertdormitory(Dormitory record) {
		int back = dormitoryIfImpl.insert(record);
		return back;
		
	}
}
