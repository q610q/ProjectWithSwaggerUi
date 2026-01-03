package com.hr.controller;


import com.hr.entity.Job;
import com.hr.service.IJobService;
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
@RestController
@RequestMapping("/hr/job")
public class JobController {

    // 定义服务层的连接接口
    @Resource
    IJobService jobService;

    @PutMapping
    public String updateJobById(@RequestParam String jobId, @RequestParam String jobTitle, @RequestParam int minSalary, @RequestParam int maxSalary){

        Job update_info = new Job(jobId, jobTitle, minSalary, maxSalary);
        return jobService.updateJobById(update_info);

    }

    @PutMapping("/my")
    public String myUpdateJob(@RequestParam String jobId, @RequestParam String jobTitle, @RequestParam int minSalary, @RequestParam int maxSalary){
        Job update_info = new Job(jobId, jobTitle, minSalary, maxSalary);
        return jobService.myUpdateJob(update_info);

    }


    @DeleteMapping
    public String deleteById(@RequestParam String jobId){
        return jobService.deleteUser(Integer.parseInt(jobId));
    }


    @GetMapping("/{jobId}")
    public String getOneJob(@PathVariable String jobId){
        Job queryInfo = new Job();
        queryInfo.setJobId(jobId);
        return jobService.selectOneJob(queryInfo);
    }

    @GetMapping
    public String getJobList(@RequestBody Job job){
        return jobService.selectListJob(job);
    }



}
