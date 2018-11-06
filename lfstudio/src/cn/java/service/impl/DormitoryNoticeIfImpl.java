package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitorNoticeMapper;
import cn.java.entity.DormitorNotice;
import cn.java.service.DormitoryNoticeIf;

@Service
public class DormitoryNoticeIfImpl implements DormitoryNoticeIf{
	
	@Autowired
	DormitorNoticeMapper dormitoryNoticeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryNoticeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DormitorNotice record) {
		// TODO Auto-generated method stub
		return dormitoryNoticeMapper.insert(record);
	}

	@Override
	public DormitorNotice selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryNoticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DormitorNotice> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryNoticeMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DormitorNotice record) {
		// TODO Auto-generated method stub
		return dormitoryNoticeMapper.updateByPrimaryKey(record);
	}

}
