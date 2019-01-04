package org.jeewx.api.wxuser.user.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 微信服务号关注用户union信息
 * @date 2015-01-25 19:28:24
 */
public class Wxuser implements Serializable {

    /**
     * 用户是否订阅
     */
    private java.lang.Integer subscribe;
    /**
     * 用户的标识
     */
    private java.lang.String openid;
    /**
     * 用户的昵称
     */
    private java.lang.String nickname;
    /**
     * 性别：值为1时是男性，值为2时是女性，值为0时是未知
     */
    private java.lang.String sex;
    /**
     * 用户所在城市
     */
    private java.lang.String city;
    /**
     * 用户所在国家：国家，如中国为CN
     */
    private java.lang.String country;
    /**
     * 用户所在省份
     */
    private java.lang.String province;
    /**
     * 用户的语言zh_CN
     */
    private java.lang.String language;
    /**
     * 用户头像：用户头像，最后一个数值代表正方形头像大小 （有0、46、64、96、132数值可选，0代表640*640正方形头像）
     * ，用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private java.lang.String headimgurl;
    /**
     * 用户关注时间
     */
    private java.lang.String subscribe_time;
    /**
     * 用户粉丝唯一ID：只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private java.lang.String unionid;
    /**
     * 用户被打上的标签ID列表
     */
    private String[] tagid_list;
    /**
     * 粉丝备注
     */
    private String remark;
    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    private Integer groupid;

    /**
     * 二维码扫描场景
     */
    private Integer qr_scene;
    /**
     * 二维码扫描场景描述
     */
    private String qr_scene_str;
    /**
     * 返回用户关注数据渠道
     */
    private String subscribe_scene;

    /**
     * @return the qr_scene
     */
    public Integer getQr_scene() {
        return qr_scene;
    }

    /**
     * @param qr_scene the qr_scene to set
     */
    public void setQr_scene(Integer qr_scene) {
        this.qr_scene = qr_scene;
    }

    /**
     * @return the qr_scene_str
     */
    public String getQr_scene_str() {
        return qr_scene_str;
    }

    /**
     * @param qr_scene_str the qr_scene_str to set
     */
    public void setQr_scene_str(String qr_scene_str) {
        this.qr_scene_str = qr_scene_str;
    }

    /**
     * @return the subscribe_scene
     */
    public String getSubscribe_scene() {
        return subscribe_scene;
    }

    /**
     * @param subscribe_scene the subscribe_scene to set
     */
    public void setSubscribe_scene(String subscribe_scene) {
        this.subscribe_scene = subscribe_scene;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(String[] tagid_list) {
        this.tagid_list = tagid_list;
    }

    public java.lang.Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(java.lang.Integer subscribe) {
        this.subscribe = subscribe;
    }

    public java.lang.String getOpenid() {
        return openid;
    }

    public void setOpenid(java.lang.String openid) {
        this.openid = openid;
    }

    public java.lang.String getNickname() {
        return nickname;
    }

    public void setNickname(java.lang.String nickname) {
        this.nickname = nickname;
    }

    public java.lang.String getSex() {
        return sex;
    }

    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public java.lang.String getCountry() {
        return country;
    }

    public void setCountry(java.lang.String country) {
        this.country = country;
    }

    public java.lang.String getProvince() {
        return province;
    }

    public void setProvince(java.lang.String province) {
        this.province = province;
    }

    public java.lang.String getLanguage() {
        return language;
    }

    public void setLanguage(java.lang.String language) {
        this.language = language;
    }

    public java.lang.String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(java.lang.String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public java.lang.String getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(java.lang.String subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public java.lang.String getUnionid() {
        return unionid;
    }

    public void setUnionid(java.lang.String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     */
    public Wxuser() {
        super();
    }

    /**
     * @param subscribe
     * @param openid
     * @param nickname
     * @param sex
     * @param city
     * @param country
     * @param province
     * @param language
     * @param headimgurl
     * @param subscribe_time
     * @param unionid
     * @param tagid_list
     * @param remark
     * @param groupid
     * @param qr_scene
     * @param qr_scene_str
     * @param subscribe_scene
     */
    public Wxuser(Integer subscribe, String openid, String nickname, String sex, String city, String country,
                  String province, String language, String headimgurl, String subscribe_time, String unionid,
                  String[] tagid_list, String remark, Integer groupid, Integer qr_scene, String qr_scene_str,
                  String subscribe_scene) {
        super();
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.city = city;
        this.country = country;
        this.province = province;
        this.language = language;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
        this.unionid = unionid;
        this.tagid_list = tagid_list;
        this.remark = remark;
        this.groupid = groupid;
        this.qr_scene = qr_scene;
        this.qr_scene_str = qr_scene_str;
        this.subscribe_scene = subscribe_scene;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Wxuser [subscribe=" + subscribe + ", openid=" + openid + ", nickname=" + nickname + ", sex=" + sex
                + ", city=" + city + ", country=" + country + ", province=" + province + ", language=" + language
                + ", headimgurl=" + headimgurl + ", subscribe_time=" + subscribe_time + ", unionid=" + unionid
                + ", tagid_list=" + Arrays.toString(tagid_list) + ", remark=" + remark + ", groupid=" + groupid
                + ", qr_scene=" + qr_scene + ", qr_scene_str=" + qr_scene_str + ", subscribe_scene=" + subscribe_scene
                + "]";
    }

}
