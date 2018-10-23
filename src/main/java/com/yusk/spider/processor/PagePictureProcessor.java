/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.processor;

import com.yusk.spider.common.cache.CacheMap;
import com.yusk.spider.common.constant.Constant;
import com.yusk.spider.common.utils.FileTypeUtil;
import com.yusk.spider.common.utils.ZipUtils;
import com.yusk.spider.entity.DomainImgConfig;
import com.yusk.spider.mapper.DomainImgConfigMapper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 14:21
 */
public class PagePictureProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public static InputStream inStream = null;

    private String path;

    private Boolean sync;

    private DomainImgConfigMapper domainImgConfigMapper;

    public PagePictureProcessor(String path, Boolean sync, DomainImgConfigMapper domainImgConfigMapper) {
        this.path = path;
        this.sync = sync;
        this.domainImgConfigMapper = domainImgConfigMapper;
    }

    @Override
    public void process(Page page) {

        String urlPath = page.getUrl().get();

        DomainImgConfig domainImgConfig = new DomainImgConfig();
        domainImgConfig.setDomain("test");
        domainImgConfigMapper.selectOne(domainImgConfig);

        List<String> pics = page.getHtml().$("img").all();

        ///遍历links集合中的链接，然后下载
        for (int i = 0; i < pics.size(); i++) {
            String link = pics.get(i);

            Document doc = Jsoup.parse(link);

            String src = doc.getElementsByTag("img").attr("src");

            try {
                URL url = new URL(formateSrcUrl(src));
                URLConnection con = url.openConnection();
                inStream = con.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len;
                while ((len = inStream.read(buf)) != -1) {
                    outStream.write(buf, 0, len);
                }
                inStream.close();
                outStream.close();
                //图片下载地址

                File file = new File(Constant.PATH + path + "//" + i + src.substring(src.lastIndexOf(".")));

                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                FileOutputStream op = new FileOutputStream(file);
                op.write(outStream.toByteArray());
                op.close();
                String fileType = FileTypeUtil.getFileType(file);

                String name = file.getName();

                if (!name.endsWith(fileType)) {
                    file.renameTo(new File(Constant.PATH + path + "//" + i + "." + fileType));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (sync) {
            CacheMap.setKey(path, new Date());
        }

        if (!sync) {
            String strZipName = Constant.PATH + path + ".zip";
            File fileDir = new File(Constant.PATH + path);

            File[] files = fileDir.listFiles();

            List<File> listFile = Arrays.asList(files);

            File zipFile = new File(strZipName);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
                ZipUtils.getZip(fileOutputStream, listFile);
            } catch (Exception e) {
            } finally {
                CacheMap.setKey(path, new Date());
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    private String formateSrcUrl(String src) {

        String substring = src.substring(0, 2);

        if (substring.contains("//")) {
            return "http://" + src.substring(src.lastIndexOf("//") + 2);
        } else if (substring.contains("/")) {
            return "http:/" + src;
        } else if (substring.equals("ht")) {
            return src;
        } else {
            return "http://" + src;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
