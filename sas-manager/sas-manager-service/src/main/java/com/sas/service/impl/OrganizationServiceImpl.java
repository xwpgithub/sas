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
import com.sas.pojo.OrganizationDictionary;
import com.sas.pojo.OrganizationDictionaryExample;
import com.sas.pojo.OrganizationDictionaryExample.Criteria;
import com.sas.service.OrganizationService;


/** 
 * @ClassName: AdminServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xieweipeng
 * @date 2018年4月24日 下午3:57:10 
 * @version V1.0 
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Resource private OrganizationDictionaryMapper organizationDictionaryMapper;

	/* (非 Javadoc) 
	* <p>Title: selectAll</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.sas.service.OrganizationService#selectAll() 
	*/
	@Override
	public List<OrganizationDictionary> selectAll() {
		    OrganizationDictionaryExample example = new OrganizationDictionaryExample();
			List<OrganizationDictionary> result = organizationDictionaryMapper.selectByExample(example);
			if (result==null||result.size()==0) {
				return null;
			}
			return result;
	}

	/* (非 Javadoc) 
	* <p>Title: insert</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#insert(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int insert(OrganizationDictionary organizationDictionary) {
		int result = organizationDictionaryMapper.insert(organizationDictionary);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: update</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#update(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int update(OrganizationDictionary organizationDictionary) {
		int result = organizationDictionaryMapper.updateByPrimaryKey(organizationDictionary);
		return result;
	}

	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param organizationDictionary
	* @return 
	* @see com.sas.service.OrganizationService#delete(com.sas.pojo.OrganizationDictionary) 
	*/
	@Override
	public int delete(OrganizationDictionary organizationDictionary) {
		int result = organizationDictionaryMapper.deleteByPrimaryKey(organizationDictionary.getOrganizationid());
		OrganizationDictionaryExample example = new OrganizationDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(organizationDictionary.getOrganizationid());
		int result2 = organizationDictionaryMapper.deleteByExample(example);
		return result*result2;
	}
	
	
	

}
