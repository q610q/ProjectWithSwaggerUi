package com.hr.mapper;

import com.hr.entity.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
public interface JobMapper extends BaseMapper<Job> {

    // 使用自定义SQL语句进行数据更新
    @Update("${sql}")
    public int myUpdateJob(@Param("sql") String sql);

    // 使用自定义SQL语句进行数据删除
    @Delete("${sql}")
    public int myDeleteJob(@Param("sql") String sql);

    // 使用自定义SQL语句进行数据查询
    @Select("${sql}")
    public Job mySelectJob(@Param("sql") String sql);

    // 使用传统的MyBatis在xml中映射SQL语句，需要先声明一个查询方法
    Job mybatisSelectJob(Map<String, Object> queryInfo);

    // 使用原生SQL查询多条记录
    @Select("${sql}")
    List<Job> mySelectListJob(@Param("sql") String sql);

    // 使用传统的MyBatis在xml中映射SQL语句查询多个记录，需要先声明一个查询方法
    List<Job> mybatisSelectListJob(Job queryInfo);

}
