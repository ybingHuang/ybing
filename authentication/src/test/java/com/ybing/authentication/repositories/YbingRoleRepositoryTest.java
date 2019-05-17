package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * Created by niko on 2019/5/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class YbingRoleRepositoryTest {
    @Autowired
    private YbingRoleRepository ybingRoleRepository;

    @Test
    public void addRole() {

    }
}
