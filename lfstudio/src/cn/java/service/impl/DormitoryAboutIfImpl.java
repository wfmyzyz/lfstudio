package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.DormitoryAboutMapper;
import cn.java.entity.DormitoryAbout;
import cn.java.entity.JsonBean;
import cn.java.service.DormitoryAboutIf;

@Service
public class DormitoryAboutIfImpl implements DormitoryAboutIf{
	
	@Autowired
	DormitoryAboutMapper dormitoryAboutMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DormitoryAbout record) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.insert(record);
	}

	@Override
	public DormitoryAbout selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DormitoryAbout> selectAll() {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(DormitoryAbout record) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DormitoryAbout> selecByPidtAll(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selecByPidtAll(pid);
	}

	@Override
	public int deleteByPidAll(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.deleteByPidAll(pid);
	}

	@Override
	public List<DormitoryAbout> selectAllDesc(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selectAllDesc(pid);
	}

	@Override
	public DormitoryAbout selectAllDescTop(Integer pid) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selectAllDescTop(pid);
	}

	@Override
	public int updatehygiene(List<JsonBean> list) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.updatehygiene(list);
	}

	@Override
	public List<DormitoryAbout> selectAllGroupby() {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.selectAllGroupby();
	}

	@Override
	public int updatemongthday(List<DormitoryAbout> list) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.updatemongthday(list);
	}

	@Override
	public int insertmore(List<DormitoryAbout> list) {
		// TODO Auto-generated method stub
		return dormitoryAboutMapper.insertmore(list);
	}
	
}
