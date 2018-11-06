package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitoryDdmintextMapper;
import cn.java.entity.DormitoryDdmintext;
import cn.java.service.DormitoryAdminTextIf;

@Service
public class DormitoryAdmintextIfImpl implements DormitoryAdminTextIf{
	@Autowired
	DormitoryDdmintextMapper dormitoryDdmintextMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DormitoryDdmintext record) {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.insert(record);
	}

	@Override
	public DormitoryDdmintext selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DormitoryDdmintext> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DormitoryDdmintext record) {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DormitoryDdmintext> selectByTitleAll(String title) {
		// TODO Auto-generated method stub
		return dormitoryDdmintextMapper.selectByTitleAll(title);
	}

}
