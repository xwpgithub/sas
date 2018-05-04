package com.sas.service;

import com.sas.pojo.UserLoginInfo;

//管理员
public interface TestService {
  UserLoginInfo findByloginname(String adminName);//管理员登录
}
