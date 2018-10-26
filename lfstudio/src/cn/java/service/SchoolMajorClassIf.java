package cn.java.service;

import java.util.List;

import cn.java.entity.SchoolMajorClass;

public interface SchoolMajorClassIf {
	List<SchoolMajorClass> selectAll();
	
	SchoolMajorClass selectByPrimaryKey(Integer id);
	
	List<SchoolMajorClass> selectPid(Integer pid);
}
