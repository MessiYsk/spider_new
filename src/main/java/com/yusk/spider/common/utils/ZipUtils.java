/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-22 16:26
 */
public class ZipUtils {

    public static void getZip(OutputStream outputStream, List<File> listFile) throws Exception {

        FileInputStream fis = null;
        ZipOutputStream outzip = new ZipOutputStream(outputStream);
        int size = listFile.size();

        for (int j = 0; j < size; j++) {
            File file = listFile.get(j);
            if (file.isDirectory()) {
                file.delete();
                continue;
            }
            fis = new FileInputStream(file);
            outzip.putNextEntry(new ZipEntry(file.getName()));
            int len;
            while ((len = fis.read()) != -1) {
                outzip.write(len);
                outzip.flush();
            }
            fis.close();
        }
        outzip.close();
    }
}
