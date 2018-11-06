package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.admin.StudentPersonMapper;
import cn.java.entity.StudentPerson;
import cn.java.service.StudentPersonIf;

@Service
public class StudentPersonIfImpl implements StudentPersonIf{
	
	@Autowired
	StudentPersonMapper studentPersonMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentPersonMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(StudentPerson record) {
		// TODO Auto-generated method stub
		return studentPersonMapper.insert(record);
	}

	@Override
	public StudentPerson selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<StudentPerson> selectAll() {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKey(StudentPerson record) {
		// TODO Auto-generated method stub
		return studentPersonMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<StudentPerson> selectmajorclassAll(Integer college, Integer major, Integer majorclass) {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectmajorclassAll(college,major,majorclass);
	}

	@Override
	public StudentPerson selectonebyid(String id) {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectonebyid(id);
	}

	@Override
	public int deleteonebyid(String id) {
		// TODO Auto-generated method stub
		return studentPersonMapper.deleteonebyid(id);
	}

	@Override
	public int updateonebyid(StudentPerson record) {
		// TODO Auto-generated method stub
		return studentPersonMapper.updateonebyid(record);
	}

	@Override
	public List<StudentPerson> selectroomAll(Integer dormitory, Integer room) {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectroomAll(dormitory, room);
	}

	@Override
	public List<StudentPerson> selectByroomnum(Integer room) {
		// TODO Auto-generated method stub
		return studentPersonMapper.selectByroomnum(room);
	}

	@Override
	public int updatemoreroom(List<StudentPerson> list) {
		// TODO Auto-generated method stub
		return studentPersonMapper.updatemoreroom(list);
	}
	

}
