package com.ybing.blog.oauth;

import com.ybing.blog.dto.YbAuthLoginDTO;
import com.ybing.blog.dto.YbLoginDTO;
import com.ybing.blog.feign.YbAuthFeignClient;
import com.ybing.common.YbRedisConst;
import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

/**
 * Created by niko on 2019/5/30.
 */
@Service
public class YbUserDetailService implements UserDetailsService {

    @Autowired
    private YbAuthFeignClient ybAuthFeignClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.application.name}")
    private String clientId;

    private final static String SCOPE = "all";

    private final static String GRANT_TYPE = "password";

    public ResponseEntity<OAuth2AccessToken> doLogin(YbLoginDTO loginDTO) {
        YbAuthLoginDTO authLoginDTO = new YbAuthLoginDTO();
        authLoginDTO.setUsername(loginDTO.getUsername());
        authLoginDTO.setPassword(loginDTO.getPassword());
        authLoginDTO.setClient_id(clientId);
        authLoginDTO.setClient_secret("qrafzv!24");
        authLoginDTO.setGrant_type(GRANT_TYPE);
        authLoginDTO.setScope(SCOPE);
        ResponseEntity<OAuth2AccessToken> response = ybAuthFeignClient.accessToken(authLoginDTO);
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
