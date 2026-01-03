package com.hr.mapper;

import com.hr.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    // 用传统的MyBatis查询员工信息
    List<Employee> getEmployeeInfo(Employee employee);

    // 使用自定义SQL语句查询
    @Select("${sql}")
    List<Employee> getEmployeeByMySQL(@Param("sql") String sql);


}
