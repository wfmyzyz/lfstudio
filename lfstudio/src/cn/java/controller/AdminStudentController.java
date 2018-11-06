package cn.java.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.dao.admin.StudentPersonMapper;
import cn.java.entity.Dormitory;
import cn.java.entity.DormitoryRoom;
import cn.java.entity.SchoolCollege;
import cn.java.entity.SchoolMajor;
import cn.java.entity.SchoolMajorClass;
import cn.java.entity.StudentPerson;
import cn.java.service.impl.DormitoryIfImpl;
import cn.java.service.impl.DormitoryRoomIfImpl;
import cn.java.service.impl.SchoolCollegeIfImpl;
import cn.java.service.impl.SchoolMajorClassIfImpl;
import cn.java.service.impl.SchoolMajorIfImpl;
import cn.java.service.impl.StudentPersonIfImpl;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminStudentController {
	
	@Autowired
	SchoolCollegeIfImpl schoolCollegeIfImpl;
	@Autowired
	SchoolMajorIfImpl schoolMajorIfImpl;
	@Autowired
	SchoolMajorClassIfImpl schoolMajorClassIfImpl;
	@Autowired
	StudentPersonIfImpl studentPersonIfImpl;
	@Autowired
	DormitoryIfImpl dormitoryIfImpl;
	@Autowired
	DormitoryRoomIfImpl dormitoryRoomIfImpl;
	/**
	 * 按学院查询学生
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/college")
	public String collegestudent(Model model) {
		List<SchoolCollege> collegelists = schoolCollegeIfImpl.selectAll();
		List<SchoolMajor> majorlist= schoolMajorIfImpl.selectAll();
		List<SchoolMajorClass> classlist = schoolMajorClassIfImpl.selectAll();
		model.addAttribute("college", collegelists);
		model.addAttribute("major", majorlist);
		model.addAttribute("classes", classlist);
		return "admin/admin/student/collegestudent.jsp";
	}
	
	@RequestMapping("/student/college/class")
	public String classstudent(Model model,HttpServletRequest request) {
		int college = Integer.parseInt(request.getParameter("college"));
		int major = Integer.parseInt(request.getParameter("major"));
		int majorclass = Integer.parseInt(request.getParameter("majorclass"));
		SchoolCollege colleges = schoolCollegeIfImpl.selectByPrimaryKey(college);
		SchoolMajor majors = schoolMajorIfImpl.selectByPrimaryKey(major);
		SchoolMajorClass majorclasss = schoolMajorClassIfImpl.selectByPrimaryKey(majorclass);
		List<StudentPerson> studentlists =  studentPersonIfImpl.selectmajorclassAll(college, major, majorclass);
		model.addAttribute("college", colleges);
		model.addAttribute("major", majors);
		model.addAttribute("majorclass", majorclasss);
		model.addAttribute("studentlists", studentlists);
		return "admin/admin/student/classstudentlist.jsp";		
	}
	@RequestMapping("/student/message/{college}/{major}/{majorclass}/{studentid}")
	public String studentmessage(Model model,@PathVariable(value="college") Integer college,
			@PathVariable(value="major") Integer major,@PathVariable(value="majorclass") Integer majorclass
			,@PathVariable(value="studentid") String studentid) {
		StudentPerson student = studentPersonIfImpl.selectonebyid(studentid);
		SchoolCollege colleges = schoolCollegeIfImpl.selectByPrimaryKey(student.getCollege());
		SchoolMajor majors = schoolMajorIfImpl.selectByPrimaryKey(student.getMajor());
		SchoolMajorClass majorclasss = schoolMajorClassIfImpl.selectByPrimaryKey(student.getMajorclass());
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
		String date=null;
		if(student.getBirthday()!=null) {
			date = simple.format(student.getBirthday());
		}
		String dormitory = "";
		String room = "";
		if(student.getDormitory()==0) {
			dormitory = "该生尚未分配宿舍楼";
		}else {
			Dormitory dormitorys = dormitoryIfImpl.selectByPrimaryKey(student.getDormitory());
			dormitory = dormitorys.getName();
		}
		if(student.getRoom()==0) {
			room = "该生尚未分配宿舍";
		}else {
			DormitoryRoom dormitoryrooms = dormitoryRoomIfImpl.selectByPrimaryKey(student.getRoom());
			room = dormitoryrooms.getName();
		}
		model.addAttribute("dormitory", dormitory);
		model.addAttribute("room", room);
		model.addAttribute("date", date);
		model.addAttribute("college", colleges);
		model.addAttribute("major", majors);
		model.addAttribute("majorclass", majorclasss);
		model.addAttribute("student", student);
		return "admin/admin/student/studentmessage.jsp";
	}
}
