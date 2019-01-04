package com.leletc.base.util;

import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：数据字典工具类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/08 09:53
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class DataDictUtils {

    private static final String TAG = DataDictUtils.class.getSimpleName();

    private static Logger logger = LoggerFactory.getLogger(DataDictUtils.class);

    public static int getProductNumByPersonLevel(String personLevel) {
        int number = 2;
        // 从数据库获取服务次数
        List<TSType> types = new ArrayList<>();
        switch (personLevel) {
            case LeletcConstants.PERSON_LEVEL_VISITOR_0:
                // 游客
                types = ResourceUtil.getCacheTypes("pro_tms_vi");
                break;
            case LeletcConstants.PERSON_LEVEL_GENERAL_1:
                // 普通用户
                types = ResourceUtil.getCacheTypes("pro_tms_ge");
                break;
            case LeletcConstants.PERSON_LEVEL_VIP_2:
                // 贵宾用户
                types = ResourceUtil.getCacheTypes("pro_tms_vp");
                break;
                default:
                    break;
        }
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
        }
        return number;
    }

}
