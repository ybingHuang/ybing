package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingUser;
import com.ybing.authentication.enums.YbingUserStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by niko on 2019/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YbingUserRepositoryTest {

    @Autowired
    private YbingUserRepository ybingUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {

    }
}
