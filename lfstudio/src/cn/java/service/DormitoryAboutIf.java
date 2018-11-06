package cn.java.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.java.entity.DormitoryAbout;
import cn.java.entity.JsonBean;

public interface DormitoryAboutIf {
	
	 int deleteByPrimaryKey(Integer id);
	
	 int insert(DormitoryAbout record);
	 
	 DormitoryAbout selectByPrimaryKey(Integer id);
	 
	 List<DormitoryAbout> selectAll();
	 
	 int updateByPrimaryKey(DormitoryAbout record);
	 
	 List<DormitoryAbout> selecByPidtAll(Integer pid);
	 
	 int deleteByPidAll(Integer pid);
	 
	 List<DormitoryAbout> selectAllDesc(Integer pid);
	 
	 DormitoryAbout selectAllDescTop(Integer pid);
	 
	 int updatehygiene(List<JsonBean> list);
	 
	 List<DormitoryAbout> selectAllGroupby();
	 
	 int updatemongthday(List<DormitoryAbout> list);
	 
	 int insertmore(List<DormitoryAbout> list);
}
