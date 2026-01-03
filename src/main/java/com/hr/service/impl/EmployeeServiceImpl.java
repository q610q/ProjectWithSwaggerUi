package com.hr.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hr.entity.Employee;
import com.hr.entity.PageInfo;
import com.hr.mapper.EmployeeMapper;
import com.hr.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public String getEmployeeList(Employee employee) {
        QueryWrapper wrapper = new QueryWrapper();
        // 创建条件构造器
        if (employee != null && employee.getId() != null){
            wrapper.eq("id", employee.getId());
        }
        if(employee != null && employee.getJobId() != null){
            wrapper.eq("jobId", employee.getJobId());
        }
        if(employee != null && employee.getName() != null){
            wrapper.eq("name", employee.getName());
        }


        // 调用数据库连接层，进行数据查询
        List<Employee> emList = employeeMapper.selectList(wrapper);

        // 定义返回结果集
        Map<String , Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "查询成功");
        result.put("data",emList );
        return JSON.toJSONString(result);
    }

    @Override
    public String addEmployee(Employee e) {
        // 调用数据库连接层完成数据添加
        int result = employeeMapper.insert(e);
        Map<String, Object> res = new HashMap<>();
        if(result > 0){
            res.put("code", 200);
            res.put("msg", "success");
            res.put("data", result);
        } else {
            res.put("code", 201);
            res.put("msg", "error");
            res.put("data", null);
        }
        return JSON.toJSONString(res);


    }

    @Override
    public String updateEmployee(Employee e) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", e.getId());
        int res = employeeMapper.update(e, wrapper);
        Map<String, Object> result = new HashMap<>();
        if(res > 0){
            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", res);
        } else {
            result.put("code", 201);
            result.put("msg", "error");
            result.put("data", null);
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteEmployee(int id) {
        UpdateWrapper wapper = new UpdateWrapper();
        wapper.eq("id" , id);

        int res = employeeMapper.delete(wapper);

        Map<String, Object> result = new HashMap<>();
        if(res > 0){
            result.put("code", 200);
            result.put("msg", "success");
            result.put("data", res);
        } else {
            result.put("code", 201);
            result.put("msg", "error");
            result.put("data", null);
        }

        return JSON.toJSONString(result);

    }

    @Override
    public int getEmployeeCount(QueryWrapper wrapper) {
        long num = count(wrapper);
        return (int)num;
    }

    @Override
    public List<Employee> getEmployeeListPage(PageInfo page) {
        String sql = " select * from employee limit " + page.getBeginRow() + ", " + page.getPageSize() + " ";
        List<Employee> emList = employeeMapper.getEmployeeByMySQL(sql);
        return emList;
    }
}
