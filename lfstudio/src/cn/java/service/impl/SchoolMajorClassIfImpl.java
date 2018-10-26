package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.SchoolMajorClassMapper;
import cn.java.entity.SchoolMajorClass;
import cn.java.service.SchoolMajorClassIf;

@Service
public class SchoolMajorClassIfImpl implements SchoolMajorClassIf{
	@Autowired
	SchoolMajorClassMapper schoolMajorClassMapper;
	@Override
	public List<SchoolMajorClass> selectAll() {
		// TODO Auto-generated method stub
		return schoolMajorClassMapper.selectAll();
	}
	
	@Override
	public SchoolMajorClass selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return schoolMajorClassMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SchoolMajorClass> selectPid(Integer pid) {
		// TODO Auto-generated method stub
		return schoolMajorClassMapper.selectPid(pid);
	}

}
