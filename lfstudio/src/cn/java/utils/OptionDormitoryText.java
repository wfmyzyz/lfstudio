package cn.java.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.DormitorNotice;
import cn.java.entity.DormitoryDdmintext;
import cn.java.service.impl.DormitoryAdmintextIfImpl;
import cn.java.service.impl.DormitoryNoticeIfImpl;

@Component
public class OptionDormitoryText {
	@Autowired
	DormitoryNoticeIfImpl dormitoryNoticeIfImpl;
	@Autowired
	DormitoryAdmintextIfImpl dormitoryAdmintextIfImpl;
	
	@Transactional
	public int insertnotice(DormitorNotice record) {
		return dormitoryNoticeIfImpl.insert(record);
	}
	
	@Transactional
	public int deletenotice(Integer id) {
		return dormitoryNoticeIfImpl.deleteByPrimaryKey(id);
	}
	
	@Transactional
	public int inserttext(DormitoryDdmintext record) {
		return dormitoryAdmintextIfImpl.insert(record);
	}
	
	@Transactional
	public int updatetext(DormitoryDdmintext record) {
		return dormitoryAdmintextIfImpl.updateByPrimaryKey(record);
	}
	
	@Transactional
	public int deletetext(Integer id) {
		return dormitoryAdmintextIfImpl.deleteByPrimaryKey(id);
	}
}
