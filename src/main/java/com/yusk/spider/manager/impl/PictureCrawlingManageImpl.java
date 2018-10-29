/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.manager.impl;

import com.yusk.spider.common.constant.PropertiesConstant;
import com.yusk.spider.manager.PictureCrawlingManage;
import com.yusk.spider.mapper.DomainImgConfigMapper;
import com.yusk.spider.processor.PagePictureProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;

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

    @Autowired
    private PropertiesConstant propertiesConstant;

    @Override
    public String getPictures(String urls, Boolean sync) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = dateFormat.format(new Date());
        Random random = new Random();
        format += random.nextInt(1000);

        String[] strings = urls.split(";");

        System.setProperty("selenuim_config", propertiesConstant.PATH_SELENIUM + "config.ini");

        SeleniumDownloader seleniumDownloader = new SeleniumDownloader(
            propertiesConstant.PATH_SELENIUM + propertiesConstant.DRIVER_NAME);
        Spider.create(new PagePictureProcessor(format, sync, domainImgConfigMapper, propertiesConstant)).addUrl(strings)
            .thread(1).setDownloader(seleniumDownloader).run();
        if (sync) {
            return format;
        } else {
            return format;
        }
    }
}
