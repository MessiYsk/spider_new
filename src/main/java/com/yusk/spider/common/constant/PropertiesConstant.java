/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-23 10:14
 */
@Component
public class PropertiesConstant {

    @Value("${properties.path.file}")
    public String PATH;
    @Value("${properties.path.selenium}")
    public String PATH_SELENIUM;
    @Value("${properties.driver_name}")
    public String DRIVER_NAME;
}
