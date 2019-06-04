package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingClientDetail;
import com.ybing.authentication.mapper.YbingClientDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YbingClientDetailMapperTest {
    @Autowired
    private YbingClientDetailMapper ybingClientDetailMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addClient() {
//        YbingClientDetail client = new YbingClientDetail();
//        client.setCode("test-client");
//        client.setStatus(1);
//        client.setClientSecret(passwordEncoder.encode("test"));
//        client.setAuthorities("test");
//        client.setAuthorizedGrantType("password");
//        client.setScope("read");
//        client.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        client.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        client.setCreator("system");
//        client.setUpdateBy("system");
//        ybingClientDetailMapper.insertUseGeneratedKeys(client);
    }
}
