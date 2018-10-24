/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 14:17
 */
public class Main {

    public static void main(String[] args) {

        String urlPath = "http://www.baidu.com/pic";

        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 获取主机名
        String host = url.getHost();

        String substring = host.substring(host.indexOf(".") + 1);

        System.out.println(substring);

        System.out.println(host);

    }

    private static String formateSrcUrl(String src) {

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

}
