package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingUser;
import com.ybing.authentication.enums.YbingUserStatusEnum;
import com.ybing.authentication.mapper.YbingUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * Created by niko on 2019/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YbingUserRepositoryTest {

    @Autowired
    private YbingUserMapper ybingUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        YbingUser user = new YbingUser();
        user.setEmail("12345s@ybing.com");
        user.setName("ybing");
        user.setPassword(passwordEncoder.encode("qrafzv!24"));
        user.setFirstName("niko");
        user.setLastName("huang");
        user.setPhoneNo("13838387438");
        user.setStatus(YbingUserStatusEnum.APPROVED.getCode());
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setCreator("system");
        user.setUpdateBy("system");
        ybingUserMapper.insertUseGeneratedKeys(user);
        user = ybingUserMapper.selectByPrimaryKey(2);
        System.out.println("user name : "+ user.getName());
    }


    @Test
    public void pwdTest() {
        String pwd = "qrafzv!24";
        String pwdEncode = passwordEncoder.encode(pwd);
        System.out.println("-------test passwordEncode------"+passwordEncoder.matches(pwd, pwdEncode));
        System.out.println("-------test passwordEncode------"+pwdEncode);
    }
}
