package com.hwdee.springbootjsp.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration  //表示该类是用来做配置的
public class PageHelperConfig {
    @Bean  //表示将PageHelper 注入到容器中
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum","true"); //offsetAsPageNum设置为true时会将RowBound第一个参数的offset当成pageNum使用
        p.setProperty("rowBoundsWithCount","true"); //rowBoundsWithCount 设置为true时，使用RowBounds分页会进行count查询
        p.setProperty("reasonable","true"); // reasonable：启动合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
