package com.leletc.user.api.request;

import com.leletc.base.api.request.ReqHead;
import org.jeewx.api.wxuser.user.model.Wxuser;

import java.io.Serializable;

/**
 * 功能描述：用户注册请求对象
 * <p>
 * @author 朱磊
 * <p>
 * @date 2018/11/14 19:35
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class RegisterReq extends ReqHead implements Serializable {

    /**
     * 个人微信信息
     */
    private Wxuser wxuser;

    private String telnum;

    private String checkCode;

    /**
     *
     */
    public RegisterReq() {
        super();
    }

    /**
     * @param wxuser
     * @param telnum
     * @param checkCode
     */
    public RegisterReq(Wxuser wxuser, String telnum, String checkCode) {
        super();
        this.wxuser = wxuser;
        this.telnum = telnum;
        this.checkCode = checkCode;
    }

    /**
     * @return the wxuser
     */
    public Wxuser getWxuser() {
        return wxuser;
    }

    /**
     * @param wxuser the wxuser to set
     */
    public void setWxuser(Wxuser wxuser) {
        this.wxuser = wxuser;
    }

    /**
     * @return the telnum
     */
    public String getTelnum() {
        return telnum;
    }

    /**
     * @param telnum the telnum to set
     */
    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    /**
     * @return the checkCode
     */
    public String getCheckCode() {
        return checkCode;
    }

    /**
     * @param checkCode the checkCode to set
     */
    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterReq [wxuser=" + wxuser + ", telnum=" + telnum + ", checkCode=" + checkCode + "]";
    }

}
