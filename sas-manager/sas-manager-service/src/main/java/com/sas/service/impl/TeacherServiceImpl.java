/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年4月14日 下午3:57:10 
* @version V1.0   
*/
package com.sas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sas.mapper.OrganizationDictionaryMapper;
import com.sas.mapper.TeacherMapper;
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.OrganizationDictionaryExample;
import com.sas.pojo.OrganizationDictionaryExample.Criteria;
import com.sas.pojo.Teacher;
import com.sas.pojo.TeacherExample;
import com.sas.service.OrganizationService;
import com.sas.service.TeacherService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Resource private TeacherMapper teacherMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.sas.service.TeacherService#selectAllTeacher() 
	*/
	@Override
	public List<Teacher> selectAllTeacher() {
		  TeacherExample example = new TeacherExample();
			List<Teacher> result = teacherMapper.selectByExample(example);
			if (result==null||result.size()==0) {
				return null;
			}
			return result;
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#insert(com.sas.pojo.Teacher) 
	*/
	@Override
	public int insert(Teacher teacher) {
		int result = teacherMapper.insert(teacher);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#delete(com.sas.pojo.Teacher) 
	*/
	@Override
	public int delete(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
