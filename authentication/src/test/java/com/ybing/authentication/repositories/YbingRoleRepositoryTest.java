package com.ybing.authentication.repositories;

import com.ybing.authentication.entity.YbingRole;
import com.ybing.authentication.mapper.YbingRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by niko on 2019/5/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class YbingRoleRepositoryTest {

    @Autowired
    private YbingRoleMapper ybingRoleMapper;


    @Test
    public void save() {
//        YbingRole role = new YbingRole();
//        role.setName("test2");
//        role.setDescription("test1");
//        role.setUpdateBy("system");
//        role.setCreator("system");
//        ybingRoleMapper.insertUseGeneratedKeys(role);
//        System.out.println("new role id : " + role.getId());
    }

}
