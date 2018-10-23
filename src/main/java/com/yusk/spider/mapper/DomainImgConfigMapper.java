/*
 * Copyright (c) 2001-2018 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.yusk.spider.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yusk.spider.entity.DomainImgConfig;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author yusk
 * @version V1.0
 * @since 2018-10-23 17:51
 */
@Mapper
@Repository
public interface DomainImgConfigMapper extends BaseMapper<DomainImgConfig> {
}
