package com.ybing.authentication.controller;

import com.ybing.authentication.service.YbingUserDetailService;
import com.ybing.authentication.struct.YbingUserDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niko on 2019/5/30.
 */
@RestController("/user")
@Slf4j
public class YbingUserController {

    @Autowired
    private YbingUserDetailService ybingUserDetailService;

    @GetMapping("/{name}")
    public ResponseEntity<YbingUserDetailDTO> getUserByName(@PathVariable("name") String username) {
        log.info("[YbingUserController|getUserByName], username: {}", username);
        YbingUserDetailDTO userDetailDTO = (YbingUserDetailDTO)ybingUserDetailService.loadUserByUsername(username);
        return ResponseEntity.ok(userDetailDTO);
    }

}
