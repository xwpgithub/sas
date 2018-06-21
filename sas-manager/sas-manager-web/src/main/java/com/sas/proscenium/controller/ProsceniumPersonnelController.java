package com.sas.proscenium.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.UserInfoMapper;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/prosceniumPersonnelController")
public class ProsceniumPersonnelController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private PersonnelService personnelService;
	@Resource
	private UserRoleService userRoleService;
	@Resource
	private UserLoginInfoService userLoginInfoService;
	@Resource
	private UserInfoService userInfoService;
	/** 员工管理 **/
	@RequestMapping("/selectStaff")
	public String redirect() {
		return "/renshiguanli/renyuanluru/staff";
	}
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

	/** 获取部门 绑定ztree
	  * */
		@ResponseBody
		@RequestMapping(value = "/selectDepartment", produces = "text/html;charset=UTF-8")
		public String selectDepartment(HttpServletRequest request) {
			UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("user");
			System.out.println(userLoginInfo.getOrganizationid()+"号组织管理员进入系统------------------");
			String str = null;
			if (userLoginInfo.getOrganizationid()==0) {
				List<OrganizationDictionary> departments = organizationService.selectAll();
				 str = listToJson(departments);
			}
			else {
				List<OrganizationDictionary> departments = organizationService.selectAllByOId(userLoginInfo.getOrganizationid());
				 str = listToJson(departments);
			}
			
			return str;
		}
		//获取所有学生信息
			@ResponseBody
			@RequestMapping(value = "/selectAllStudent", produces = "text/html;charset=UTF-8")
			public String selectAllstudent(Integer organizationid,Integer roleid) {
				System.out.println("进入方法"+organizationid);
				ArrayList<Integer> oidList = new ArrayList<Integer>();
				if (organizationid==null) {
					System.out.println("查询的时候没有选oid默认为最大机构");
					
					organizationid=0;
				}
				if (organizationid==0) {
					List<OrganizationDictionary> departments = organizationService.selectAll();
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}
				else {
					List<OrganizationDictionary> departments = organizationService.selectAllByOId(organizationid);
					for (int i = 0; i < departments.size(); i++) {
						oidList.add(departments.get(i).getOrganizationid());
					}
				}			
				
				List<Personnel> list = personnelService.selectAllStudent(oidList, roleid);
				HashMap<String, Object> map = new HashMap<String, Object>();
				String data  = null;
				if (list==null) {
					map.put("code", 404);
					map.put("msg", "获取失败");
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}else {
					map.put("code", 200);
					map.put("msg", "获取成功");
					map.put("data", list);
					data = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
				}
			
			return data;
			}
}
