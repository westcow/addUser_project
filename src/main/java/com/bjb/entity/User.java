package com.bjb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userCode; //账号
    private String userName;
    private Integer roleId; //角色类型
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date creatDate;
    private String password;
    private String mobilePhone;
    private String identification; //身份证
    private Integer provinceCode;
	private Integer cityCode;
	private Integer countyCode;
	private String provinceName;
	private String cityName;
	private String countyName;
    private String gender;
    private Integer status; //状态
    private Integer auditStatus;
	private String idMd5; //身份证md5加密
	private Integer activeStatus;
	private Integer identity;
}
