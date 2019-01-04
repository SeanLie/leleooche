package com.jeecg.wechat.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.springframework.stereotype.Repository;

import com.jeecg.wechat.dbtable.AutoBaseFile;

@Repository
public interface AutoBaseFileDao {

	/**
	 * 删除数据 【SQL文件】
	 * 
	 * @param autoBaseFile 参数
	 */
	@Arguments({ "autoBaseFile" })
	void delete1(AutoBaseFile autoBaseFile);

	/**
	 * 插入数据 【SQL文件】
	 * 
	 * @param autoBaseFile 参数
	 */
	@Arguments({ "autoBaseFile" })
	void insert(AutoBaseFile autoBaseFile);

}
