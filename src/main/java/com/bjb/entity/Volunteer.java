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
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {
	private Integer volunteerId;
    private Integer userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Integer serviceProvinceCode;
	private Integer serviceCityCode;
	private Integer serviceCountyCode;
	private String serviceProvinceName;
	private String serviceCityName;
	private String serviceCountyName;
	private String volunteerNo;
}
