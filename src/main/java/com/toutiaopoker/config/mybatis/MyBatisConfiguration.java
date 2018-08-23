package com.toutiaopoker.config.mybatis;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageHelper;

/**
 * 注册MyBatis分页插件PageHelper
 *
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Configuration
public class MyBatisConfiguration {
    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "false");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}