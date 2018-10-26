package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitoryMapper;
import cn.java.entity.Dormitory;
import cn.java.service.DormitoryIf;

@Service
public class DormitoryIfImpl implements DormitoryIf{
	
	@Autowired
	DormitoryMapper dormitoryMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dormitory record) {
		// TODO Auto-generated method stub
		return dormitoryMapper.insert(record);
	}

	@Override
	public Dormitory selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Dormitory> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Dormitory record) {
		// TODO Auto-generated method stub
		return dormitoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public Dormitory selectdormitoryname(String name) {
		// TODO Auto-generated method stub
		return dormitoryMapper.selectdormitoryname(name);
	}

}
