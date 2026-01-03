package com.hr.service.impl;

import com.alibaba.fastjson.JSON;
import com.hr.entity.Department;
import com.hr.mapper.DepartmentMapper;
import com.hr.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    // 定义数据库连接层的接口
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public String addDepartment(Department department) {
        int res = departmentMapper.insert(department);

        Map<String , Object> result = new HashMap<>();

        if (res > 0){ // 添加成功
            result.put("code", 200);
            result.put("msg", "添加成功");
            result.put("res", res);
        } else { // 添加失败
            result.put("code", 201);
            result.put("msg", "添加失败");
            result.put("res", res);
        }

        return JSON.toJSONString(result);

    }

    @Override
    public String updateDepartment(Department department) {
        return null;
    }

    @Override
    public String delDepartment(int departmentId) {
        return null;
    }

    @Override
    public String getOneDepartmentInfo(Department department) {
        return null;
    }

    @Override
    public String getListDepartmentInfo(Department department) {
        return null;
    }
}
