package com.ybing.blog.feign;

import com.ybing.blog.dto.YbAuthLoginDTO;
import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by niko on 2019/5/30.
 */
@FeignClient("authentication")
public interface YbAuthFeignClient {

    String BASE_URL = "/ybing/auth";

    @GetMapping(BASE_URL + "/user/{name}")
    ResponseEntity<YbUserDetailDTO> getUserByName(@PathVariable("name") String username);

    @PostMapping(value = BASE_URL + "/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<OAuth2AccessToken> accessToken(@RequestBody YbAuthLoginDTO authLoginDTO);
}
