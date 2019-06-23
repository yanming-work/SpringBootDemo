/*
 * Copyright (C) 2019 BlueMiaomiao
 * FastDFS Java Client(for SpringBoot1.x & SpringBoot 2.x) may be copied only under the terms of the GNU Lesser
 * General Public License (LGPL).
 */

package demo.yanming.springboot.starter.fastdfs.annotation;

import demo.yanming.springboot.starter.fastdfs.autoconfiguration.FastdfsAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(FastdfsAutoConfiguration.class)
@Documented
public @interface EnableFastdfsClient {
}
