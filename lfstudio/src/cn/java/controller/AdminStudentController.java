package cn.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.dao.admin.StudentPersonMapper;
import cn.java.entity.SchoolCollege;
import cn.java.entity.SchoolMajor;
import cn.java.entity.SchoolMajorClass;
import cn.java.entity.StudentPerson;
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
		model.addAttribute("college", colleges.getName());
		model.addAttribute("major", majors.getName());
		model.addAttribute("majorclass", majorclasss.getName());
		model.addAttribute("studentlists", studentlists);
		return "admin/admin/student/classstudentlist.jsp";		
	}
}
