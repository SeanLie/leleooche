package com.leletc.smartcabinet.entity;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 智能框箱门基础信息表
 *
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 智能柜门设置
 * @date 2018-09-06 10:53:41
 */
@Entity
@Table(name = "auto_smart_cabinet_door")
public class SmartCabinetDoorEntity extends BaseIDEntity {

    /**
     * 智能柜ID
     */
    private java.lang.String cabinetId;
    /**
     * 箱门行号
     */
    @Excel(name = "箱门行号", width = 15)
    private java.lang.Integer rowNo;
    /**
     * 箱门列号
     */
    @Excel(name = "箱门列号", width = 15)
    private java.lang.Integer columnNo;
    /**
     * 箱门编号
     */
    @Excel(name = "箱门编号", width = 32)
    private java.lang.String boxNo;
    /**
     * 箱门有效状态(0:无效，1:有效)
     */
    @Excel(name = "箱门是否有效", width = 15)
    private java.lang.Integer isValid;
    /**
     * 箱门开关状态(0:关，1:开)
     */
    @Excel(name = "箱门开关状态", width = 15)
    private java.lang.Integer isOpen;
    /**
     * 箱门是否占用(0:空闲，1:占用)
     */
    @Excel(name = "箱门是否占用", width = 15)
    private java.lang.Integer isOccupancy;
    /**
     * 储物状态(0:空闲，1:已存物，2:已取物)
     */
    @Excel(name = "储物状态", width = 15)
    private java.lang.Integer storageStatus;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜ID
     */

    @Column(name = "CABINET_ID", length = 36)
    public java.lang.String getCabinetId() {
        return this.cabinetId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜ID
     */
    public void setCabinetId(java.lang.String cabinetId) {
        this.cabinetId = cabinetId;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  箱门行号
     */

    @Column(name = "ROW_NO", nullable = true, length = 2)
    public java.lang.Integer getRowNo() {
        return this.rowNo;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  箱门行号
     */
    public void setRowNo(java.lang.Integer rowNo) {
        this.rowNo = rowNo;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  箱门列号
     */
    @Column(name = "COLUMN_NO", nullable = true, length = 2)
    public java.lang.Integer getColumnNo() {
        return this.columnNo;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  箱门列号
     */
    public void setColumnNo(java.lang.Integer columnNo) {
        this.columnNo = columnNo;
    }

    @Column(name = "BOX_NO", length = 32)
    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  箱门有效状态
     */

    @Column(name = "IS_VALID", length = 4)
    public java.lang.Integer getIsValid() {
        return this.isValid;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  箱门有效状态
     */
    public void setIsValid(java.lang.Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  箱门开关状态
     */

    @Column(name = "IS_OPEN", length = 4)
    public java.lang.Integer getIsOpen() {
        return this.isOpen;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  箱门开关状态
     */
    public void setIsOpen(java.lang.Integer isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  箱门空闲状态
     */

    @Column(name = "IS_OCCUPANCY", length = 4)
    public java.lang.Integer getIsOccupancy() {
        return this.isOccupancy;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  箱门空闲状态
     */
    public void setIsOccupancy(java.lang.Integer isOccupancy) {
        this.isOccupancy = isOccupancy;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  储物状态
     */

    @Column(name = "STORAGE_STATUS", nullable = true, length = 4)
    public java.lang.Integer getStorageStatus() {
        return this.storageStatus;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  储物状态
     */
    public void setStorageStatus(java.lang.Integer storageStatus) {
        this.storageStatus = storageStatus;
    }

}
