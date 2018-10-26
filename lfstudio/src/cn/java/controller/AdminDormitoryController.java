package cn.java.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.java.entity.Dormitory;
import cn.java.entity.DormitoryRoom;
import cn.java.service.impl.DormitoryIfImpl;
import cn.java.service.impl.DormitoryRoomIfImpl;
import cn.java.utils.OptionDormitory;
import cn.java.utils.OptionDormitoryRoom;

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
	@RequestMapping("/dormitory")
	public String dormitory(Model model,ModelMap map) {
		List<Dormitory> dormitorylist = dormitoryIfImpl.selectAll();
		model.addAttribute("dormitorylist", dormitorylist);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/dormitorymanage.jsp";
	}
	
	@RequestMapping("/dormitoryroom")
	public String dormitoryroom(Model model,ModelMap map,HttpServletRequest request) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<DormitoryRoom> roomlist = dormitoryRoomIfImpl.selectroomAll(pid);
		Dormitory dormitory = dormitoryIfImpl.selectByPrimaryKey(pid);
		model.addAttribute("pid", pid);
		model.addAttribute("dormitory", dormitory);
		model.addAttribute("roomlist", roomlist);
		model.addAttribute("message", map.get("message"));
		return "admin/admin/dormitory/dormitoryroom.jsp";
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
}
