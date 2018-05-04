package com.sas.service;

import java.util.List;

import com.sas.pojo.OrganizationDictionary;


public interface OrganizationService {
	List<OrganizationDictionary> selectAll();//所有机构名称遍历
}
