package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.SchoolMajorMapper;
import cn.java.entity.SchoolMajor;
import cn.java.service.SchoolMajorIf;

@Service
public class SchoolMajorIfImpl implements SchoolMajorIf{
	@Autowired
	SchoolMajorMapper schoolMajorMapper;
	
	@Override
	public List<SchoolMajor> selectAll() {
		// TODO Auto-generated method stub
		return schoolMajorMapper.selectAll();
	}

	@Override
	public SchoolMajor selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return schoolMajorMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SchoolMajor> selectByPid(Integer pid) {
		// TODO Auto-generated method stub
		return schoolMajorMapper.selectByPid(pid);
	}

}
