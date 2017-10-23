package com.spring.controller;

import com.spring.dao.DepartmentDAO;
import com.spring.pojo.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

        DepartmentDAO deptDAO = (DepartmentDAO) context.getBean("departmentDAO");

        List<Department> depts = deptDAO.queryDepartment();

        for (Department dept : depts) {
            System.out.println("Dept ID " + dept.getDeptId()+" Dept No " + dept.getDeptNo()+" Dept Name " + dept.getDeptName());
        }
    }
}

