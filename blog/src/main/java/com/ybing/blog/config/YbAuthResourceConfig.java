package com.ybing.blog.config;

import com.ybing.blog.oauth.YbAuthFailureHandler;
import com.ybing.blog.oauth.YbAuthFilter;
import com.ybing.blog.oauth.YbAuthSuccessHandler;
import com.ybing.blog.oauth.YbingUsernameAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niko on 2019/5/30.
 */
@Configuration
@EnableResourceServer
public class YbAuthResourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore jwtTokenStore;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("").permitAll()
                .and()
                .csrf().disable()
                .addFilterAt(authFilter(), AbstractAuthenticationProcessingFilter.class)
                .exceptionHandling().authenticationEntryPoint(forbiddenEntryPoint())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;

    }

    @Bean
    public YbAuthFilter authFilter() {
        List<AuthenticationProvider> providers = new ArrayList<>(1);
        providers.add(ybUsernameAuthProvider());
        YbAuthFilter ybAuthFilter = new YbAuthFilter(providers);
        ybAuthFilter.setAuthenticationSuccessHandler(ybAuthSuccessHandler());
        ybAuthFilter.setAuthenticationFailureHandler(ybAuthFailureHandler());
        return ybAuthFilter;
    }

    @Bean
    public YbingUsernameAuthProvider ybUsernameAuthProvider() {
        return new YbingUsernameAuthProvider();
    }

    @Bean
    public YbAuthFailureHandler ybAuthFailureHandler() {
        return new YbAuthFailureHandler();
    }

    @Bean
    public YbAuthSuccessHandler ybAuthSuccessHandler() {
        return new YbAuthSuccessHandler();
    }

    @Bean
    public Http403ForbiddenEntryPoint forbiddenEntryPoint() {
        return  new Http403ForbiddenEntryPoint();
    }
}
