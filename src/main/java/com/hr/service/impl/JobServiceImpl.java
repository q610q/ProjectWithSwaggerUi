package com.hr.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hr.entity.Job;
import com.hr.mapper.JobMapper;
import com.hr.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.ArrayList;
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
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

    @Resource
    JobMapper jobMapper;

    @Override
    public String updateJobById(Job updateinfo) {
        UpdateWrapper wrapper = new UpdateWrapper<>();
        wrapper.eq("jobId", updateinfo.getJobId());
        int res = jobMapper.update(updateinfo, wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "修改成功");
        result.put("data", res);
        return JSON.toJSONString(result);
    }

    @Override
    public String myUpdateJob(Job updateinfo) {
        String sql = "UPDATE job set jobTitle =  '" + updateinfo.getJobTitle() + "' , minSalary = " + updateinfo.getMinSalary() + " , maxSalary = " + updateinfo.getMaxSalary()
                + " where jobId = '" + updateinfo.getJobId() + "'";

        int res = jobMapper.myUpdateJob(sql);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "修改成功");
        result.put("data", res);
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteUser(int jobId) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("jobId", jobId);
        int res = jobMapper.delete(updateWrapper);
        Map<String, Object> result = new HashMap<>();

        result.put("code", 200);
        result.put("msg", "删除成功");
        result.put("data", res);
        return JSON.toJSONString(result);




    }

    @Override
    public String selectOneJob(Job queryInfo) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("jobId", queryInfo.getJobId());
        // 1.在服务层实现类中直接使用getOne()
        Job job1 = getOne(wrapper);
        // 2. 使用数据库连接层接口
        Job job2 = jobMapper.selectOne(wrapper);
        // 3. 使用原生的SQL语句
        String sql = "select jobId, jobTitle, minSalary, maxSalary from job where jobId = '" + queryInfo.getJobId() + "'";
        Job job3 = jobMapper.mySelectJob(sql);
        // 4. 使用传统的MyBatis在xml文件中定义sql语句
        Map<String, Object> queryInfoMap = new HashMap<>();
        queryInfoMap.put("jobId",queryInfo.getJobId() );
        Job job4 = jobMapper.mybatisSelectJob(queryInfoMap);
        ////////////////////////////////////////////////////
        List<Job> resultList = new ArrayList<>();
        resultList.add(job1);
        resultList.add(job2);
        resultList.add(job3);
        resultList.add(job4);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("mag", "查询成功");
        result.put("data", resultList);

        return JSON.toJSONString(result);

    }

    @Override
    public String selectListJob(Job queryInfo) {
        QueryWrapper wrapper = new QueryWrapper();
        if(queryInfo.getMinSalary() != null)
            wrapper.eq("minSalary",queryInfo.getMinSalary());
        if(queryInfo.getMaxSalary() != null)
            wrapper.eq("maxSalary",queryInfo.getMaxSalary());
        //-----------------------------------------------------------
        // 1. 在服务层中直接使用list方法
        List<Job> jobList1 = list(wrapper);
        // 2. 使用BaseMapper中提供的selectList方法
        List<Job> jobList2 = jobMapper.selectList(wrapper);
        // 3. 使用原生SQL语句查询多条记录
        String sql = "select jobId, jobTitle, minSalary, maxSalary from job" ;
        if(queryInfo.getMinSalary() != null && queryInfo.getMaxSalary() == null)
            sql = sql + " where minSalary = " + queryInfo.getMinSalary();
        if(queryInfo.getMinSalary() == null && queryInfo.getMaxSalary() != null)
            sql = sql + " where maxSalary = " + queryInfo.getMaxSalary();
        if(queryInfo.getMinSalary() != null && queryInfo.getMaxSalary() != null)
            sql = sql + " where maxSalary = " + queryInfo.getMaxSalary() + " and minSalary = " + queryInfo.getMinSalary();
        List<Job> jobList3 = jobMapper.mySelectListJob(sql);
        // 4. 使用传统的MyBatis在xml中自定义映射的SQL语句
        List<Job> jobList4 = jobMapper.mybatisSelectListJob(queryInfo);
        ////////////////////
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("mag", "查询成功");
        result.put("data1", jobList1);
        result.put("data2", jobList2);
        result.put("data3", jobList3);
        result.put("data4", jobList4);

        return JSON.toJSONString(result);

    }
}
