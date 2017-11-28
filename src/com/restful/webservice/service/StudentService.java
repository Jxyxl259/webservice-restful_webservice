package com.restful.webservice.service;


import com.google.gson.Gson;
import com.restful.webservice.entity.Student;

import javax.ws.rs.*;

public class StudentService {

    @POST
    @Path(value="/getStuInfo")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/xml")
    public Student getStudentInfo(@BeanParam Student stu){

        System.out.println("有访问请求进来了,请求参数为>>>>>>>>>>>>>"+stu);

        Student stuinfo = new Student();
        stuinfo.setName(stu.getName());
        stuinfo.setAge(stu.getAge());
        stuinfo.setGrade(stu.getGrade());
        stuinfo.setAdult(stu.isAdult());

        return stuinfo;
    }


    @GET
    @Path(value="/getStudentInfo/{stuName}")
    @Produces("application/json")
    public Student getName(@PathParam("stuName")String name){
        System.out.println("通过路径获取到的学生姓名参数为:"+name);
        Student stu = new Student();
        stu.setName(name);
        stu.setGrade("3");
        stu.setAdult(false);
        stu.setAge(5);
        return stu;
    }


    @POST
    @Path(value="/getPupilInfo")
    @Produces("application/json")
    public Student getpupilInfo(String pupilInfo){
        System.out.println(pupilInfo);
        Gson g = new Gson();
        Student stu = g.fromJson(pupilInfo, Student.class);
        return stu;

    }

}
