package com.leletc.user.service;

import com.leletc.user.api.response.UserRsp;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeewx.api.wxuser.user.model.Wxuser;

/**
 * 功能描述：用户注册业务接口(微信)
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/19 15:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IRegisterService extends CommonService {

    /**
     * 根据用户手机号注册，与微信信息绑定
     *
     * @param wxuser
     * @param telNum
     * @return
     * @throws Exception
     */
    ResponseMessage<UserRsp> registerUserByTel(Wxuser wxuser, String telNum) throws Exception;

}
