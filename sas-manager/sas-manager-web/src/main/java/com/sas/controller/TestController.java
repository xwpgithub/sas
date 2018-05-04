package com.sas.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sas.pojo.UserLoginInfo;
import com.sas.service.TestService;

/**
 * @ClassName: AdminController
 * @Description: TODO(管理员的功能控制器)
 * @author xieweipeng
 * @date 2017年4月15日 上午9:49:28
 * @version V1.0
 */

@Controller
public class TestController {

	@Resource
	private TestService testService;

	/**
	 * @Title: adminLogin
	 * @Description: TODO(管理员登录)
	 * @param @param request
	 * @param @param admin
	 * @param @param modelAndView
	 * @param @return 入参
	 * @return ModelAndView 返回类型
	 * @author xieweipeng
	 * @throws
	 * @date 2018年4月15日 上午9:55:11
	 * @version V1.0
	 */
	/*@RequestMapping(value = "admin/login")
	public ModelAndView adminLogin(String username, String password,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		TbAdmin admin = adminService.findAdminByloginname(username);
		if (admin != null && admin.getPassword().equals(password)) {
			TbNetinfo netInfo2 = netInfoService.netInfo();
			request.getSession().setAttribute("netinfo", netInfo2);
			request.getSession().setAttribute("user", admin);
			request.getSession().setAttribute("type", "admin");
			TbAdmin admin2 = new TbAdmin();// 新建一个对象，便于更新时间
			admin2.setId(admin.getId());
			adminService.updateAdmin(admin2);// 更新上次登录时间
			modelAndView.setViewName("admin/adminindex");
			System.out.println(admin.getName() + "管理员，欢迎你");
			return modelAndView;
		} else {
			TbAdmin admin2 = new TbAdmin();// 新建一个对象，便于更新时间
			admin2.setId(admin.getId());
			adminService.updateAdmin(admin2);// 更新上次登录时间
			modelAndView.addObject("text_erro", "账户错误或者密码错误");
			System.out.println("管理员账户错误或者密码错误");
			modelAndView.setViewName("admin/adminlogin");
			return modelAndView;
		}*/
	@RequestMapping(value = "login")
	public String adminLogin(String username,HttpServletRequest request) {
		
		UserLoginInfo userLoginInfo = testService.findByloginname(username);
		
		if(userLoginInfo!=null){
			 request.getSession().setAttribute("user", userLoginInfo);
			 System.out.println(userLoginInfo.getLoginname()+"----"+userLoginInfo.getLoginpassword());
			 return "/login_main/main"; 
		 }else{
			 request.setAttribute("tishi", "用户名或密码错误");
			 System.out.println("查无此人");
			 return "/login_main/login";
		 }
	}

	
}
