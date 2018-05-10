package com.sas.service;

import java.util.List;

import com.sas.pojo.Teacher;


public interface TeacherService {
	List<Teacher> selectAllTeacher();//所有老师名称遍历
	int insert(Teacher teacher);//添加老师
	int update(Teacher teacher);//更新老师
	int delete(Teacher teacher);//删除老师
}
