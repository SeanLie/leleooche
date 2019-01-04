package com.leletc.base.timer;

import com.leletc.base.util.LeletcConstants;
import com.leletc.product.dao.ProductsDao;
import com.leletc.product.dao.UserProductsDao;
import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.service.IBaseUserProductsService;
import com.leletc.reservecfg.service.IReserveUserCfgService;
import org.jeecgframework.core.common.dao.impl.CommonDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 功能描述：重置用户产品服务次数
 * <p>
 * 在每个月的第一天进行重置
 * </p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/20 15:13
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("resetProductServiceTimesScheduler")
public class ResetProductServiceTimesScheduler implements Job {

    private static final String TAG = ResetProductServiceTimesScheduler.class.getSimpleName();

    private static Logger logger = LoggerFactory.getLogger(ResetProductServiceTimesScheduler.class);

    @Autowired
    private CommonDao commonDao;

    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private UserProductsDao userProductsDao;

    @Autowired
    private IReserveUserCfgService reserveUserCfgService;

    @Autowired
    private IBaseUserProductsService baseUserProductsService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        resetServiceTimes();
    }

    /**
     * 每个月的第一天的1点59分执行
     */
    //@Scheduled(cron="0 59 1 1 * ?")
    private void resetServiceTimes() {
        logger.info(TAG + "{}", "每月第一天执行所有用户产品服务次数------------start");
        int number = 2;
        // 查询所有产品
        final List<BaseProductsEntity> products = productsDao.getList();
        if (!CollectionUtils.isEmpty(products)) {
            for (BaseProductsEntity product : products) {
                // 游客
                Map<String, Integer> productNumMap = reserveUserCfgService.getProductNum(
                        LeletcConstants.PERSON_LEVEL_VISITOR_0, product.getId());
                updateProductLeftNum(LeletcConstants.PERSON_LEVEL_VISITOR_0, product, productNumMap);
                // 普通用户
                productNumMap = reserveUserCfgService.getProductNum(
                        LeletcConstants.PERSON_LEVEL_GENERAL_1, product.getId());
                updateProductLeftNum(LeletcConstants.PERSON_LEVEL_GENERAL_1, product, productNumMap);
                // 贵宾用户
                productNumMap = reserveUserCfgService.getProductNum(
                        LeletcConstants.PERSON_LEVEL_VIP_2, product.getId());
                updateProductLeftNum(LeletcConstants.PERSON_LEVEL_VIP_2, product, productNumMap);
            }
        }
        // 从数据库获取服务次数
        /*final List<TSType> types = ResourceUtil.getCacheTypes("pro_times");
        if (!CollectionUtils.isEmpty(types)) {
            for (TSType type : types) {
                if (type.getTypecode().equals("defTimes")) {
                    try {
                        number = Integer.parseInt(type.getTypename());
                        logger.info(TAG + "{}{}", "从数据库获取服务次数 - defTimes=", number);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        logger.error(TAG + "{}", "从数据库获取服务次数失败");
                    }
                }
            }
        }*/
        logger.info(TAG + "{}", "每月第一天执行所有用户产品服务次数------------end");
    }

    private void updateProductLeftNum(String userPersonLevel, BaseProductsEntity product, Map<String, Integer> productNumMap) {
        if (!CollectionUtils.isEmpty(productNumMap)) {
            /*final Integer productNum = productNumMap.get("product_num");
            // 创建用户产品对象
            BaseUserProductsEntity userProductsEntity;
            userProductsEntity = new BaseUserProductsEntity();
            userProductsEntity.setProductId(product.getId());
            userProductsEntity.setProductLeftNum(productNum);
            userProductsEntity.setUpdateBy("自动任务");
            userProductsEntity.setUpdateDate(new Date());
            userProductsEntity.setUpdateName("自动任务");*/
            baseUserProductsService.updateProductLeftNum(userPersonLevel, product.getId(), productNumMap.get("product_num"));
        }
    }

}
