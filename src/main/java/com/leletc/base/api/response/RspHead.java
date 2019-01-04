package com.leletc.base.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：响应对象类
 * <p>
 * rspcode-返回代码
 * erroe-错误内容
 * msg-返回内容
 * channel:all-全平台；wx-微信；app-app；web-PC网页；wap-wap网页（可选）
 * cid-用于防止 api 调用端重试造成服务端的重复推送而定义的一个标识符（可选）
 * s-安全措施（可选）
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/14 19:39
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "rspHead", description = "响应体Header")
public abstract class RspHead {

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "响应代码(0:成功,-1:失败)", name = "rspcode", required = true, example = "0")
    private String rspcode;

    /**
     * 错误内容
     */
    @ApiModelProperty(value = "错误内容(respcode=-1时才显示)", name = "error")
    private String error;

    /**
     * 返回频道：all-全平台；wx-微信；app-app；web-PC网页；wap-wap网页（可选）
     */
    @ApiModelProperty(value = "返回频道：all-全平台；wx-微信；app-app；web-PC网页；wap-wap网页（可选）", name = "channel")
    private String channel;

    /**
     * 用于防止 api 调用端重试造成服务端的重复推送而定义的一个标识符（可选）
     */
    private String cid;

    private String save;

    /**
     * 返回内容
     */
    @ApiModelProperty(value = "返回内容", name = "msg")
    private String msg;

    /**
     *
     */
    public RspHead() {
        super();
    }

    public RspHead(String rspcode, String error, String channel, String cid, String save) {
        this.rspcode = rspcode;
        this.error = error;
        this.channel = channel;
        this.cid = cid;
        this.save = save;
    }

    public RspHead(String rspcode, String error, String channel, String cid, String save, String msg) {
        this.rspcode = rspcode;
        this.error = error;
        this.channel = channel;
        this.cid = cid;
        this.save = save;
        this.msg = msg;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the rspcode
     */
    public String getRspcode() {
        return rspcode;
    }

    /**
     * @param rspcode the rspcode to set
     */
    public void setRspcode(String rspcode) {
        this.rspcode = rspcode;
    }

    /**
     * @return the erroe
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the erroe to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the save
     */
    public String getSave() {
        return save;
    }

    /**
     * @param save the save to set
     */
    public void setSave(String save) {
        this.save = save;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RspHead [rspcode=" + rspcode + ", error=" + error + ", channel=" + channel + ", cid=" + cid + ", save="
                + save + ", msg=" + msg + "]";
    }

}
