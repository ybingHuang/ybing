package com.ybing.blog.feign;

import com.ybing.common.oauth.YbUserDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by niko on 2019/5/30.
 */
@FeignClient("authentication")
public interface YbAuthFeignClient {

    String BASE_URL = "/ybing/auth";

    @GetMapping("/user/{name}")
    ResponseEntity<YbUserDetailDTO> getUserByName(@PathVariable("name") String username);
}
