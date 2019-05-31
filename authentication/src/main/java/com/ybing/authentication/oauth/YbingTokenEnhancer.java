package com.ybing.authentication.oauth;

import com.ybing.authentication.struct.YbingUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by niko on 2019/5/16.
 */
public class YbingTokenEnhancer implements TokenEnhancer {

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if(authentication == null || authentication.getPrincipal() == null) {
            return accessToken;
        }
        YbingUserDetailDTO userDetail = (YbingUserDetailDTO)authentication.getPrincipal();
        Map<String, Object> prop = new HashMap();
        prop.put("firstName", userDetail.getFirstName());
        prop.put("lastName", userDetail.getLastName());
        prop.put("email", userDetail.getEmail());
        prop.put("phone", userDetail.getPhoneNo());
        if(userDetail.getAuthorities() != null) {
            prop.put("role", userDetail.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.joining(",")));
        }
        prop.put("id", userDetail.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(prop);
        return jwtAccessTokenConverter.enhance(accessToken, authentication);
    }
}
