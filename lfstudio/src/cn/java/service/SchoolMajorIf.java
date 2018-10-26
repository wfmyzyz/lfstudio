package cn.java.service;

import java.util.List;

import cn.java.entity.SchoolMajor;

public interface SchoolMajorIf {
	List<SchoolMajor> selectAll();
	
	SchoolMajor selectByPrimaryKey(Integer id);
	
	List<SchoolMajor> selectByPid(Integer pid);
}
