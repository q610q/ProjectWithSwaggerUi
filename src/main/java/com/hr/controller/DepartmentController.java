package com.hr.controller;


import com.hr.entity.Department;
import com.hr.service.IDepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
@RestController
@RequestMapping("/hr/department")
public class DepartmentController {

    // 定义服务层的接口
    @Resource
    IDepartmentService departmentService;

    // 部门信息的添加
    @PostMapping
    public String addDepartment(@RequestParam int departmentId,@RequestParam String departmentName,@RequestParam(required = false) Integer managerId,@RequestParam(required = false) Integer locationId){

        Department addDepaartment = new Department(departmentId, departmentName, managerId, locationId);
        return departmentService.addDepartment(addDepaartment);
    }


}
