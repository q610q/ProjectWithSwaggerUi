package com.hr.service.impl;

import com.alibaba.fastjson.JSON;
import com.hr.entity.Admininfo;
import com.hr.entity.Employee;
import com.hr.mapper.AdmininfoMapper;
import com.hr.mapper.EmployeeMapper;
import com.hr.service.IAdmininfoService;
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
public class AdmininfoServiceImpl extends ServiceImpl<AdmininfoMapper, Admininfo> implements IAdmininfoService {

}
