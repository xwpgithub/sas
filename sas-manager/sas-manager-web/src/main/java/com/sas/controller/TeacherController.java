package com.sas.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.Teacher;
import com.sas.pojo.UserLoginInfo;
import com.sas.service.OrganizationService;
import com.sas.service.TeacherService;
import com.sas.util.CommonMethod;

@Controller
@RequestMapping("/teacherController")
public class TeacherController  {

	@Resource
	private OrganizationService organizationService;
	@Resource
	private TeacherService teacherService;

	
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
		/** 查询模糊查询所有员工
		 * */
		@ResponseBody
		@RequestMapping(value = "/selectAllTeacher", produces = "text/html;charset=UTF-8")
		public String selectAllStaff(int[] departmentids) {
			System.out.println("进入方法"+departmentids);
			List<Teacher> lidytList = teacherService.selectAllTeacher();
			String teachers = JSON.toJSONStringWithDateFormat(lidytList, "yyyy-MM-dd");
			   		//return listToJson(lidytList);
			return teachers;
		}
		
		/**新增员工
		 * */
			@ResponseBody
			@RequestMapping(value = "/insertTeacher", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
			public int insertTeacher(Teacher teacher,String entrytimes, MultipartFile file_img)
					throws Exception {				
		        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式  
		        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");  
		        try {  
		            //使用SimpleDateFormat的parse()方法生成Date  
		            Date date = sf.parse(entrytimes);  
		            teacher.setEntrytime(date);
		             
		        } catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
				if (file_img.getSize() > 0) {
					teacher.setImage(CommonMethod.saveFile(file_img, "headImg/"));
				}
				
				System.out.println("进入老师控制器方法"+teacher.getTeachername());
				System.out.println(teacher.getOrganizationid());
				System.out.println(entrytimes);
				int result = teacherService.insert(teacher);
				return result;
			}
	

	
}
