package cn.java.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.java.entity.Dormitory;
import cn.java.entity.DormitoryAbout;
import cn.java.entity.DormitoryRoom;
import cn.java.entity.JsonBean;
import cn.java.entity.SchoolCollege;
import cn.java.entity.SchoolMajor;
import cn.java.entity.SchoolMajorClass;
import cn.java.entity.StudentPerson;
import cn.java.service.impl.DormitoryAboutIfImpl;
import cn.java.service.impl.DormitoryIfImpl;
import cn.java.service.impl.DormitoryRoomIfImpl;
import cn.java.service.impl.DormitoryRoomManNumIfImpl;
import cn.java.service.impl.SchoolCollegeIfImpl;
import cn.java.service.impl.SchoolMajorClassIfImpl;
import cn.java.service.impl.SchoolMajorIfImpl;
import cn.java.service.impl.StudentPersonIfImpl;
import cn.java.utils.OptionDormitory;
import cn.java.utils.OptionDormitoryRoom;
import cn.java.utils.OptionStudentuser;
import cn.java.utils.OptionAbout;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminDormitoryController {
	
	@Autowired
	DormitoryIfImpl dormitoryIfImpl;
	@Autowired
	OptionDormitory optionDormitory;
	@Autowired
	DormitoryRoomIfImpl dormitoryRoomIfImpl;
	@Autowired
	OptionDormitoryRoom optionDormitoryRoom;
	@Autowired
	StudentPersonIfImpl studentPersonIfImpl;
	@Autowired
	SchoolMajorClassIfImpl schoolMajorClassIfImpl;
	@Autowired
	SchoolCollegeIfImpl schoolCollegeIfImpl;
	@Autowired
	SchoolMajorIfImpl schoolMajorIfImpl;
	@Autowired
	OptionStudentuser optionStudentuser;
	@Autowired
	DormitoryRoomManNumIfImpl dormitoryRoomManNumIfImpl;
	@Autowired
	DormitoryAboutIfImpl dormitoryAboutIfImpl;
	@Autowired
	OptionAbout OptionAbout;
	
	@RequestMapping("/dormitory")
	public String dormitory(Model model,ModelMap map) {
		List<Dormitory> dormitorylist = dormitoryIfImpl.selectAll();
		model.addAttribute("dormitorylist", dormitorylist);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/dormitorymanage.jsp";
	}
	
	/**
	 * 宿舍所有房间
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/dormitoryroom")
	public String dormitoryroom(Model model,ModelMap map,HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<DormitoryRoom> roomlist = dormitoryRoomIfImpl.selectroomAll(pid);
		List<Map<Object,Object>> rooms = dormitoryRoomIfImpl.selectroomAllnum(pid);
		Dormitory dormitory = dormitoryIfImpl.selectByPrimaryKey(pid);
		model.addAttribute("pid", pid);
		model.addAttribute("dormitory", dormitory);
		model.addAttribute("roomlist", roomlist);
		model.addAttribute("rooms", rooms);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/dormitoryroom.jsp";
	}
	
	/**
	 * 宿舍房间首页
	 */
	@RequestMapping("/dormitoryindex/{dormitory}/{room}")
	public String dormitoryindex(Model model,@PathVariable(value="dormitory") Integer dormitory,
			@PathVariable(value="room") Integer room,ModelMap mapmessage) {
		List<Double> ele = new ArrayList<>();
		List<Double> hty = new ArrayList<>();
		List<String> date = new ArrayList<>();
		Dormitory dormitorys = dormitoryIfImpl.selectByPrimaryKey(dormitory);
		DormitoryRoom dormitoryrooms = dormitoryRoomIfImpl.selectByPrimaryKey(room);
		List<StudentPerson> student = studentPersonIfImpl.selectroomAll(dormitory, room);
		PageHelper.startPage(1, 6);
		List<DormitoryAbout> dormitoryabouts = dormitoryAboutIfImpl.selecByPidtAll(room);
		Map<Integer,SchoolMajorClass> map = new HashMap<>();
		for(StudentPerson students:student) {
			SchoolMajorClass classs=   schoolMajorClassIfImpl.selectByPrimaryKey(students.getMajorclass());
			map.put(students.getMajorclass(), classs);
		}
		SimpleDateFormat simple = new SimpleDateFormat("MM");
		for(DormitoryAbout dormitoryabout:dormitoryabouts) {
			ele.add(dormitoryabout.getAmountelectric());
			hty.add(dormitoryabout.getHygiene());
			date.add(simple.format(dormitoryabout.getMonth())+"月");
		}
		model.addAttribute("ele", ele);
		model.addAttribute("hty", hty);
		model.addAttribute("date", date);
		model.addAttribute("dormitoryabout", dormitoryabouts);
		model.addAttribute("message", mapmessage.get("message"));
		model.addAttribute("majorclassmap", map);
		model.addAttribute("rooms", dormitoryrooms);
		model.addAttribute("dormitory", dormitorys);
		model.addAttribute("student", student);
		return "admin/admin/dormitory/dormitoryindex.jsp";
	}
	
	/**
	 * 宿舍个人信息
	 */
	@RequestMapping("/roomstudentmess/{dormitory}/{room}/{id}")
	public String roomstudentmess(Model model,@PathVariable(value="dormitory") Integer dormitory,
			@PathVariable(value="room") Integer room,@PathVariable(value="id") String id) {
		String college = null;
		String major = null;
		String majorclass = null;
		Dormitory dormitorys = dormitoryIfImpl.selectByPrimaryKey(dormitory);
		DormitoryRoom dormitoryrooms = dormitoryRoomIfImpl.selectByPrimaryKey(room);
		StudentPerson student = studentPersonIfImpl.selectonebyid(id);
		SchoolCollege colleges = schoolCollegeIfImpl.selectByPrimaryKey(student.getCollege());
		SchoolMajor majors = schoolMajorIfImpl.selectByPrimaryKey(student.getMajor());
		SchoolMajorClass majorclasss = schoolMajorClassIfImpl.selectByPrimaryKey(student.getMajorclass());
		college = colleges.getName();
		major = majors.getName();
		majorclass = majorclasss.getName();
		SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
		String date=null;
		if(student.getBirthday()!=null) {
			date = simple.format(student.getBirthday());
		}
		model.addAttribute("college", college);
		model.addAttribute("major", major);
		model.addAttribute("majorclass", majorclass);
		model.addAttribute("student", student);
		model.addAttribute("dormitorys", dormitorys);
		model.addAttribute("dormitoryrooms", dormitoryrooms);
		model.addAttribute("date", date);
		return "admin/admin/dormitory/roomstudentmessage.jsp";
		
	}
	
	/**
	 * 宿舍电费卫生表
	 * @param model
	 * @param dormitory
	 * @param room
	 * @return
	 */
	@RequestMapping("/roomelectric/{dormitory}/{room}")
	public String roomelectric(Model model,@PathVariable Integer dormitory,@PathVariable Integer room,
			HttpServletRequest request) {
		int pagenum = 10;
		List<DormitoryAbout> dormitoryabout;
		if(request.getParameter("pageid")==null) {
			PageHelper.startPage(1, pagenum);
			dormitoryabout = dormitoryAboutIfImpl.selectAllDesc(room);
		}else {
			int start = Integer.parseInt(request.getParameter("pageid"));			
			PageHelper.startPage(start, pagenum);
			dormitoryabout = dormitoryAboutIfImpl.selectAllDesc(room);
		}
		Dormitory dormitorys = dormitoryIfImpl.selectByPrimaryKey(dormitory);
		DormitoryRoom dormitoryrooms = dormitoryRoomIfImpl.selectByPrimaryKey(room);
		model.addAttribute("dormitorys", dormitorys);
		model.addAttribute("dormitoryrooms", dormitoryrooms);
		model.addAttribute("dormitoryabouts", dormitoryabout);
		model.addAttribute("pages", ((Page)dormitoryabout).getPages());
		model.addAttribute("nowpage", ((Page)dormitoryabout).getPageNum());
		model.addAttribute("countnum", ((Page)dormitoryabout).getTotal());
		model.addAttribute("url", request.getContextPath()+"/admin/roomelectric/"+dormitory+"/"+room+".shtml?q=q");
		return "admin/admin/dormitory/roomelectric.jsp";
	}
	
	/**
	 * 宿舍卫生首页
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping("/hygiene")
	public String hygieneindex(Model model,ModelMap map) {
		List<Dormitory> dormitorylist = dormitoryIfImpl.selectAll();
		model.addAttribute("dormitorylist", dormitorylist);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/hygiene.jsp";
	}
	
	/**
	 * 修改卫生页面
	 */
	@RequestMapping("/hygieneroom")
	public String hygieneroom(Model model,ModelMap map,String pid) {
		Integer dormitorypid = Integer.parseInt(pid); 
		Dormitory dormitory = dormitoryIfImpl.selectByPrimaryKey(dormitorypid);
		List<Object> rooms = dormitoryRoomIfImpl.selecthygiene(dormitorypid);
		model.addAttribute("rooms", rooms);
		model.addAttribute("dormitory", dormitory);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/hygieneroom.jsp";
	}
	
	/**
	 * 电费管理首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/addelectricindex")
	public String addelectricindex(Model model) {
		return "admin/admin/dormitory/addelectricindex.jsp";
	}
	
	/**
	 * 充值电费
	 * @return
	 */
	@RequestMapping("/addelectric")
	public String addelectric(Model model,ModelMap map) {
		List<Dormitory> dormitory = dormitoryIfImpl.selectAll();
		model.addAttribute("dormitorys", dormitory);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/addelectric.jsp";
	}
	
	/**
	 * 扣电费
	 * @return
	 */
	@RequestMapping("/reduceelectric")
	public String reduceelectric(Model model,ModelMap map) {
		List<Dormitory> dormitory = dormitoryIfImpl.selectAll();
		model.addAttribute("dormitorys", dormitory);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/reduceelectric.jsp";
	}
	
	@RequestMapping("/optiondormitory")
	public String optiondormitory(Model model,HttpServletRequest request,RedirectAttributes attr) throws UnsupportedEncodingException {
		if(request.getParameter("act").equals("insert")) {
			String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
			Dormitory dormitory = dormitoryIfImpl.selectdormitoryname(name);
			if(dormitory!=null) {
				attr.addFlashAttribute("message", "该宿舍已存在！");
				return "redirect:/admin/dormitory.shtml";
			}
			Dormitory record = new Dormitory();
			record.setName(name);
			int back = optionDormitory.insertdormitory(record);
			if(back==1) {
				attr.addFlashAttribute("message", "新增成功！");
				return "redirect:/admin/dormitory.shtml";
			}else {
				attr.addFlashAttribute("message", "新增失败！请重新增加");
				return "redirect:/admin/dormitory.shtml";
			}
		}
		if(request.getParameter("act").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<DormitoryRoom> room = dormitoryRoomIfImpl.selectroomAll(id);
			if(room.size()!=0) {
				attr.addFlashAttribute("message", "删除失败！该宿舍楼里有宿舍");
				return "redirect:/admin/dormitory.shtml";
			}
			int back = optionDormitory.deletedormitory(id);
			if(back==1) {
				attr.addFlashAttribute("message", "删除成功！");
				return "redirect:/admin/dormitory.shtml";
			}else {
				attr.addFlashAttribute("message", "删除失败！请重新删除");
				return "redirect:/admin/dormitory.shtml";
			}
		}
		return null;
	}
	@RequestMapping("/optiondormitoryroom")
	public String optiondormitoryroom(Model model,HttpServletRequest request,RedirectAttributes attr) throws UnsupportedEncodingException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		Dormitory dormitory = dormitoryIfImpl.selectByPrimaryKey(pid);
		if(request.getParameter("act").equals("insert")) {
			DormitoryRoom room = new DormitoryRoom();
			room.setPid(pid);
			model.addAttribute("dormitory", dormitory);
			model.addAttribute("room", room);
			return "admin/admin/dormitory/addroom.jsp";
		}
		if(request.getParameter("act").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<StudentPerson> student = studentPersonIfImpl.selectByroomnum(id);
			if(student.size() !=0 ) {
				attr.addFlashAttribute("message", "删除失败！该宿舍有学生");
				attr.addFlashAttribute("dormitory", dormitory);
				return "redirect:/admin/dormitoryroom.shtml?pid="+pid;
			}
			int back = optionDormitoryRoom.deleteroom(id);
			if(back==1) {
				attr.addFlashAttribute("message", "删除成功！");
				attr.addFlashAttribute("dormitory", dormitory);
				return "redirect:/admin/dormitoryroom.shtml?pid="+pid;
			}else {
				attr.addFlashAttribute("message", "删除失败！请重新删除");
				attr.addFlashAttribute("dormitory", dormitory);
				return "redirect:/admin/dormitoryroom.shtml?pid="+pid;
			}
		}
		return null;
	}
	
	/**
	 * 修改宿舍学生信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/actionroomstudent")
	public String actionroomstudent(HttpServletRequest request,RedirectAttributes attr) {
		if(request.getParameter("act").equals("delete")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer dormitory = Integer.parseInt(request.getParameter("dormitory"));
			Integer room = Integer.parseInt(request.getParameter("room"));
			StudentPerson student = studentPersonIfImpl.selectByPrimaryKey(id);
			student.setDormitory(0);
			student.setRoom(0);
			int back = optionStudentuser.updatestudentuser(student);
			if(back ==1 ) {
				dormitoryRoomManNumIfImpl.subnum(room);
				attr.addFlashAttribute("message", "移除成功！");
				return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
			}else {
				attr.addFlashAttribute("message", "移除失败！请重新移除");
				return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
			}
		}
		if(request.getParameter("act").equals("removeall")) {
			Integer dormitory = Integer.parseInt(request.getParameter("dormitory"));
			Integer room = Integer.parseInt(request.getParameter("room"));
			List<StudentPerson> list = studentPersonIfImpl.selectroomAll(dormitory, room);
			for(StudentPerson person:list) {
				person.setDormitory(0);
				person.setRoom(0);
			}
			int back = optionStudentuser.updatemoreroom(list,room);
			if(back == list.size() ) {
				attr.addFlashAttribute("message", "移除成功！");
				return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
			}else {
				attr.addFlashAttribute("message", "移除失败！请重新移除");
				return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
			}
		}
		if(request.getParameter("act").equals("insert")) {
			Integer dormitory = Integer.parseInt(request.getParameter("dormitory"));
			Integer room = Integer.parseInt(request.getParameter("room"));
			StudentPerson person = studentPersonIfImpl.selectonebyid(request.getParameter("studentid"));
			Integer oldroom = person.getRoom();
			if(person == null) {
				attr.addFlashAttribute("message", "添加失败！无此学号学生或未给学生添加相关信息");
				return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
			}else {
				person.setDormitory(dormitory);
				person.setRoom(room);
				int back = optionStudentuser.updatestudentuser(person);
				if(back == 1) {
					dormitoryRoomManNumIfImpl.addnum(room);
					dormitoryRoomManNumIfImpl.subnum(oldroom);
					attr.addFlashAttribute("message", "添加成功！");
					return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
				}else {
					attr.addFlashAttribute("message", "添加失败！请重新添加");
					return "redirect:/admin/dormitoryindex/"+dormitory+"/"+room+".shtml";
				}
			}
		}
		return null;
	}
	@RequestMapping("/actionroom")
	public String actionroom(@Valid @ModelAttribute("room") DormitoryRoom dormitoryRoom,BindingResult result,
			Model model,HttpServletRequest request,RedirectAttributes attr) {
			Dormitory dormitory = dormitoryIfImpl.selectByPrimaryKey(dormitoryRoom.getPid());
			if (result.hasErrors()){
				model.addAttribute("room", dormitoryRoom);
				model.addAttribute("dormitory", dormitory);
				return "admin/admin/dormitory/addroom.jsp";
			}
			DormitoryRoom one = dormitoryRoomIfImpl.selectroomname(dormitoryRoom.getName(),dormitoryRoom.getPid());
			if(one!=null) {
				model.addAttribute("room", dormitoryRoom);
				model.addAttribute("dormitory", dormitory);
				model.addAttribute("message", "该宿舍号已存在！");
				return "admin/admin/dormitory/addroom.jsp";
			}
			String act = request.getParameter("act");
			if(act.equals("insert")) {
				int back = optionDormitoryRoom.insertroom(dormitoryRoom);
				if(back==1) {
					attr.addFlashAttribute("message", "添加成功！");
					return "redirect:/admin/dormitoryroom.shtml?pid="+dormitoryRoom.getPid();
				}else {
					attr.addFlashAttribute("message", "添加失败！请重新添加");
					return "redirect:/admin/dormitoryroom.shtml"+dormitoryRoom.getPid();
				}
			}
		return null;
	}
	
	/**
	 * 操作电量
	 */
	@RequestMapping("/optionelectric")
	public String optionelectric(Model model,HttpServletRequest request,RedirectAttributes attr) {
		int room = Integer.parseInt(request.getParameter("room"));
		float money = Float.parseFloat(request.getParameter("money"));
		if(request.getParameter("act").equals("add")) {
			Float price = 0.6f;
			float electric = money/price;
			float newelectric = (float)(Math.round(electric*100))/100;
			int back = OptionAbout.updateele(room, newelectric);
			if(back==1) {
				attr.addFlashAttribute("message", "充值成功！");
				return "redirect:/admin/addelectric.shtml";
			}else {
				attr.addFlashAttribute("message", "充值失败！请重新充值");
				return "redirect:/admin/addelectric.shtml";
			}
		}
		if(request.getParameter("act").equals("reduce")) {
			int back = OptionAbout.reduceele(room, money);
			if(back==1) {
				attr.addFlashAttribute("message", "扣除成功！");
				return "redirect:/admin/addelectric.shtml";
			}else {
				attr.addFlashAttribute("message", "扣除失败！请重新扣除");
				return "redirect:/admin/addelectric.shtml";
			}
		}
		return null;
		
	}
	/**
	 * 修改宿舍分数
	 */
	@ResponseBody
	@RequestMapping("/xiugaifenshu")
	public Map xiugaifenshu(@RequestBody List<JsonBean> datas, HttpServletRequest request) {
		int back = dormitoryAboutIfImpl.updatehygiene(datas);
		Map<String,String> map = new HashMap<>();
		if(back==datas.size()) {
			map.put("flag", "true");
		}else {
			map.put("flag", "false");
		}
		return map;
	}
	
	/**
	 * 	设为舍长
	 */
	@ResponseBody
	@RequestMapping("/setroomgam")
	public Map setroomgam(@RequestBody DormitoryRoom dormitory) {
		System.out.println(dormitory);
		DormitoryRoom room = dormitoryRoomIfImpl.selectByPrimaryKey(dormitory.getId());
		room.setRoomgam(dormitory.getRoomgam());
		int back = optionDormitoryRoom.updateroomgam(room);
		Map<String,String> newmap = new HashMap<>();
		if(back == 1) {
			newmap.put("flag", "true");
		}else {
			newmap.put("flag", "false");
		}
		return newmap;
	}
}
