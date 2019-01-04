package com.jeecg.wechat.service;

import java.util.List;

import com.jeecg.wechat.page.KeyWordPage;

/*@Service
@Transactional*/
public interface IKeyWordAppServiceI {
	/**
	 * 查询关键字
	 * 
	 * @param list
	 * @return
	 */
	List<KeyWordPage> getKeyWords(List<String> list);

}
