/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.manager;

/**
 * 图片
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 14:02
 */
public interface PictureCrawlingManage {

    String getPictures(String urls, Boolean sync);
}
