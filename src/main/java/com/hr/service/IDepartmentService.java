package com.hr.service;

import com.hr.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
public interface IDepartmentService extends IService<Department> {

    // 添加部门信息
    String addDepartment(Department department);

    // 修改部门信息
    String updateDepartment(Department department);


    // 删除部门信息
    String delDepartment(int departmentId);


    // 查询部门信息
    // 1. 查询单个的部门信息
    String getOneDepartmentInfo(Department department);


    // 2. 查询多个部门信息
    String getListDepartmentInfo(Department department);


    // 3. 查询所有部门信息（分页查询）

}
