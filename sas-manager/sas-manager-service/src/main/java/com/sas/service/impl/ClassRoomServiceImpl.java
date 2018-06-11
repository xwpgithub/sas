/**   
* @Title: AdminServiceImpl.java 
* @Package com.appointment.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author tangliang 
* @date 2017年4月14日 下午3:57:10 
* @version V1.0   
*/
package com.sas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sas.mapper.ClassRoomMapper;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.ClassRoomExample;
import com.sas.pojo.ClassRoomExample.Criteria;
import com.sas.service.ClassRoomService;
import com.sas.service.PersonnelService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
	
	@Resource private ClassRoomMapper classRoomMapper;


	

	/* (非 Javadoc) 
	* <p>Title: selectAllTeacher</p> 
	* <p>Description: </p> 
	* @return 
	* 
	*/
	@Override
	public PageInfo<ClassRoom> selectAllClassRoom(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer galleryful,String classroomaddress,String classroomname ) {
						
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 5 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		ClassRoomExample example = new ClassRoomExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrganizationidIn(oidList);
		for (int i = 0; i < oidList.size(); i++) {
			System.out.println("查询personen的oid有"+oidList);
		}
		if (galleryful!=null) {
			criteria.andGalleryfulEqualTo(galleryful);
		}
		if (classroomaddress ==null || classroomaddress.isEmpty()) {
			
		}
		else{
			criteria.andClassroomaddressLike("%"+classroomaddress+"%");
		}
		if (classroomname ==null || classroomname.isEmpty()) {
			
		}
		else {
			criteria.andClassroomnameLike("%"+classroomname+"%");
		}
		
		
		List<ClassRoom> list = classRoomMapper.selectByExample(example);
		PageInfo<ClassRoom> pageInfo = new PageInfo<>(list, 5);
		if (list==null||list.size()==0) {
			System.out.println("空值返回");
			return pageInfo;
		}
		System.out.println("pageinfo返回");
		return pageInfo;
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#insert(com.sas.pojo.Teacher) 
	*/
	@Override
	public int insert(ClassRoom classRoom) {
			
		
		return classRoomMapper.insert(classRoom);
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#update(com.sas.pojo.Teacher) 
	*/
	@Override
	public int update(ClassRoom classRoom) {
		int result = classRoomMapper.updateByPrimaryKeySelective(classRoom);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param teacher
	* @return 
	* @see com.sas.service.TeacherService#delete(com.sas.pojo.Teacher) 
	*/
	@Override
	public int delete(Integer classroomid) {		
		return classRoomMapper.deleteByPrimaryKey(classroomid);
	}

	/* (非 Javadoc) 
	* <p>Title: selectTeacherById</p> 
	* <p>Description: </p> 
	* @param teacherId
	* @return 
	* @see com.sas.service.TeacherService#selectTeacherById(int) 
	*/
	@Override
	public ClassRoom selectClassRoomById(int classroomid) {
		
		return classRoomMapper.selectByPrimaryKey(classroomid);
	}
	
	
	

}
