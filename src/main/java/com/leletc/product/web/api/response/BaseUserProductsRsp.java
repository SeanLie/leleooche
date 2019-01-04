package com.leletc.product.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.product.web.bo.UserProductsBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.web.system.pojo.base.TSUser;

import java.util.List;

/**
 * 功能描述：用户服务产品响应类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 21:05
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "baseUserProductsRsp", description = "用户服务产品响应对象")
public class BaseUserProductsRsp extends RspHead {

    @ApiModelProperty(value = "用户对象", required = true, name = "user", example = "{}")
    TSUser user;

    List<UserProductsBO> userProductsBOList;

    public TSUser getUser() {
        return user;
    }

    public void setUser(TSUser user) {
        this.user = user;
    }

    public List<UserProductsBO> getUserProductsBOList() {
        return userProductsBOList;
    }

    public void setUserProductsBOList(List<UserProductsBO> userProductsBOList) {
        this.userProductsBOList = userProductsBOList;
    }
}
