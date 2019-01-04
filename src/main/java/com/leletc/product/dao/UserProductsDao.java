package com.leletc.product.dao;

import com.leletc.product.entity.BaseUserProductsEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：用户产品服务DAO类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 00:23
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Repository
public interface UserProductsDao {

    /**
     * 根据用户ID获得用户产品列表
     *
     * @param userId 用户ID
     * @return
     */
    @Arguments({"userId"})
    @Sql("SELECT * FROM auto_base_user_products WHERE user_id = :userId")
    List<BaseUserProductsEntity> getListByUserId(String userId);

    /**
     * 根据用户ID和产品ID获得单个用户产品配置信息
     *
     * @param userId    用户ID
     * @param productId 产品ID
     * @return
     */
    @Arguments({"userId", "productId"})
    @Sql("SELECT * FROM auto_base_user_products WHERE user_id = :userId AND product_id = :productId")
    BaseUserProductsEntity getSingleUserProduct(String userId, String productId);

    /**
     * 更新用户产品次数
     *
     * @param userId 用户ID
     * @param num    次数
     */
    @Arguments({"userId", "num"})
    @Sql("UPDATE auto_base_user_products SET PRODUCT_LEFT_NUM = :num WHERE user_id : userId")
    void updateProductLeftNum(String userId, Integer num);

    /**
     * 更新用户产品次数
     *
     * @param userPersonLevel 用户等级
     * @param productId       产品ID
     * @param num             次数
     */
    @Arguments({"userPersonLevel", "productId", "num"})
    @Sql("UPDATE auto_base_user_products SET PRODUCT_LEFT_NUM = :num WHERE user_person_level = :userPersonLevel" +
            " AND product_id = :productId")
    void updateProductLeftNum(String userPersonLevel, String productId, Integer num);

}
