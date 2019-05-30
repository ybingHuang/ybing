package com.ybing.blog.oauth;

import com.ybing.blog.feign.YbAuthFeignClient;
import com.ybing.common.YbRedisConst;
import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
