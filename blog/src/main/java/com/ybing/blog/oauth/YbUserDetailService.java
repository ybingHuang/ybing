package com.ybing.blog.oauth;

import com.ybing.blog.dto.YbAuthLoginDTO;
import com.ybing.blog.dto.YbLoginDTO;
import com.ybing.blog.feign.YbAuthFeignClient;
import com.ybing.common.YbRedisConst;
import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by niko on 2019/5/30.
 */
@Service
public class YbUserDetailService implements UserDetailsService {

    @Autowired
    private YbAuthFeignClient ybAuthFeignClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String clientId;

    private final static String SCOPE = "read";

    private final static String GRANT_TYPE = "password";

    private final String AUTH_SERVER_ID = "AUTHENTICATION";

    private final String TOKEN_URL = "/ybing/auth/oauth/token";

    public ResponseEntity<OAuth2AccessToken> doLogin(YbLoginDTO loginDTO) {
        YbAuthLoginDTO authLoginDTO = new YbAuthLoginDTO();
        authLoginDTO.setUsername(loginDTO.getUsername());
        authLoginDTO.setPassword(loginDTO.getPassword());
        authLoginDTO.setClient_id(clientId);
        authLoginDTO.setClient_secret("qrafzv!24");
        authLoginDTO.setGrant_type(GRANT_TYPE);
        authLoginDTO.setScope(SCOPE);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add("username", loginDTO.getUsername());
        body.add("password", loginDTO.getPassword());
        body.add("client_id", clientId);
        body.add("client_secret", "qrafzv!24");
        body.add("grant_type", GRANT_TYPE);
        body.add("scope", SCOPE);

        HttpEntity entity = new HttpEntity(body, headers);

        ResponseEntity<OAuth2AccessToken> response = restTemplate.exchange("http://" + AUTH_SERVER_ID + TOKEN_URL, HttpMethod.POST, entity, OAuth2AccessToken.class);


        //ResponseEntity<OAuth2AccessToken> response = ybAuthFeignClient.accessToken(authLoginDTO);
        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String redisKey = YbRedisConst.LOGIN_USER_PREFIX + username;
        //if(redisTemplate.getHashValueSerial)
        ResponseEntity<YbUserDetailDTO> response = ybAuthFeignClient.getUserByName(username);
        YbUserDetailDTO userDetailDTO = response.getBody();
        if(userDetailDTO == null) {
            return null;
        }
        return userDetailDTO;
    }
}
