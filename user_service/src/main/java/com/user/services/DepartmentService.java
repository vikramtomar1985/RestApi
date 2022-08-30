package com.user.services;

import java.util.List;

import com.user.entity.Department;

public interface DepartmentService {

    //save Department
    Department saveDept(Department dept);

    //Read Dept
    List<Department> fetchDept();

    //update department
    Department updateDept(Department dept, Long id);

    void deleteDeptById(Long deptId);

    
}
