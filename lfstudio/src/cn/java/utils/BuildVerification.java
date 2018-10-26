package cn.java.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Component
public class BuildVerification {
	@Autowired
	private Producer captchaProducer  = null;
	
	public void setBuildVerification(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");
        
        String capText = captchaProducer.createText();  
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        } finally {  
            out.close();  
        }
	}
}
