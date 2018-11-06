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
			//	1.�жϽ����Ƿ�Ϊ1��
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
					System.out.println("ÿ�������ɹ���");
				}else {
					System.out.println("ÿ������ʧ�ܣ�");
				}
			}else {
				// 2.��ȡ��������
				List<DormitoryAbout> dormitoryaboutlists = dormitoryAboutIfImpl.selectAllGroupby();
				for(DormitoryAbout dormitoryaboutlist:dormitoryaboutlists) {
					dormitoryaboutlist.setMonth(monthday);
				}
				int back = dormitoryAboutIfImpl.updatemongthday(dormitoryaboutlists);
				if(back == dormitoryaboutlists.size()) {
					System.out.println("ÿ����³ɹ���");
				}else {
					System.out.println("ÿ�����ʧ�ܣ�");
				}
			}
	    }
}
