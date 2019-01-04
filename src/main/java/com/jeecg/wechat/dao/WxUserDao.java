package com.jeecg.wechat.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.springframework.stereotype.Repository;

@Repository("wxUserDao")
public interface WxUserDao {

    /**
     * 插入数据 【SQL文件】
     *
     * @param wxUser 参数
     */
    void insert(@Param("w_x_user") Wxuser wxUser);

    void insertCode(@Param("wxuser") Wxuser wxUser);

    /**
     * @param wxOpenId
     * @return
     */
    @Sql("select * from w_x_user where openid = :wxOpenId")
    Wxuser getWxUserByWxOpenid(@Param("wxOpenId") String wxOpenId);

}
