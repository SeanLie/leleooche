package com.jeecg.demo.service.impl;
import com.jeecg.demo.service.JformOrderMainServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.demo.entity.JformOrderMainEntity;
import com.jeecg.demo.page.JformOrderMainPage;
import com.jeecg.demo.entity.JformOrderCustomerEntity;
import com.jeecg.demo.entity.JformOrderTicketEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("jformOrderMainService")
@Transactional
public class JformOrderMainServiceImpl extends CommonServiceImpl implements JformOrderMainServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(JformOrderMainEntity entity) throws Exception{
 		super.delete(entity);
 	}
	
	public void addMain(JformOrderMainPage jformOrderMainPage) throws Exception {
		JformOrderMainEntity jformOrderMain = new JformOrderMainEntity();
		MyBeanUtils.copyBeanNotNull2Bean(jformOrderMainPage, jformOrderMain);
		//保存主信息
		this.save(jformOrderMain);
		/**保存-订单客户信息*/
		List<JformOrderCustomerEntity> jformOrderCustomerList = jformOrderMainPage.getJformOrderCustomerList();
		for(JformOrderCustomerEntity jformOrderCustomer:jformOrderCustomerList){
			//外键设置
			jformOrderCustomer.setFkId(jformOrderMain.getId());
			this.save(jformOrderCustomer);
		}
		/**保存-订单票务信息*/
		List<JformOrderTicketEntity> jformOrderTicketList = jformOrderMainPage.getJformOrderTicketList();
		for(JformOrderTicketEntity jformOrderTicket:jformOrderTicketList){
			//外键设置
			jformOrderTicket.setFckId(jformOrderMain.getId());
			this.save(jformOrderTicket);
		}
	}

	
	public void updateMain(JformOrderMainPage jformOrderMainPage) throws Exception{
		JformOrderMainEntity jformOrderMain = new JformOrderMainEntity();
		//保存主表信息
		if(StringUtil.isNotEmpty(jformOrderMainPage.getId())){
			jformOrderMain = findUniqueByProperty(JformOrderMainEntity.class, "id", jformOrderMainPage.getId());
			MyBeanUtils.copyBeanNotNull2Bean(jformOrderMainPage, jformOrderMain);
			this.saveOrUpdate(jformOrderMain);
		}else{
			this.saveOrUpdate(jformOrderMain);
		}
		//===================================================================================
		//获取参数
		Object id0 = jformOrderMain.getId();
		Object id1 = jformOrderMain.getId();
		//===================================================================================
		//1.订单客户信息数据库的数据
	    String hql0 = "from JformOrderCustomerEntity where 1 = 1 AND fkId = ? ";
	    List<JformOrderCustomerEntity> jformOrderCustomerOldList = this.findHql(hql0,id0);
		//2.订单客户信息新的数据
		List<JformOrderCustomerEntity> jformOrderCustomerList = jformOrderMainPage.getJformOrderCustomerList();
	    //3.筛选更新明细数据-订单客户信息
		if(jformOrderCustomerList!=null &&jformOrderCustomerList.size()>0){
			for(JformOrderCustomerEntity oldE:jformOrderCustomerOldList){
				boolean isUpdate = false;
				for(JformOrderCustomerEntity sendE:jformOrderCustomerList){
					//需要更新的明细数据-订单客户信息
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-订单客户信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//4.持久化新增的数据-订单客户信息
			for(JformOrderCustomerEntity jformOrderCustomer:jformOrderCustomerList){
				if(oConvertUtils.isEmpty(jformOrderCustomer.getId())){
					//外键设置
					jformOrderCustomer.setFkId(jformOrderMain.getId());
					this.save(jformOrderCustomer);
				}
			}
		}
		//===================================================================================
		//1.订单票务信息数据库的数据
	    String hql1 = "from JformOrderTicketEntity where 1 = 1 AND fckId = ? ";
	    List<JformOrderTicketEntity> jformOrderTicketOldList = this.findHql(hql1,id1);
		//2.订单票务信息新的数据
		List<JformOrderTicketEntity> jformOrderTicketList = jformOrderMainPage.getJformOrderTicketList();
	    //3.筛选更新明细数据-订单票务信息
		if(jformOrderTicketList!=null &&jformOrderTicketList.size()>0){
			for(JformOrderTicketEntity oldE:jformOrderTicketOldList){
				boolean isUpdate = false;
				for(JformOrderTicketEntity sendE:jformOrderTicketList){
					//需要更新的明细数据-订单票务信息
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-订单票务信息
		    		super.delete(oldE);
	    		}
	    		
			}
			//4.持久化新增的数据-订单票务信息
			for(JformOrderTicketEntity jformOrderTicket:jformOrderTicketList){
				if(oConvertUtils.isEmpty(jformOrderTicket.getId())){
					//外键设置
					jformOrderTicket.setFckId(jformOrderMain.getId());
					this.save(jformOrderTicket);
				}
			}
		}
	}

	public void delMain(JformOrderMainEntity jformOrderMain) throws Exception{
		//删除主表信息
		this.delete(jformOrderMain);
		//===================================================================================
		//获取参数
		Object id0 = jformOrderMain.getId();
		Object id1 = jformOrderMain.getId();
		//===================================================================================
		//删除-订单客户信息
	    String hql0 = "from JformOrderCustomerEntity where 1 = 1 AND fkId = ? ";
	    List<JformOrderCustomerEntity> jformOrderCustomerOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(jformOrderCustomerOldList);
		//===================================================================================
		//删除-订单票务信息
	    String hql1 = "from JformOrderTicketEntity where 1 = 1 AND fckId = ? ";
	    List<JformOrderTicketEntity> jformOrderTicketOldList = this.findHql(hql1,id1);
		this.deleteAllEntitie(jformOrderTicketOldList);
	}
 	
}