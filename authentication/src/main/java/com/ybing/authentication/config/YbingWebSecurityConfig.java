package com.ybing.authentication.config;

import com.ybing.authentication.oauth.YbingAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * Created by niko on 2019/5/17.
 */
@Configuration
public class YbingWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private YbingAuthenticationProvider ybingAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/resources/**");
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/ybing/auth/login").permitAll()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/ybing/auth/js/**").permitAll()
                .antMatchers("/ybing/auth/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncryptor() {
        return new BCryptPasswordEncoder();
    }
}
