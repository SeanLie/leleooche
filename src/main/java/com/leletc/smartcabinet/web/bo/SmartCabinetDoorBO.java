package com.leletc.smartcabinet.web.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 功能描述：智能柜箱门信息业务对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/21 16:42
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "smartCabinetDoor", description = "智能柜箱门信息业务对象")
public class SmartCabinetDoorBO {

    /**
     * 箱门ID
     */
    @ApiModelProperty(value = "ID", name = "id", required = true)
    private java.lang.String id;

    /**
     * 智能柜ID
     */
    @ApiModelProperty(value = "柜子ID", name = "cabinetId", required = true)
    private java.lang.String cabinetId;
    /**
     * 箱门行号
     */
    @ApiModelProperty(value = "箱门行号", name = "rowNo", example = "1")
    private java.lang.Integer rowNo;
    /**
     * 箱门列号
     */
    @ApiModelProperty(value = "箱门列号", name = "columnNo", example = "1")
    private java.lang.Integer columnNo;
    /**
     * 箱门编号
     */
    @ApiModelProperty(value = "箱门编号", name = "boxNo", example = "1")
    private java.lang.String boxNo;
    /**
     * 箱门有效状态(0:无效，1:有效)
     */
    @ApiModelProperty(value = "箱门是否有效(0:无效，1:有效)", name = "isValid", example = "1")
    private java.lang.Integer isValid;
    /**
     * 箱门开关状态(0:关，1:开)
     */
    @ApiModelProperty(value = "箱门开关状态(0:关，1:开)", name = "isOpen", example = "0")
    private java.lang.Integer isOpen;
    /**
     * 箱门是否占用(0:空闲，1:占用)
     */
    @ApiModelProperty(value = "箱门是否占用(0:空闲，1:占用)", name = "isOccupancy", example = "0")
    private java.lang.Integer isOccupancy;
    /**
     * 储物状态(0:空闲，1:已存物，2:已取物)
     */
    @Excel(name = "储物状态", width = 15)
    @ApiModelProperty(value = "储物状态(0:空闲，1:已存物，2:已取物)", name = "storageStatus", example = "0")
    private java.lang.Integer storageStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(String cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public Integer getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(Integer columnNo) {
        this.columnNo = columnNo;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getIsOccupancy() {
        return isOccupancy;
    }

    public void setIsOccupancy(Integer isOccupancy) {
        this.isOccupancy = isOccupancy;
    }

    public Integer getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(Integer storageStatus) {
        this.storageStatus = storageStatus;
    }

    @Override
    public String toString() {
        return "SmartCabinetDoorBO{" +
                "cabinetId='" + cabinetId + '\'' +
                ", rowNo=" + rowNo +
                ", columnNo=" + columnNo +
                ", boxNo='" + boxNo + '\'' +
                ", isValid=" + isValid +
                ", isOpen=" + isOpen +
                ", isOccupancy=" + isOccupancy +
                ", storageStatus=" + storageStatus +
                '}';
    }

}
