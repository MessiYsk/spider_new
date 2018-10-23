/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.entity;

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

    private String imgAttr;

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

    public String getImgAttr() {
        return imgAttr;
    }

    public void setImgAttr(String imgAttr) {
        this.imgAttr = imgAttr;
    }
}
