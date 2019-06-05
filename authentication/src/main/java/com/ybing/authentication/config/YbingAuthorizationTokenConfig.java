package com.ybing.authentication.config;

import com.ybing.authentication.oauth.YbingTokenEnhancer;
import com.ybing.authentication.service.YbingUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by niko on 2019/5/16.
 */
@Configuration
@AutoConfigureAfter(YbingAuthorizationServerConfig.class)
@Slf4j
public class YbingAuthorizationTokenConfig {

    @Autowired
    private YbingUserDetailService ybingUserDetailService;

    public YbingAuthorizationTokenConfig() {
        log.info("load ybing auth token config");
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        JwtTokenStore jwtTokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        return jwtTokenStore;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("$24wrsfxv#xvsfwr!");
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
        userAuthenticationConverter.setUserDetailsService(ybingUserDetailService);
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        jwtAccessTokenConverter.setAccessTokenConverter(accessTokenConverter);
        return jwtAccessTokenConverter;
    }

    @Bean(name = "ybingTokenEnhancer")
    public YbingTokenEnhancer tokenEnhancer() {
        return new YbingTokenEnhancer();
    }

}
