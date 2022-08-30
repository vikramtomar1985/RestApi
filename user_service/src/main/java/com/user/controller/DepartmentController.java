package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Department;
import com.user.response.ResponseHandler;
import com.user.services.DepartmentService;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    

    // save operations
    /**
     * @param dept
     * @return
     */
    @PostMapping("/department")
    public ResponseEntity<Object> saveDepartment( @RequestBody Department dept){
        try {
            Department result = departmentService.saveDept(dept);
            //System.out.println(result.getDepartmentId());
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    // Get List of dept
    /**
     * @return
     */
    @GetMapping("/departments")
    List<Department> fetchDepartments(){
        return departmentService.fetchDept();
    }

    //update Operations
    /**
     * @param dept
     * @param id
     * @return
     */
    @PutMapping("/department/{id}")
    public Department updateDept(@RequestBody Department dept,@PathVariable("id") Long id){
        return departmentService.updateDept(dept, id);

    }

    // Delete dept
    @DeleteMapping("/department/{id}")
    void deleteDept(@PathVariable("id") Long id){
        departmentService.deleteDeptById(id);
    }
    
}
