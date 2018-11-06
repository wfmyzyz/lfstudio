package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitoryRoomManNumMapper;
import cn.java.entity.DormitoryRoomManNum;
import cn.java.service.DormitoryRoomManNumIf;

@Service
public class DormitoryRoomManNumIfImpl implements DormitoryRoomManNumIf{
	
	@Autowired
	DormitoryRoomManNumMapper dormitoryRoomManNumMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DormitoryRoomManNum record) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.insert(record);
	}

	@Override
	public DormitoryRoomManNum selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DormitoryRoomManNum> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DormitoryRoomManNum record) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deletebypid(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.deletebypid(pid);
	}

	@Override
	public int addnum(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.addnum(pid);
	}

	@Override
	public int subnum(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomManNumMapper.subnum(pid);
	}

}
