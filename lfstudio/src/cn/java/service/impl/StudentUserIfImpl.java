package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.StudentUserMapper;
import cn.java.entity.AdminUser;
import cn.java.entity.StudentUser;
import cn.java.service.StudentUserIf;

@Service
public class StudentUserIfImpl implements StudentUserIf{
	
	@Autowired
	StudentUserMapper studentUserMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(StudentUser record) {
		// TODO Auto-generated method stub
		return studentUserMapper.insert(record);
	}

	@Override
	public StudentUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<StudentUser> selectAll() {
		// TODO Auto-generated method stub
		return studentUserMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(StudentUser record) {
		// TODO Auto-generated method stub
		return studentUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public StudentUser selectadminif(String name) {
		// TODO Auto-generated method stub
		return studentUserMapper.selectadminif(name);
	}

	@Override
	public List<StudentUser> selectlikeAll(String name) {
		// TODO Auto-generated method stub
		return studentUserMapper.selectlikeAll(name);
	}

}
