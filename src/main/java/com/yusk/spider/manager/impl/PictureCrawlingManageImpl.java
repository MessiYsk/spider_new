/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.manager.impl;

import com.yusk.spider.manager.PictureCrawlingManage;
import com.yusk.spider.mapper.DomainImgConfigMapper;
import com.yusk.spider.processor.PagePictureProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Spider;

/**
 * 图片
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 14:05
 */
@Service
public class PictureCrawlingManageImpl implements PictureCrawlingManage {

    @Autowired
    private DomainImgConfigMapper domainImgConfigMapper;

    @Override
    public String getPictures(String urls, Boolean sync) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = dateFormat.format(new Date());
        Random random = new Random();
        format += random.nextInt(1000);

        String[] strings = urls.split(";");

        Spider.create(new PagePictureProcessor(format, sync, domainImgConfigMapper)).addUrl(strings).thread(1).run();

        if (sync) {
            return format;
        } else {
            return format;
        }
    }
}
