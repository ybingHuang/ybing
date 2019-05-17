package com.ybing.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by niko on 2019/5/16.
 */
@Configuration
public class YbingAuthorizationTokenConfig {

    @Bean
    public JwtTokenStore jwtTokenStore() {
        JwtTokenStore jwtTokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("$24wrsfxv#xvsfwr!");
        return jwtAccessTokenConverter;
    }

    @Bean(name = "ybingTokenEnhancer")
    public YbingTokenEnhancer tokenEnhancer() {
        return new YbingTokenEnhancer();
    }

}
