package com.ybing.blog.oauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybing.blog.dto.YbLoginDTO;
import com.ybing.blog.exception.YbAuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by niko on 2019/5/30.
 */
public class YbAuthFilter extends AbstractAuthenticationProcessingFilter {

    public final static String PROCESSES_URL = "/ybing/blog/login";

    private ObjectMapper objectMapper = new ObjectMapper();


    public YbAuthFilter(List<AuthenticationProvider> providers)  {

        super(PROCESSES_URL);

        setAuthenticationManager(new ProviderManager(providers));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        YbLoginDTO loginDTO = objectMapper.readValue(request.getInputStream(), YbLoginDTO.class);
        if(StringUtils.isEmpty(loginDTO.getPassword()) || StringUtils.isEmpty(loginDTO.getUsername())) {
            throw new YbAuthenticationException("username or password is null");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO, null);
        return getAuthenticationManager().authenticate(token);
    }
}
