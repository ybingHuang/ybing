package com.ybing.authentication.oauth;

import com.ybing.authentication.service.YbingUserDetailService;
import com.ybing.authentication.struct.YbingUserDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Objects;

/**
 * Created by niko on 2019/5/16.
 */
@Slf4j
public class YbingAuthenticationProvider implements AuthenticationManager {

    private YbingUserDetailService userDetailService;

    public YbingAuthenticationProvider(YbingUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        YbingUserDetailDTO userDetailDTO = userDetailService.loadUser((String) token.getPrincipal(), (String) token.getCredentials());
        if (!Objects.isNull(userDetailDTO)) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetailDTO, null, userDetailDTO.getAuthorities());
            return auth;
        }
        return null;
    }
}
