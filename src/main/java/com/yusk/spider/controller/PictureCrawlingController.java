/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.controller;

import com.yusk.spider.common.constant.Constant;
import com.yusk.spider.common.utils.ZipUtils;
import com.yusk.spider.manager.PictureCrawlingManage;

import java.io.File;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 16:34
 */
@Controller
@RequestMapping("picturecrawling")
public class PictureCrawlingController {

    @Autowired
    private PictureCrawlingManage pictureCrawlingManage;

    @GetMapping("getallpicturessync")
    public void getAllPicturesSync(String urls, HttpServletResponse response) {

        String picturePath = pictureCrawlingManage.getPictures(urls, true);

        String strZipName = picturePath + ".zip";
        // 定义输出类型
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=" + strZipName);
        OutputStream out = null;
        File fileDir = new File(Constant.PATH + picturePath);

        File[] files = fileDir.listFiles();

        List<File> listFile = Arrays.asList(files);

        try {
            ZipUtils.getZip(response.getOutputStream(), listFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("getallpicturesasync")
    @ResponseBody
    public String getAllPicturesAsync(String urls) {

        String picturePath = pictureCrawlingManage.getPictures(urls, false);
        return picturePath;
    }

    @GetMapping("test")
    @ResponseBody
    public String test(String urls) {

        String picturePath = pictureCrawlingManage.getPictures(urls, true);
        return picturePath;
    }

    @GetMapping
    @ResponseBody
    public void downloadPic(String pic) {
    }
}
