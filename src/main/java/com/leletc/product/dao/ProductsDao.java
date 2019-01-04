package com.leletc.product.dao;

import com.leletc.product.entity.BaseProductsEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：产品服务Dao
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 01:25
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
public interface ProductsDao {


    /**
     * 根据用户ID获得产品列表
     *
     * @param userId          用户ID
     * @param parentProductId 父级产品ID
     * @param productStatus   产品状态
     * @return List
     */
    @Arguments({"userId", "parentProductId", "productStatus"})
    List<BaseProductsEntity> getListByUserId(String userId, String parentProductId, String productStatus);

    /**
     * 根据用户ID获得父产品列表
     *
     * @param userId 用户ID
     * @return List
     */
    @Arguments({"userId"})
    @Sql("SELECT * FROM auto_base_products WHERE id IN (" +
            " SELECT product_id FROM auto_base_user_products up WHERE up.user_id = :userId)")
    List<BaseProductsEntity> getProductsByUserId(String userId);

    /**
     * 根据用户ID获得子产品列表
     *
     * @param userId 用户ID
     * @return List
     */
    @Arguments({"userId"})
    List<BaseProductsEntity> getChildListByUserId(String userId);

    /**
     * 查询所有数据
     *
     * @return List
     */
    @Sql("SELECT p.* FROM auto_base_products p")
    List<BaseProductsEntity> getList();

}
