package com.jeecg.wechat.service;

import java.util.List;
import java.util.Map;

import com.jeecg.wechat.page.LoggerPage;

public interface ILoggerApp {

	/**
	 * 日志实体
	 * 
	 * @param dto
	 * @return
	 */
	int addLogger(LoggerPage dto);

	/**
	 * 日志分页查询
	 * 
	 * @param dto      日志实体
	 * @param pageNum  页数
	 * @param pageSize 条数
	 * @return
	 */
	List<LoggerPage> qryLogger(LoggerPage dto, int pageNum, int pageSize);

	/**
	 * 删除日志
	 * 
	 * @param dtoes
	 * @return
	 */
	Map<String, Object> delLogger(List<LoggerPage> dtoes);

}
