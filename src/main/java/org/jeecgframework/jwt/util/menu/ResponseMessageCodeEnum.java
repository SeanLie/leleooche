package org.jeecgframework.jwt.util.menu;

/**
 * 功能描述：接口返回状态码
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/08 08:30
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/26, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public enum ResponseMessageCodeEnum {

    /*
     * 0=返回数据成功，操作成功
     */
    SUCCESS("0"),
    /*
     * -1=系统异常，操作失败
     */
    ERROR("-1"),
    /*
     * 1000=校验不正确，比如输入、格式、要填写的没有填写等
     */
    VALID_ERROR("1000"), // 校验失败
    /*
     * 2000=未返回数据，数据为空，找不到数据（包含查询查不到，某个业务操作时查不到）
     */
    NULL_ERROR("2000"),
    /*
     * 3000=不允许的业务操作
     */
    DO_NOT_ERROR("3000"),

    SAVE_SUCCESS("r0001"),
    UPDATE_SUCCESS("r0002"),
    REMOVE_SUCCESS("r0003");

    private String code;

    ResponseMessageCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
