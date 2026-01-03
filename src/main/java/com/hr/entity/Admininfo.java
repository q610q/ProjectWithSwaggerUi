package com.hr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

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
public class Admininfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adminId", type = IdType.AUTO)
    private Integer adminId;

    private String adminName;

    private String password;

    private String note;

}
