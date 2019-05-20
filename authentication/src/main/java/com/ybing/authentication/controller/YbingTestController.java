package com.ybing.authentication.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by niko on 2019/5/17.
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class YbingTestController {
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private YbingUserRepository ybingUserRepository;
//
//    @Autowired
//    private YbingRoleRepository ybingRoleRepository;
//
//    @Autowired
//    private YbingClientDetailRepository ybingClientDetailRepository;

    @PostMapping
    public void save() {
//        log.info("create user info...");
//        YbingUser user = new YbingUser();
//        user.setEmail("12345s@ybing.com");
//        user.setName("ybing");
//        user.setPassword(passwordEncoder.encode("qrafzv!24"));
//        user.setFirstName("niko");
//        user.setLastName("huang");
//        user.setPhoneNo("13838387438");
//        user.setStatus(YbingUserStatusEnum.APPROVED.getCode());
//        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        user.setCreator("system");
//        user.setUpdateBy("system");
//        ybingUserRepository.save(user);
//
//        YbingRole role = new YbingRole();
//        role.setName("root");
//        role.setDescription("super admin");
//        role.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        role.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        role.setCreator("system");
//        role.setUpdateBy("system");
//        ybingRoleRepository.save(role);
//
//        YbingClientDetail clientDetail = new YbingClientDetail();
//        clientDetail.setCode("123456");
//        clientDetail.setClientSecret(passwordEncoder.encode("asdfg"));
//        clientDetail.setAuthorities("root");
//        clientDetail.setScope("read");
//        clientDetail.setAuthorizedGrantType("password");
//        clientDetail.setStatus(1);
//        clientDetail.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        clientDetail.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        clientDetail.setUpdateBy("system");
//        clientDetail.setCreator("system");
//        ybingClientDetailRepository.save(clientDetail);

    }
}
