package cn.java.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.java.entity.AdminUser;
import cn.java.entity.Dormitory;
import cn.java.entity.DormitoryRoom;
import cn.java.entity.SchoolCollege;
import cn.java.entity.SchoolMajor;
import cn.java.entity.SchoolMajorClass;
import cn.java.entity.StudentPerson;
import cn.java.entity.StudentUser;
import cn.java.service.impl.AdminUserIfImpl;
import cn.java.service.impl.DormitoryIfImpl;
import cn.java.service.impl.DormitoryRoomIfImpl;
import cn.java.service.impl.SchoolCollegeIfImpl;
import cn.java.service.impl.SchoolMajorClassIfImpl;
import cn.java.service.impl.SchoolMajorIfImpl;
import cn.java.service.impl.StudentPersonIfImpl;
import cn.java.service.impl.StudentUserIfImpl;
import cn.java.utils.OptionAdminuser;
import cn.java.utils.OptionStudentuser;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminUserController {
	@Autowired
	AdminUserIfImpl adminUserIfImpl;
	@Autowired
	StudentUserIfImpl studentUserIfImpl;
	@Autowired 
	OptionAdminuser optionAdminuser;
	@Autowired 
	OptionStudentuser optionStudentuser;
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
	 * ����Ա�б�
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminuser")
	public String adminuser(Model model,ModelMap map,HttpServletRequest request) {
		List<AdminUser> userlist;
		int pagenum = 10;
		if(request.getParameter("pageid")==null) {
			PageHelper.startPage(1, pagenum);
			userlist = adminUserIfImpl.selectAll();
		}else {
			int start = Integer.parseInt(request.getParameter("pageid"));
			PageHelper.startPage(start, pagenum); 
			userlist = adminUserIfImpl.selectAll();
		}
		model.addAttribute("pages", ((Page)userlist).getPages());
		model.addAttribute("nowpage", ((Page)userlist).getPageNum());
		model.addAttribute("userlist", userlist);
		model.addAttribute("message", map.get("message"));
		model.addAttribute("url", request.getContextPath()+"/admin/adminuser.shtml");
		return "admin/admin/user/adminuser.jsp";
		
	}
	/**
	 * 	��������Ա
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/actionadminuser")
	public String actionadminuser(Model model,HttpServletRequest request,RedirectAttributes attr) {
		if(request.getParameter("act").equals("insert")) {
			AdminUser adminuser = new AdminUser();
			model.addAttribute("admin", adminuser);
			return "admin/admin/user/addadminuser.jsp";
		}
		if(request.getParameter("act").equals("delete")) {
			int back = optionAdminuser.deleteadminuser(Integer.parseInt(request.getParameter("id")));
			if(back==1) {
				attr.addFlashAttribute("message", "ɾ���ɹ���");
				return "redirect:/admin/adminuser.shtml";
			}else {
				attr.addFlashAttribute("message", "ɾ��ʧ�ܣ����ٴ�ɾ����");
				return "redirect:/admin/adminuser.shtml";
			}
		}
		if(request.getParameter("act").equals("update")) {
			AdminUser adminuser = adminUserIfImpl.selectByPrimaryKey(Integer.parseInt(request.getParameter("id")));
			model.addAttribute("admin", adminuser);
			return "admin/admin/user/updateadminuser.jsp";
		}
		return null;
	}
	
	/**
	 *	���ӣ��޸Ĺ���Ա
	 * @param model
	 * @param adminuser
	 * @param result
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value="/operationadminuser",method=RequestMethod.POST)
	public String operationadminuser(Model model,@Valid @ModelAttribute("admin") AdminUser adminuser,BindingResult result,
			HttpServletRequest request,RedirectAttributes attr) {
		if (result.hasErrors()){
			model.addAttribute("admin", adminuser);
			return "admin/admin/user/addadminuser.jsp";
		}
		if(request.getParameter("act").equals("insert")) {
			int back = optionAdminuser.insertadminuser(adminuser);
			if(back==1) {
				attr.addFlashAttribute("message", "��ӳɹ���");
				return "redirect:/admin/adminuser.shtml";
			}else {
				attr.addFlashAttribute("message", "���ʧ�ܣ����ٴ���ӣ�");
				return "redirect:/admin/adminuser.shtml";
			}
		}
		if(request.getParameter("act").equals("update")) {
			int back = optionAdminuser.updateadminuser(adminuser);
			if(back==1) {
				attr.addFlashAttribute("message", "�޸ĳɹ���");
				return "redirect:/admin/adminuser.shtml";
			}else {
				attr.addFlashAttribute("message", "�޸�ʧ�ܣ����ٴ��޸ģ�");
				return "redirect:/admin/adminuser.shtml";
			}
		}
		return null;
		
	}
	
	/**
	 * ѧ���û��б�
	 */
	@RequestMapping("/studentuser")
	public String studentuser(Model model,ModelMap map,HttpServletRequest request) {
		if(request.getParameter("act") != null) {
			List<StudentUser> userlist;
			int pagenum = 10;
			String name = request.getParameter("pid");
			if(request.getParameter("pageid")==null) {
				PageHelper.startPage(1, pagenum);
				userlist = studentUserIfImpl.selectlikeAll(name+"%");
			}else {
				int start = Integer.parseInt(request.getParameter("pageid"));
				PageHelper.startPage(start, pagenum); 
				userlist = studentUserIfImpl.selectlikeAll(name+"%");
			}
			model.addAttribute("pages", ((Page)userlist).getPages());
			model.addAttribute("nowpage", ((Page)userlist).getPageNum());
			model.addAttribute("userlist", userlist);
			model.addAttribute("message", map.get("message"));
			model.addAttribute("url", request.getContextPath()+"/admin/studentuser.shtml");
			return "admin/admin/user/studentuser.jsp";
		}else {
			List<StudentUser> userlist;
			int pagenum = 10;
			if(request.getParameter("pageid")==null) {
				PageHelper.startPage(1, pagenum);
				userlist = studentUserIfImpl.selectAll();
			}else {
				int start = Integer.parseInt(request.getParameter("pageid"));
				PageHelper.startPage(start, pagenum); 
				userlist = studentUserIfImpl.selectAll();
			}
			model.addAttribute("pages", ((Page)userlist).getPages());
			model.addAttribute("nowpage", ((Page)userlist).getPageNum());
			model.addAttribute("userlist", userlist);
			model.addAttribute("message", map.get("message"));
			model.addAttribute("url", request.getContextPath()+"/admin/studentuser.shtml");
			return "admin/admin/user/studentuser.jsp";	
		}
	}
	
	/**
	 * ����ѧ���û�
	 */
	@RequestMapping("/actionstudentuser")
	public String actionstudentuser(Model model,HttpServletRequest request,RedirectAttributes attr) {
		if(request.getParameter("act").equals("insert")) {
			StudentUser studentuser = new StudentUser();
			model.addAttribute("student", studentuser);
			return "admin/admin/user/addstudentuser.jsp";
		}
		if(request.getParameter("act").equals("delete")) {
			int back = optionStudentuser.deleteadminuser(Integer.parseInt(request.getParameter("id")),request.getParameter("pid"));
			if(back==1) {
				attr.addFlashAttribute("message", "ɾ���ɹ���");
				return "redirect:/admin/studentuser.shtml";
			}else {
				attr.addFlashAttribute("message", "ɾ��ʧ�ܣ����ٴ�ɾ����");
				return "redirect:/admin/studentuser.shtml";
			}
		}
		if(request.getParameter("act").equals("update")) {
			StudentUser studentuser = studentUserIfImpl.selectByPrimaryKey(Integer.parseInt(request.getParameter("id")));
			model.addAttribute("student", studentuser);
			return "admin/admin/user/updatestudentuser.jsp";
		}
		return null;
	}
	
	/**
	 * 	���ӣ��޸�ѧ���û�
	 * @param model
	 * @param adminuser
	 * @param result
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value="/operationstudentuser",method=RequestMethod.POST)
	public String operationstudentuser(Model model,@Valid @ModelAttribute("student") StudentUser studentuser,BindingResult result,
			HttpServletRequest request,RedirectAttributes attr) {
		if (result.hasErrors()){
			model.addAttribute("student", studentuser);
			return "admin/admin/user/addstudentuser.jsp";
		}
		if(request.getParameter("act").equals("insert")) {
			int back = optionStudentuser.insertadminuser(studentuser);
			if(back==1) {
				attr.addFlashAttribute("message", "��ӳɹ���");
				return "redirect:/admin/studentuser.shtml";
			}else {
				attr.addFlashAttribute("message", "���ʧ�ܣ����ٴ���ӣ�");
				return "redirect:/admin/studentuser.shtml";
			}
		}
		if(request.getParameter("act").equals("update")) {
			int back = optionStudentuser.updateadminuser(studentuser);
			if(back==1) {
				attr.addFlashAttribute("message", "�޸ĳɹ���");
				return "redirect:/admin/studentuser.shtml";
			}else {
				attr.addFlashAttribute("message", "�޸�ʧ�ܣ����ٴ��޸ģ�");
				return "redirect:/admin/studentuser.shtml";
			}
		}
		return null;
		
	}
	
	/**
	 * 
	 * ѧ�������Ϣ
	 * 
	 */
	@RequestMapping("studentmessage/{id}")
	public String studentmessage(Model model,@PathVariable(value="id") String id,ModelMap map) {
		List<DormitoryRoom> room;
		StudentPerson studentPerson = studentPersonIfImpl.selectonebyid(id);
		if(studentPerson == null) {
			room = dormitoryRoomIfImpl.selectroomAll(1);
		}else {
			if((Integer)studentPerson.getDormitory() == null) {
				room = dormitoryRoomIfImpl.selectroomAll(1);
			}else {
				room = dormitoryRoomIfImpl.selectroomAll(studentPerson.getDormitory());
			}
		}
		List<SchoolCollege> college = schoolCollegeIfImpl.selectAll();
		List<SchoolMajor> major = schoolMajorIfImpl.selectAll();
		List<SchoolMajorClass> majorclass = schoolMajorClassIfImpl.selectAll();
		List<Dormitory> dormitory = dormitoryIfImpl.selectAll();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		StudentPerson person = studentPersonIfImpl.selectonebyid(id);
		String dateString;
		if(person != null) {
			if(person.getBirthday()!=null) {
				dateString = formatter.format(person.getBirthday());
			}else {
				dateString = null;
			}
		}else {
			person = new StudentPerson();
			dateString = null;
		}
		model.addAttribute("person", person);
		model.addAttribute("birthday", dateString);
		model.addAttribute("colleges", college);
		model.addAttribute("majors", major);
		model.addAttribute("majorclasss", majorclass);
		model.addAttribute("dormitorys", dormitory);
		model.addAttribute("rooms", room);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/user/studentmessage.jsp";
		
	}
	
	/**
	 * 
	 * ѧ�������Ϣ�ϴ�
	 * @throws ParseException 
	 */
	@RequestMapping("studentupload")
	public String studentupload(StudentPerson studentPerson,Model model,RedirectAttributes attr,HttpServletRequest request) throws ParseException {
		StudentPerson StudentPerson = studentPersonIfImpl.selectonebyid(studentPerson.getStudentid());
		if(request.getParameter("date")!=null) {
			SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
			Date date = simpledate.parse(request.getParameter("date"));
			studentPerson.setBirthday(date);
		}
		if(StudentPerson != null) {	
			System.out.println(studentPerson.getHeadimg());
			int back = optionStudentuser.updatestudentuser(studentPerson);
			if(back == 1) {
				attr.addFlashAttribute("message", "�޸ĳɹ���");
				return "redirect:/admin/studentmessage/"+studentPerson.getStudentid()+".shtml";
			}else {
				attr.addFlashAttribute("message", "�޸�ʧ�ܣ��������޸�");
				return "redirect:/admin/studentmessage/"+studentPerson.getStudentid()+".shtml";
			}
		}else {
			int back = optionStudentuser.insertstudentuser(studentPerson);
			if(back == 1) {
				attr.addFlashAttribute("message", "�޸ĳɹ���");
				return "redirect:/admin/studentmessage/"+studentPerson.getStudentid()+".shtml";
			}else {
				attr.addFlashAttribute("message", "�޸�ʧ�ܣ��������޸�");
				return "redirect:/admin/studentmessage/"+studentPerson.getStudentid()+".shtml";
			}
		}
	}
	
	/**
	 * ������Ա�û��Ƿ����
	 * @param request
	 * @return
	 */
	@RequestMapping("checkadminuser")
	@ResponseBody
	public Map checkadminuser(HttpServletRequest request) {
		String name = request.getParameter("name");
		AdminUser adminuser = adminUserIfImpl.selectadminif(name);
		HashMap map = new HashMap();
		if(adminuser != null) {
			map.put("flag",1);
		}else {
			map.put("flag", 0);
		}
		return map;
	}
	
	/**
	 * ������Ա�û��Ƿ����
	 * @param request
	 * @return
	 */
	@RequestMapping("checkstudentuser")
	@ResponseBody
	public Map checkstudentuser(HttpServletRequest request) {
		String name = request.getParameter("name");
		StudentUser adminuser = studentUserIfImpl.selectadminif(name);
		HashMap map = new HashMap();
		if(adminuser != null) {
			map.put("flag",1);
		}else {
			map.put("flag", 0);
		}
		return map;
	}
	
	/**
	 * ��ѯרҵ
	 * @param request
	 * @return
	 */
	@RequestMapping("selectmajor")
	@ResponseBody
	public Map selectmajor(HttpServletRequest request) {
		int pid =  Integer.parseInt(request.getParameter("college"));
		List<SchoolMajor> majors =  schoolMajorIfImpl.selectByPid(pid);
		Map<Integer,SchoolMajor> map = new HashMap<>();
		for(SchoolMajor major:majors) {
			map.put(major.getId(), major);
		}
		return map;
	}
	
	/**
	 * ��ѯ�༶
	 * @param request
	 * @return
	 */
	@RequestMapping("selectmajorclass")
	@ResponseBody
	public Map selectmajorclass(HttpServletRequest request) {
		int pid =  Integer.parseInt(request.getParameter("major"));
		List<SchoolMajorClass> majorclass =  schoolMajorClassIfImpl.selectPid(pid);
		Map<Integer,SchoolMajorClass> map = new HashMap<>();
		for(SchoolMajorClass classs:majorclass) {
			map.put(classs.getId(), classs);
		}
		return map;
	}
	
	/**
	 * ��ѯ���᷿��
	 */
	@RequestMapping("selectroom")
	@ResponseBody
	public Map selectroom(HttpServletRequest request) {
		int pid =  Integer.parseInt(request.getParameter("domitory"));
		List<DormitoryRoom> rooms = dormitoryRoomIfImpl.selectroomAll(pid);
		Map<Integer,DormitoryRoom> map = new HashMap<>();
		for(DormitoryRoom room:rooms) {
			map.put(room.getId(), room);
		}
		return map;
	}
	
	/**
	 * �ϴ�ͷ��
	 * @throws IOException 
	 */
	@RequestMapping("uploadhead")
	@ResponseBody
	public Map uploadhead(HttpServletRequest request,@RequestParam("file") MultipartFile myfiles) throws IOException {
		Map<Integer,String> map = new HashMap<>();
		int i = 1;
		if(myfiles.isEmpty()){
			System.out.println("�ļ�δ�ϴ�");
		}else {
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/admin/headimg");
		String name = UUID.randomUUID().toString()+myfiles.getOriginalFilename().substring(myfiles.getOriginalFilename().lastIndexOf("."));
		FileUtils.copyInputStreamToFile(myfiles.getInputStream(), new File(realPath, name));
		map.put(i, "/resources/images/admin/headimg/"+name);
		}
		return map;
	}
}
