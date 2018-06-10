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

import com.sas.mapper.UserLoginInfoMapper;
import com.sas.mapper.UserRoleMapper;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserLoginInfoExample;
import com.sas.pojo.UserLoginInfoExample.Criteria;
import com.sas.pojo.UserRole;
import com.sas.service.TestService;
import com.sas.service.UserRoleService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2017年4月14日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource private UserRoleMapper userRoleMapper;

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param userRole
	* @return 
	* @see com.sas.service.UserRoleService#insert(com.sas.pojo.UserRole) 
	*/
	@Override
	public int insert(UserRole userRole) {
		
		return userRoleMapper.insert(userRole);
	}
	
	
	

}
