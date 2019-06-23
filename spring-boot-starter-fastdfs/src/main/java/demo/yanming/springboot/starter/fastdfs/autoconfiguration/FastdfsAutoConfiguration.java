/*
 * Copyright (C) 2019 BlueMiaomiao
 * FastDFS Java Client(for SpringBoot1.x & SpringBoot 2.x) may be copied only under the terms of the GNU Lesser
 * General Public License (LGPL).
 */

package demo.yanming.springboot.starter.fastdfs.autoconfiguration;

import demo.yanming.springboot.starter.fastdfs.properties.FastdfsProperties;
import demo.yanming.springboot.starter.fastdfs.service.FastdfsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FastdfsProperties.class)
public class FastdfsAutoConfiguration {
    @Autowired
    private FastdfsProperties fastdfsProperties;

    @Bean
    @ConditionalOnMissingBean(FastdfsClientService.class)
    public FastdfsClientService fastdfsClientService() throws Exception {
        return new FastdfsClientService(fastdfsProperties);
    }
}