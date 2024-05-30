package com.eden.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OperateLog {	
	
	private Integer id;
	private Integer operateUser;
	private LocalDateTime operateTime;
	private String className;
	private String methodName;
	private String methodParams;
	private String returnValue;
	private Long costTime;
	
	public OperateLog(Integer id, Integer operateUser, LocalDateTime operateTime, String className, String methodName,
			String methodParams, String returnValue, Long costTime) {
		super();
		this.id = id;
		this.operateUser = operateUser;
		this.operateTime = operateTime;
		this.className = className;
		this.methodName = methodName;
		this.methodParams = methodParams;
		this.returnValue = returnValue;
		this.costTime = costTime;
	}	
	
	
}
