package com.hr.entity;

import lombok.*;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String name;

    private String idCard;

    private String email;

    private String phone;

    private String hiredate;

    private Float salary;

    private String jobId;

    private Integer departmentId;


}
