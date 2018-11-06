package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitoryRoomMapper;
import cn.java.entity.DormitoryRoom;
import cn.java.service.DormitoryRoomIf;

@Service
public class DormitoryRoomIfImpl implements DormitoryRoomIf{
	@Autowired
	DormitoryRoomMapper dormitoryRoomMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DormitoryRoom record) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.insert(record);
	}

	@Override
	public DormitoryRoom selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DormitoryRoom> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DormitoryRoom record) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DormitoryRoom> selectroomAll(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selectroomAll(pid);
	}

	@Override
	public DormitoryRoom selectroomname(String name,Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selectroomname(name,pid);
	}

	@Override
	public List<Map<Object,Object>> selectroomAllnum(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selectroomAllnum(pid);
	}

	@Override
	public List<Object> selecthygiene(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryRoomMapper.selecthygiene(pid);
	}

}
