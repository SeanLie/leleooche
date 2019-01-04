package com.leletc.base.api.request;

import java.io.Serializable;

/**
 * 功能描述：短信请求类
 * <p>
 *
 * @author 朱磊
 * <p>
 * @date 2018/11/14 19:42
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class SMSReq implements Serializable {

    // 一点通帐号
    private String zh;
    // 一点通密码
    private String mm;

    // 手机号码，post发送5000一个包，用英文状态下的逗号分隔。一次提交最多5000个手机号
    private String hm;

    // 短信内容
    private String nr;

    // 短信类别ID。发送短信的类别
    private String dxlbid;

    // 扩展码，可空。
    private String extno;

    /**
     * @return the zh
     */
    public String getZh() {
        return zh;
    }

    /**
     * @param zh the zh to set
     */
    public void setZh(String zh) {
        this.zh = zh;
    }

    /**
     * @return the mm
     */
    public String getMm() {
        return mm;
    }

    /**
     * @param mm the mm to set
     */
    public void setMm(String mm) {
        this.mm = mm;
    }

    /**
     * @return the hm
     */
    public String getHm() {
        return hm;
    }

    /**
     * @param hm the hm to set
     */
    public void setHm(String hm) {
        this.hm = hm;
    }

    /**
     * @return the nr
     */
    public String getNr() {
        return nr;
    }

    /**
     * @param nr the nr to set
     */
    public void setNr(String nr) {
        this.nr = nr;
    }

    /**
     * @return the dxlbid
     */
    public String getDxlbid() {
        return dxlbid;
    }

    /**
     * @param dxlbid the dxlbid to set
     */
    public void setDxlbid(String dxlbid) {
        this.dxlbid = dxlbid;
    }

    /**
     * @return the extno
     */
    public String getExtno() {
        return extno;
    }

    /**
     * @param extno the extno to set
     */
    public void setExtno(String extno) {
        this.extno = extno;
    }

    /**
     * @param zh
     * @param mm
     * @param hm
     * @param nr
     * @param dxlbid
     * @param extno
     */
    public SMSReq(String zh, String mm, String hm, String nr, String dxlbid, String extno) {
        super();
        this.zh = zh;
        this.mm = mm;
        this.hm = hm;
        this.nr = nr;
        this.dxlbid = dxlbid;
        this.extno = extno;
    }

    /**
     *
     */
    public SMSReq() {
        super();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SMSReq [zh=" + zh + ", mm=" + mm + ", hm=" + hm + ", nr=" + nr + ", dxlbid=" + dxlbid + ", extno="
                + extno + "]";
    }

}
