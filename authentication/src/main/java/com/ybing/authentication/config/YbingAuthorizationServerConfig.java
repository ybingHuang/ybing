package com.ybing.authentication.config;

import com.ybing.authentication.oauth.YbingAuthenticationProvider;
import com.ybing.authentication.oauth.YbingClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by niko on 2019/5/15.
 */
@Configuration
@EnableAuthorizationServer
public class YbingAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager ybingAuthenticationProvider;

    @Autowired
    private YbingTokenEnhancer ybingTokenEnhancer;

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private YbingClientDetailService ybingClientDetailService;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(ybingClientDetailService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain chain = new TokenEnhancerChain();
        List<TokenEnhancer> list = new ArrayList();
        list.add(ybingTokenEnhancer);
        chain.setTokenEnhancers(list);

        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(endpoints.getTokenStore());
        defaultTokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        defaultTokenServices.setReuseRefreshToken(true);
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        defaultTokenServices.setAccessTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1));

        endpoints.tokenStore(jwtTokenStore)
                .tokenEnhancer(chain)
                .authenticationManager(ybingAuthenticationProvider)
                .accessTokenConverter(jwtAccessTokenConverter)
               // .userDetailsService()
                .tokenServices(defaultTokenServices)
                .setClientDetailsService(ybingClientDetailService);

    }

    @Bean(name = "ybingAuthenticationProvider")
    public AuthenticationManager authenticationManager() {
        return new YbingAuthenticationProvider();
    }
}
