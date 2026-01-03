package com.hr.controller;


import com.alibaba.fastjson.JSON;
import com.hr.entity.Employee;
import com.hr.entity.PageInfo;
import com.hr.service.IEmployeeService;
import com.hr.util.PageUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
@CrossOrigin
@RestController
@RequestMapping("/hr/employee")
@Api(value="EmployeeController相关的api",tags = {"员工信息的控制层"})
public class EmployeeController {


    @Resource
    IEmployeeService employeeService;

    // 查询
    @GetMapping
    public String getEmployee(int pageIndex,int pageSize){
        int count = employeeService.getEmployeeCount(null);
        PageInfo page = PageUtil.getPage(pageSize, count, pageIndex);

        // 调用服务层进行数据查询
        return JSON.toJSONString(employeeService.getEmployeeListPage(page));

    }
    // 添加数据

    @PostMapping
    public String insertEmployee(@RequestBody  Employee employee){
        // 调用服务层进行数据添加
        return employeeService.addEmployee(employee);

    }
    
    
    // 修改数据
    @PutMapping
    public String updateEmployee(@RequestBody  Employee employee){
        // 调用服务层进行数据修改
        return employeeService.updateEmployee(employee);
    }
    
    
    // 删除数据
    @GetMapping("/{id}")
    public String delEmployee(@PathVariable int id){
        // 调用服务层进行数据删除
        return employeeService.deleteEmployee(id);

    }
}
