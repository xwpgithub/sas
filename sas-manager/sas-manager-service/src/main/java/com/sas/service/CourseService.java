package com.sas.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpRequest;

import com.github.pagehelper.PageInfo;
import com.sas.pojo.ClassRoom;
import com.sas.pojo.CourseAdmin;
import com.sas.pojo.Personnel;
import com.sas.pojo.Teacher;
import com.sun.tools.internal.ws.processor.model.Request;


public interface CourseService {
	PageInfo<CourseAdmin> selectAllClassRoom(Integer pageNum,Integer pageSize,ArrayList<Integer> oidList,Integer galleryful,String classroomaddress,String classroomname);//所有老师名称遍历
	int insert(ClassRoom classRoom);//添加
	int update(ClassRoom classRoom);//更新
	int delete(Integer classRoomid);//删除
	ClassRoom selectClassRoomById(int classRoomid);//根据id查找
}
