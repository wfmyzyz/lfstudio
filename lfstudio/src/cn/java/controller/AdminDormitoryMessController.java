package cn.java.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.java.entity.DormitorNotice;
import cn.java.entity.DormitoryDdmintext;
import cn.java.entity.StudentUser;
import cn.java.service.impl.DormitoryAdmintextIfImpl;
import cn.java.service.impl.DormitoryNoticeIfImpl;
import cn.java.utils.OptionDormitoryText;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminDormitoryMessController {
	@Autowired
	OptionDormitoryText optionDormitoryText;
	@Autowired
	DormitoryNoticeIfImpl dormitoryNoticeIfImpl;
	@Autowired
	DormitoryAdmintextIfImpl dormitoryAdmintextIfImpl;
	
	/**
	 * 	公告首页
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/dormitortmess")
	public String dormitortmess(Model model,ModelMap map) {
		PageHelper.startPage(1, 5);
		List<DormitorNotice> dormitorNotice = dormitoryNoticeIfImpl.selectAll();
		model.addAttribute("message", map.get("message"));
		model.addAttribute("dormitorNotices", dormitorNotice);
		model.addAttribute("firstNotice", dormitorNotice.get(0));
		return "admin/admin/dormitorymessage/announcements.jsp";
	}
	
	/**
	 * 	上传公告
	 * @param model
	 * @param request
	 * @param attr
	 * @return
	 */
	@RequestMapping(value="/dormitortuploadmess",method=RequestMethod.POST)
	public String dormitortuploadmess(Model model,HttpServletRequest request,RedirectAttributes attr) {
		String text = request.getParameter("text");
		String texthtml = request.getParameter("texthtml");
		DormitorNotice dormitorNotice = new DormitorNotice();
		dormitorNotice.setText(text);
		dormitorNotice.setTexthtml(texthtml);
		SimpleDateFormat parret = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date = new Date();
		dormitorNotice.setDate(parret.format(date));
		int back = optionDormitoryText.insertnotice(dormitorNotice);
		if(back == 1) {
			attr.addFlashAttribute("message", "发布成功！");
			return "redirect:/admin/dormitortmess.shtml";
		}else {
			attr.addFlashAttribute("message", "发布失败！请重新发布");
			return "redirect:/admin/dormitortmess.shtml";
		}
	}
	
	/**
	 * 	删除公告
	 */
	@RequestMapping("/deletenotice")
	public String deletenotice(HttpServletRequest request,RedirectAttributes attr) {
		int id = Integer.parseInt(request.getParameter("id"));
		int back = optionDormitoryText.deletenotice(id);
		if(back == 1) {
			attr.addFlashAttribute("message", "删除成功！");
			return "redirect:/admin/noticelist.shtml";
		}else {
			attr.addFlashAttribute("message", "删除失败！请重新删除");
			return "redirect:/admin/noticelist.shtml";
		}
	}
	
	/**
	 * 	公告
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dormitortnotice")
	public String dormitortnotice(Model model,HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DormitorNotice dormitoryNotice = dormitoryNoticeIfImpl.selectByPrimaryKey(id);
		model.addAttribute("dormitoryNotice", dormitoryNotice);
		return "admin/admin/dormitorymessage/onenotice.jsp";
	}
	
	/**
	 * 	公告列表
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/noticelist")
	public String noticelist(Model model,ModelMap map,HttpServletRequest request) {
		List<DormitorNotice> noticelist;
		int pagenum = 10;
		if(request.getParameter("pageid")==null) {
			PageHelper.startPage(1, pagenum);
			noticelist = dormitoryNoticeIfImpl.selectAll();
		}else {
			int start = Integer.parseInt(request.getParameter("pageid"));
			PageHelper.startPage(start, pagenum); 
			noticelist = dormitoryNoticeIfImpl.selectAll();
		}
		model.addAttribute("noticelists", noticelist);
		model.addAttribute("pages", ((Page)noticelist).getPages());
		model.addAttribute("nowpage", ((Page)noticelist).getPageNum());
		model.addAttribute("countnum", ((Page)noticelist).getTotal());
		model.addAttribute("message", map.get("message"));
		model.addAttribute("url", request.getContextPath()+"/admin/noticelist.shtml?q=q");
		return "admin/admin/dormitorymessage/noticelist.jsp";
	}
	
	/**
	 *	 文章管理列表
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="dormitorytestlist")
	public String dormitorytestlist(Model model,ModelMap map,HttpServletRequest request) throws UnsupportedEncodingException {
		if(request.getParameter("act")!=null) {
			String name =new String(request.getParameter("title").getBytes("ISO8859-1"),"UTF-8");
			List<DormitoryDdmintext> textlist;
			int pagenum = 10;
			if(request.getParameter("pageid")==null) {
				PageHelper.startPage(1, pagenum);
				textlist = dormitoryAdmintextIfImpl.selectByTitleAll("%"+name+"%");
			}else {
				int start = Integer.parseInt(request.getParameter("pageid"));
				PageHelper.startPage(start, pagenum); 
				textlist = dormitoryAdmintextIfImpl.selectByTitleAll("%"+name+"%");
			}
			model.addAttribute("textlists", textlist);
			model.addAttribute("pages", ((Page)textlist).getPages());
			model.addAttribute("nowpage", ((Page)textlist).getPageNum());
			model.addAttribute("countnum", ((Page)textlist).getTotal());
			model.addAttribute("message", map.get("message"));
			model.addAttribute("url", request.getContextPath()+"/admin/dormitorytestlist.shtml?act=select&title="+name);
			return "admin/admin/dormitorymessage/testlist.jsp";
		}else {
			List<DormitoryDdmintext> textlist;
			int pagenum = 10;
			if(request.getParameter("pageid")==null) {
				PageHelper.startPage(1, pagenum);
				textlist = dormitoryAdmintextIfImpl.selectAll();
			}else {
				int start = Integer.parseInt(request.getParameter("pageid"));
				PageHelper.startPage(start, pagenum); 
				textlist = dormitoryAdmintextIfImpl.selectAll();
			}
			model.addAttribute("textlists", textlist);
			model.addAttribute("pages", ((Page)textlist).getPages());
			model.addAttribute("nowpage", ((Page)textlist).getPageNum());
			model.addAttribute("countnum", ((Page)textlist).getTotal());
			model.addAttribute("message", map.get("message"));
			model.addAttribute("url", request.getContextPath()+"/admin/dormitorytestlist.shtml?q=q");
			return "admin/admin/dormitorymessage/testlist.jsp";
		}
	}
	
	/**
	 * 	预览文章
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/viewtext")
	public String noticelist(Model model,HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DormitoryDdmintext text = dormitoryAdmintextIfImpl.selectByPrimaryKey(id);
		model.addAttribute("text", text);
		return "admin/admin/dormitorymessage/viewtext.jsp";
	}
	
	/**
	 *	 添加文章
	 * @return
	 */
	@RequestMapping(value="addtext")
	public String addtestlist(HttpServletRequest request,ModelMap modelmap,Model model) {
		model.addAttribute("message", modelmap.get("message"));
		return "admin/admin/dormitorymessage/addtext.jsp";
	}
	
	/**
	 * 	修改文章
	 */
	@RequestMapping("/updatetext")
	public String updatetext(HttpServletRequest request,ModelMap modelmap,Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		DormitoryDdmintext text = dormitoryAdmintextIfImpl.selectByPrimaryKey(id);
		model.addAttribute("text", text);
		model.addAttribute("message", modelmap.get("message"));
		return "admin/admin/dormitorymessage/updatetext.jsp";
	}
	
	/**
	 * 	文章上传,修改，删除
	 */
	@RequestMapping(value="uploadtext")
	public String uploadtext(Model model,HttpServletRequest request,RedirectAttributes attr) {
		if(request.getParameter("act").equals("update")) {
			int id = Integer.parseInt(request.getParameter("textid"));
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			DormitoryDdmintext dormitorytext = dormitoryAdmintextIfImpl.selectByPrimaryKey(id);
			dormitorytext.setTitle(title);
			dormitorytext.setText(text);
			int back = optionDormitoryText.updatetext(dormitorytext);
			if(back==1) {
				attr.addFlashAttribute("message", "修改成功！");
				return "redirect:/admin/updatetext.shtml?id="+id;
			}else {
				attr.addFlashAttribute("message", "修改失败！请重新修改");
				return "redirect:/admin/updatetext.shtml?id="+id;
			}
		}
		if(request.getParameter("act").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int back = optionDormitoryText.deletetext(id);
			if(back==1) {
				attr.addFlashAttribute("message", "删除成功！");
				return "redirect:/admin/dormitorytestlist.shtml";
			}else {
				attr.addFlashAttribute("message", "删除失败！请重新删除");
				return "redirect:/admin/dormitorytestlist.shtml";
			}
		}
		if(request.getParameter("act").equals("insert")){
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			DormitoryDdmintext record = new DormitoryDdmintext();
			record.setTitle(title);
			record.setText(text);
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			record.setDate(simple.format(date));
			int back = optionDormitoryText.inserttext(record);
			if(back==1) {
				attr.addFlashAttribute("message", "发布成功！");
				return "redirect:/admin/addtext.shtml";
			}else {
				attr.addFlashAttribute("message", "发布失败！请重新发布");
				return "redirect:/admin/addtext.shtml";
			}
		}
		return null;
	}
	
	/**
	 * 	文章上传图片
	 * @throws IOException 
	 */
	@RequestMapping(value="textuploadimg")
	@ResponseBody
	public Map textuploadimg(HttpServletRequest request,@RequestParam("fileimg") MultipartFile[] files) throws IOException {
		
		Integer errno = 0;
        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList<>();
        if (files.length == 0) {
            errno = 1;
        }
        for(MultipartFile file:files) {
        	String realPath = request.getSession().getServletContext().getRealPath("/resources/images/admin/textimg");
    		String name = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, name));
    		list.add(request.getContextPath()+"/resources/images/admin/textimg/"+name);
        }
        map.put("data", list);
		map.put("errno", errno);
		return map;
	}
}
