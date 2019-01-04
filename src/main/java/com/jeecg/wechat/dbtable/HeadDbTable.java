package com.jeecg.wechat.dbtable;

import org.jeecgframework.core.common.entity.BaseIDEntity;

import java.util.Date;

/**
 * 数据库对象
 *
 * @author 朱磊
 * @date 2018/09/10
 */
public class HeadDbTable extends BaseIDEntity {

    /**
     * 创建者姓名
     */
    private String create_name;

    /**
     * 创建者登录名称
     */
    private String create_by;

    /**
     * 创建日期
     */
    private Date create_date;

    /**
     * 更新人名称
     */
    private String update_name;

    /**
     * 更新人登陆名称
     */
    private String update_by;

    /**
     * 创建日期
     */
    private Date update_date;

    /**
     *
     */
    public HeadDbTable() {
        super();
    }

    /**
     * @param create_name
     * @param create_by
     * @param create_date
     * @param update_name
     * @param update_by
     * @param update_date
     */
    public HeadDbTable(String create_name, String create_by, Date create_date, String update_name, String update_by,
                       Date update_date) {
        super();
        this.create_name = create_name;
        this.create_by = create_by;
        this.create_date = create_date;
        this.update_name = update_name;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    /**
     * @return the create_name
     */
    public String getCreate_name() {
        return create_name;
    }

    /**
     * @param create_name the create_name to set
     */
    public void setCreate_name(String create_name) {
        this.create_name = create_name;
    }

    /**
     * @return the create_by
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * @param create_by the create_by to set
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    /**
     * @return the create_date
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * @param create_date the create_date to set
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * @return the update_name
     */
    public String getUpdate_name() {
        return update_name;
    }

    /**
     * @param update_name the update_name to set
     */
    public void setUpdate_name(String update_name) {
        this.update_name = update_name;
    }

    /**
     * @return the update_by
     */
    public String getUpdate_by() {
        return update_by;
    }

    /**
     * @param update_by the update_by to set
     */
    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    /**
     * @return the update_date
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * @param update_date the update_date to set
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HeadDbTable [create_name=" + create_name + ", create_by=" + create_by + ", create_date=" + create_date
                + ", update_name=" + update_name + ", update_by=" + update_by + ", update_date=" + update_date + "]";
    }

}
