package com.leletc.user.dao;

import com.leletc.user.entity.UserVehicleEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：用户车辆信息Dao
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/16 00:55
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/16, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Repository
public interface UserVehicleDao {

    /**
     * 根据用户ID获得用户车辆信息集合
     *
     * @param userId 用户ID
     * @return List&lt;UserVehicleEntity&gt;
     * @author 李斌
     * @date 2018/12/16 00:56
     */
    @Arguments({"userId"})
    @Sql("SELECT * FROM auto_user_vehicle WHERE user_id = :userId")
    List<UserVehicleEntity> getByUserId(String userId);

    /**
     * 删除车辆
     *
     * @param userId 用户ID
     * @param carNum 车牌号
     * @return int
     */
    @Arguments({ "userId", "carNum" })
    @Sql("DELETE FROM auto_user_vehicle WHERE user_id = :userId AND car_num = :carNum")
    int delVehicle(String userId, String carNum);

}
