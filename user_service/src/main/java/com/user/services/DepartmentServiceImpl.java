package com.user.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Department;
import com.user.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDept(Department dept) {
        if(Objects.nonNull(departmentRepository))
            return departmentRepository.save(dept);
        else
            return null;
    }

    @Override
    public List<Department> fetchDept() {
        
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDept(Department dept, Long id) {

        Department deptDb = departmentRepository.findById(id).get();

        if(Objects.nonNull(dept.getDepartmentName()) && !"".equalsIgnoreCase(dept.getDepartmentName())){
            deptDb.setDepartmentName(dept.getDepartmentName());
        }

        if(Objects.nonNull(dept.getDepartmentAddress()) && !"".equalsIgnoreCase(dept.getDepartmentAddress())){
            deptDb.setDepartmentAddress(dept.getDepartmentAddress());
        }
        if(Objects.nonNull(dept.getDepartmentCode()) && !"".equalsIgnoreCase(dept.getDepartmentCode())){
            deptDb.setDepartmentCode(dept.getDepartmentCode());
        }

        
        return departmentRepository.save(deptDb);
    }

    @Override
    public void deleteDeptById(Long deptId) {
        departmentRepository.deleteById(deptId);
        
    }
    
}
