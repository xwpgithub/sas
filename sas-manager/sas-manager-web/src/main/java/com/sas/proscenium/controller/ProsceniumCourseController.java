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
import com.sas.pojo.ClassRoom;
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;
import com.sas.service.ClassRoomService;
import com.sas.service.CourseAdminService;
import com.sas.service.OrganizationService;
import com.sas.service.PersonnelService;
import com.sas.service.TeacherService;
import com.sas.service.UserInfoService;
import com.sas.service.UserLoginInfoService;
import com.sas.service.UserRoleService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/prosceniumCourseController")
public class ProsceniumCourseController  {

	@Resource
	private CourseAdminService courseAdminService;
	 /**
	  * list转json
	  * */
	public <T> String listToJson(List<T> t) {
		JSONArray sjArray = JSONArray.fromObject(t);
		String str = sjArray.toString();
		return str;
	}

		/**
		 * 
		* @Title: selectAllcourse 
		* @Description: TODO(教室点击开课返回可以开的课程) 
		* @param @param organizationid
		* @param @param request
		* @param @return    入参
		* @return String    返回类型
		* @author xieweipeng
		* @throws
		* @date 2018年6月12日 下午8:18:37 
		* @version V1.0
		 */
		@ResponseBody
		@RequestMapping(value = "/selectByOid", produces = "text/html;charset=UTF-8")
		public String selectAllcourse(Integer organizationid,HttpServletRequest request ) {
					
			List<CourseAdmin> list = courseAdminService.selectAllCourseAdminByOid(organizationid);								
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
