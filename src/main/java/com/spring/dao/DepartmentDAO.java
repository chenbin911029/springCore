package com.spring.dao;

import com.spring.pojo.Department;

import java.util.List;

public interface DepartmentDAO {
    public List<Department> queryDepartment() throws Exception ;
}
