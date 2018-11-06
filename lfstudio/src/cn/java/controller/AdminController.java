package cn.java.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.code.kaptcha.Constants;
import cn.java.entity.AdminUser;
import cn.java.service.impl.AdminUserIfImpl;
import cn.java.utils.BuildVerification;
import cn.java.utils.CheckVerificationCode;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminController {
	@Autowired 
	AdminUserIfImpl adminUserIfImpl;
	@Autowired
	BuildVerification verification;
	/**
	 * ��֤������
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/VerificationCode")
	public ModelAndView getCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		verification.setBuildVerification(request, response);
        return null; 
	}
	
	/**
	 * ����Ա��¼����
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(AdminUser user,ModelMap map,HttpServletRequest request,Model model) {
		if(map.get("admin")!=null) {
			model.addAttribute("admin",map.get("admin"));
		}else {
			model.addAttribute("admin",user);
		}
		if(map.get("loginfail")!=null) {
			model.addAttribute("loginfail",map.get("loginfail"));
		}else {
			model.addAttribute("loginfail","");
		}
		return "admin/login/login.jsp";
	}
	/**
	 * ��¼��֤
	 * @param adminuser
	 * @param model
	 * @param attr
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String logincheck(AdminUser adminuser,Model model,RedirectAttributes attr,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		CheckVerificationCode checkcode = new CheckVerificationCode();
		boolean flag = checkcode.check(code,request.getParameter("Verification-Code"));
		if(!flag) {
			attr.addFlashAttribute("admin", adminuser);
			attr.addFlashAttribute("message","��֤�벻��ȷ��");
			return "redirect:/admin/login.shtml";
		}
		AdminUser back = adminUserIfImpl.selectByUserPass(adminuser);
		if(back==null) {
			attr.addFlashAttribute("admin", adminuser);
			attr.addFlashAttribute("message","�û��������벻��ȷ��");
			return "redirect:/admin/login.shtml"; 
		}else {
			session.setAttribute("user", adminuser.getAdminuser());
			attr.addFlashAttribute("message","��¼�ɹ���");
			return "redirect:/admin/index.shtml";
		}
	}
	
	/**
	 * ��̨��ҳ
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String adminindex(@ModelAttribute("message") String message,Model model,HttpServletRequest request) {
		request.getSession().getAttribute("user");
		model.addAttribute("message",message);
		model.addAttribute("user",request.getSession().getAttribute("user"));
		return "/admin/admin/index.jsp";	
	}
	
	/**
	 * 	ע����¼
	 */
	@RequestMapping("/signout")
	public String signout(HttpServletRequest request,RedirectAttributes attr) {
		request.getSession().removeAttribute("user");
		attr.addFlashAttribute("message", "�˳��ɹ���");
		return "redirect:/admin/login.shtml";
	}
	
}
