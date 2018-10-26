package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.SchoolCollegeMapper;
import cn.java.entity.SchoolCollege;
import cn.java.service.SchoolCollegeIf;


@Service
public class SchoolCollegeIfImpl implements SchoolCollegeIf{

	@Autowired
	SchoolCollegeMapper schoolCollegeMapper;
	
	@Override
	public List<SchoolCollege> selectAll() {
		// TODO Auto-generated method stub
		return schoolCollegeMapper.selectAll();
	}
	
	@Override
	public List<SchoolCollege> selectAllInMajor() {
		// TODO Auto-generated method stub
		return schoolCollegeMapper.selectAllInMajor();
	}

	@Override
	public SchoolCollege selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return schoolCollegeMapper.selectByPrimaryKey(id);
	}
	
}
