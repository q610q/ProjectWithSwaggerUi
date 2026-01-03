package com.hr.service;

import com.hr.entity.Job;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
public interface IJobService extends IService<Job> {

    // 基于ID更新JOB表中记录的方法
    String updateJobById(Job updateinfo);

    String myUpdateJob(Job updateinfo);

    // 基于条件构造器删除数据
    String deleteUser(int jobId);

    // 查询单挑记录
    String selectOneJob(Job queryInfo);

    // 查询多条记录
    String selectListJob(Job queryInfo);



}
