package com.ybing.blog.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by niko on 2019/5/30.
 */
@Configuration
public class YbFeignClientConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(Objects.isNull(requestAttrs)) {
            return ;
        }
        HttpServletRequest request = requestAttrs.getRequest();
        String auth = request.getHeader("Authorization");
        if(StringUtils.isNotEmpty(auth)) {
            requestTemplate.header("Authorization", auth);
        }
    }
}
