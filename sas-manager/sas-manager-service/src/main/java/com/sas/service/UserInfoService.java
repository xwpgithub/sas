package com.sas.service;

import com.sas.pojo.UserInfo;
import com.sas.pojo.UserLoginInfo;
import com.sas.pojo.UserRole;

//管理员
public interface UserInfoService {
  int insert(UserInfo userInfo);//插入数据
}
