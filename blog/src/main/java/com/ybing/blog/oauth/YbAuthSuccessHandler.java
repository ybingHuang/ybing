package com.ybing.blog.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by niko on 2019/5/30.
 */
public class YbAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AccessToken token = (OAuth2AccessToken)authentication.getPrincipal();
        response.setHeader("authToken", token.getValue());
        response.setHeader("refreshToken", token.getRefreshToken().getValue());
    }
}
