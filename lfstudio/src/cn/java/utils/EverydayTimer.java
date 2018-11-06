package cn.java.utils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.java.entity.DormitoryAbout;
import cn.java.service.impl.DormitoryAboutIfImpl;

@Component
public class EverydayTimer {
	@Autowired
	DormitoryAboutIfImpl dormitoryAboutIfImpl;

	@Scheduled(cron = "0 0 0 * * ?")
		public void TaskJob() {
			//	1.判断今天是否为1号
			LocalDate day = LocalDate.now();
			Date monthday = new Date();
			if(day.getDayOfMonth()==1) {
				List<DormitoryAbout> dormitoryaboutlists = dormitoryAboutIfImpl.selectAllGroupby();
				for(DormitoryAbout dormitoryaboutlist:dormitoryaboutlists) {
					dormitoryaboutlist.setMonth(monthday);
					dormitoryaboutlist.setAmountelectric(0d);
					dormitoryaboutlist.setHygiene(0d);
				}
				int back = dormitoryAboutIfImpl.insertmore(dormitoryaboutlists);
				if(back == dormitoryaboutlists.size()) {
					System.out.println("每月新增成功！");
				}else {
					System.out.println("每月新增失败！");
				}
			}else {
				// 2.获取所有宿舍
				List<DormitoryAbout> dormitoryaboutlists = dormitoryAboutIfImpl.selectAllGroupby();
				for(DormitoryAbout dormitoryaboutlist:dormitoryaboutlists) {
					dormitoryaboutlist.setMonth(monthday);
				}
				int back = dormitoryAboutIfImpl.updatemongthday(dormitoryaboutlists);
				if(back == dormitoryaboutlists.size()) {
					System.out.println("每天更新成功！");
				}else {
					System.out.println("每天更新失败！");
				}
			}
	    }
}
