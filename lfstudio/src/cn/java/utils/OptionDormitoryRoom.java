package cn.java.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.DormitoryAbout;
import cn.java.entity.DormitoryRoom;
import cn.java.entity.DormitoryRoomManNum;
import cn.java.service.impl.DormitoryAboutIfImpl;
import cn.java.service.impl.DormitoryRoomIfImpl;
import cn.java.service.impl.DormitoryRoomManNumIfImpl;

@Component
public class OptionDormitoryRoom {
	@Autowired
	DormitoryRoomIfImpl dormitoryRoomIfImpl;
	@Autowired
	DormitoryRoomManNumIfImpl dormitoryRoomManNumIfImpl;
	@Autowired
	DormitoryAboutIfImpl dormitoryAboutIfImpl;
	
	@Transactional
	public int deleteroom(int id) {
		System.out.println(id);
		int back1 = dormitoryRoomManNumIfImpl.deletebypid(id);
 		int back2 = dormitoryRoomIfImpl.deleteByPrimaryKey(id);
 		dormitoryAboutIfImpl.deleteByPidAll(id);
 		int back = 0;
 		if(back1==1&&back2==1) {
 			back = 1;
 		}
		return back;
	}
	
	@Transactional
	public int insertroom(DormitoryRoom record) {
		DormitoryRoomManNum dormitorynum = new DormitoryRoomManNum();
		int back2 = 0;
		int back1 = 0;
		back2 = dormitoryRoomIfImpl.insert(record);
		dormitorynum.setPid(record.getId());
		dormitorynum.setNum(0);
		back1 = dormitoryRoomManNumIfImpl.insert(dormitorynum);
		DormitoryAbout about = new DormitoryAbout();
		LocalDate date = LocalDate.now();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = date.atStartOfDay(zone).toInstant();
		Date nowdate =Date.from(instant);
		about.setMonth(nowdate);
		about.setPid(record.getId());
		about.setHygiene(0d);
		about.setAmountelectric(0d);
		about.setSurpelectric(0d);
		dormitoryAboutIfImpl.insert(about);
		int back = 0;
		if(back1==1&&back2==1) {
			back = 1;
		}
		return back;
	}
	
	@Transactional
	public int updateroomgam(DormitoryRoom record) {
		return dormitoryRoomIfImpl.updateByPrimaryKey(record);
	}
	
}
