package demo.yanming.springboot.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Project Name:springboot_properties_demo <br/>
 * Package Name:demo.yanming.springboot.properties <br/>
 * Date:2019/1/28 20:59 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Data
@Component
public class PropertiesBean {

    @Value("${demo.yanming.springboot.author.name}")
    private String name;

    @Value("${demo.yanming.springboot.article.title}")
    private String title;

    @Value("${demo.yanming.springboot.doing}")
    private String desc;

}
