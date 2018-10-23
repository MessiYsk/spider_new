/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.common.cache;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 记录map
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-23 10:31
 */
public class CacheMap {

    private final static Map<String, Date> concurrentHashMap = new ConcurrentHashMap();

    public static void setKey(String key, Date date) {
        concurrentHashMap.put(key, date);
    }

    public static Date getKey(String key) {
        return concurrentHashMap.get(key);
    }

    public static void removeKey(String key) {
        concurrentHashMap.remove(key);
    }
}
