package com.ybing.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.ybing.blog.feign"})
@MapperScan("com.ybing.blog.mapper")
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder templateBuilder) {
		List<HttpMessageConverter<?>> converters = templateBuilder.build().getMessageConverters();
		for(HttpMessageConverter<?> converter : converters){
			if(converter instanceof MappingJackson2HttpMessageConverter){
				List<MediaType> mediaTypeList = new ArrayList<>(converter.getSupportedMediaTypes());
				mediaTypeList.add(MediaType.TEXT_HTML);
				mediaTypeList.add(MediaType.APPLICATION_OCTET_STREAM);
				mediaTypeList.add(MediaType.APPLICATION_FORM_URLENCODED);
				((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypeList);
			}
		}
		return templateBuilder.build();
	}
}
