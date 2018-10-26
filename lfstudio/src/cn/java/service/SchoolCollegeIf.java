package cn.java.service;

import java.util.List;

import cn.java.entity.SchoolCollege;

public interface SchoolCollegeIf {
	List<SchoolCollege> selectAll();
	
	List<SchoolCollege> selectAllInMajor();
	
	SchoolCollege selectByPrimaryKey(Integer id);
}
