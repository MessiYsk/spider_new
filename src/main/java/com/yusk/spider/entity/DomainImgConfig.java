/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-23 17:39
 */
@TableName("domain_img_config")
public class DomainImgConfig {

    @TableId
    private Integer id;

    private String domain;

    @TableField(value = "img_attr1")
    private String imgAttr1;

    @TableField(value = "img_attr2")
    private String imgAttr2;

    private String nodeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getImgAttr1() {
        return imgAttr1;
    }

    public void setImgAttr1(String imgAttr1) {
        this.imgAttr1 = imgAttr1;
    }

    public String getImgAttr2() {
        return imgAttr2;
    }

    public void setImgAttr2(String imgAttr2) {
        this.imgAttr2 = imgAttr2;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
