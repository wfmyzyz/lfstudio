package cn.java.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.DormitoryAbout;
import cn.java.entity.JsonBean;
import cn.java.service.impl.DormitoryAboutIfImpl;

@Component
public class OptionAbout {
	@Autowired
	DormitoryAboutIfImpl dormitoryAboutIfImpl;
	
	@Transactional
	public int updateele(Integer room,double electric) {
		DormitoryAbout about = dormitoryAboutIfImpl.selectAllDescTop(room);
		about.setSurpelectric(about.getSurpelectric()+electric);
		int back = dormitoryAboutIfImpl.updateByPrimaryKey(about);
		return back;
	}
	
	@Transactional
	public int reduceele(Integer room,double electric) {
		DormitoryAbout about = dormitoryAboutIfImpl.selectAllDescTop(room);
		about.setSurpelectric(about.getSurpelectric()-electric);
		int back = dormitoryAboutIfImpl.updateByPrimaryKey(about);
		return back;
	}
	
	@Transactional
	public int updateaboutdata(List<JsonBean> list) {
		int back = dormitoryAboutIfImpl.updatehygiene(list);
		return back;
	}
}
