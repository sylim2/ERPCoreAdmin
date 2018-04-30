package com.corestone.login.controller;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.corestone.login.service.LoginService;
import com.corestone.login.service.LoginServiceImpl;
import com.corestone.members.model.MembersVO;



@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Resource(name="loginServiceImpl")
	private LoginServiceImpl loginServiceImpl;
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	MembersVO membersVO;

	@RequestMapping(value = "/login.do")
	@ResponseBody
	public int login(String id, String pw, HttpServletRequest request){
		HttpSession session = request.getSession();
		HashMap<String, String> map = new HashMap<String, String>();
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		map.put("userId", id);
		map.put("userPassword", pw);

		int loginIdentify = 0;
		
		try { 
			loginIdentify = loginServiceImpl.loginCheck(map);
		} catch(Exception e) { }
		
		if (loginIdentify == 1) {
			log.info("로그인 성공");
			//session.setAttribute("id", id);
			//session.setAttribute("pw", pw);
			session.setAttribute("admin", map);

		}
		else {
			log.info("로그인 실패");
		}

		System.out.println(loginIdentify);
		System.out.println(id);
		System.out.println(pw);
		return loginIdentify;

	}

	
	@RequestMapping(value="/main.do")
	public String main() {
		return "main/main";
	}
	/*@ResponseBody
	public ModelAndView home(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("id");
		
		if(userId == null) {
			mv.setViewName("login/loginpage");
			return mv;
		}
		
		mv.setViewName("main/main");
		
		return mv;
	}*/
}

