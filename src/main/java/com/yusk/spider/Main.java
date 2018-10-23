/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 14:17
 */
public class Main {

    public static void main(String[] args) {

        String url1 = "http://www.aoya-hk.com/uploadfile/2016/1030/20161030121830120.jpg";
        String url2 = "//////////www.aoya-hk.com/uploadfile/2016/1030/20161030121830120.jpg";
        String url3 = "//www.aoya-hk.com/uploadfile/2016/1030/20161030121830120.jpg";
        String url4 = "/www.aoya-hk.com/uploadfile/2016/1030/20161030121830120.jpg";
        String url5 = "www.aoya-hk.com/uploadfile/2016/1030/20161030121830120.jpg";

        System.out.println(formateSrcUrl(url1));
        System.out.println(formateSrcUrl(url2));
        System.out.println(formateSrcUrl(url3));
        System.out.println(formateSrcUrl(url4));
        System.out.println(formateSrcUrl(url5));

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
