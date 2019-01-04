package org.jeecgframework.core.common.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

/**
 * 功能描述：ID实体类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 22:36
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@MappedSuperclass
@ApiModel
public abstract class BaseIDEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", name = "id", required = true, example = "1232der234wff32f")
    private String id;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
