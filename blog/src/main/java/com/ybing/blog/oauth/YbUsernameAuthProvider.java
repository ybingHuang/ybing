package com.ybing.blog.oauth;

import com.alibaba.fastjson.JSON;
import com.ybing.blog.dto.YbLoginDTO;
import com.ybing.blog.exception.YbAuthenticationException;
import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collections;

/**
 * Created by niko on 2019/5/30.
 */
public class YbUsernameAuthProvider implements AuthenticationProvider {

    @Autowired
    private YbUserDetailService ybUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        YbLoginDTO loginDTO = (YbLoginDTO) authentication.getPrincipal();
        ResponseEntity<OAuth2AccessToken> response = ybUserDetailService.doLogin(loginDTO);
        if(response.getStatusCode().value() != HttpStatus.OK.value()) {
            throw new YbAuthenticationException(JSON.toJSONString(response.getBody()));
        }

        return new UsernamePasswordAuthenticationToken(response.getBody(), null, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
