package com.ybing.authentication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by niko on 2019/5/23.
 */
@Configuration
public class YbingWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
