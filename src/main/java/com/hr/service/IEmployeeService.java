package com.hr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hr.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hr.entity.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
public interface IEmployeeService extends IService<Employee> {
    // 定义查询员工信息方法
    String getEmployeeList(Employee employee);

    // 定义添加方法
    String addEmployee(Employee e);

    // 定义修改员工信息方法
    String updateEmployee(Employee e);

    // 定义删除员工信息方法
    String deleteEmployee(int id);

    // 获取员工信息表中数据的总个数
    int getEmployeeCount(QueryWrapper wrapper);

    // 根据分页查询数据
    List<Employee> getEmployeeListPage(PageInfo page);




}
