package com.hr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author q610q
 * @since 2023-10-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jobId;

    private String jobTitle;

    private Integer minSalary;

    private Integer maxSalary;

}
