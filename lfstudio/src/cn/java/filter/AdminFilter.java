package cn.java.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AdminFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String[] notFilter = new String[] { "/lfstudio/admin/login.shtml","/lfstudio/admin/VerificationCode.shtml"};
		String uri = request.getRequestURI();
		boolean flag = true;
		
		for(String s:notFilter) {
			if (s.equals(uri)) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8"); 
			response.setCharacterEncoding("utf-8");
			if(request.getSession().getAttribute("user")==null) {
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\">");
				builder.append("alert('ÇëÏÈµÇÂ¼£¡');");
				builder.append("window.top.location.href='");
				builder.append(request.getContextPath()+"/admin/login.shtml");
				builder.append("';");
				builder.append("</script>");
				out.print(builder);
				//filterChain.doFilter(request, response);
			}else {
				filterChain.doFilter(request, response);
			}
		}else {
			filterChain.doFilter(request, response);
		}
	}

}
