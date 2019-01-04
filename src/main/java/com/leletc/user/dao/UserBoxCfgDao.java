package com.leletc.user.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

/**
 * 功能描述：用户格口配置DAO接口
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/20 08:15
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/20, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Repository
public interface UserBoxCfgDao {

    /**
     * 获得所有配置的格口数
     *
     * @param userPersonLevel 用户等级
     * @return int 格口数
     */
    /*@Sql("SELECT SUM(user_box_counts) FROM auto_user_box_cfg WHERE user_person_level = :userPersonLevel")
    int getUserBoxTotal(String userPersonLevel);*/

    /**
     * 获得用户可用格口数
     *
     * @param userPersonLevel 用户等级
     * @return int
     */
    @Arguments({"userPersonLevel"})
    @Sql("SELECT user_box_counts FROM auto_user_box_cfg WHERE user_person_level = :userPersonLevel")
    int getUserBoxCounts(String userPersonLevel);

    /**
     * 减少用户可用格口数
     *
     * @param userPersonLevel 用户等级
     * @return int
     */
    @Arguments({"userPersonLevel"})
    @Sql("UPDATE auto_user_box_cfg set user_box_counts = user_box_counts - 1 WHERE user_person_level = :userPersonLevel")
    int reduceUserBoxCounts(String userPersonLevel);

    /**
     * 增加用户可用格口数
     *
     * @param userPersonLevel 用户等级
     * @return int
     */
    @Arguments({"userPersonLevel"})
    @Sql("UPDATE auto_user_box_cfg set user_box_counts = user_box_counts + 1 WHERE user_person_level = :userPersonLevel")
    int addUserBoxCounts(String userPersonLevel);

}
