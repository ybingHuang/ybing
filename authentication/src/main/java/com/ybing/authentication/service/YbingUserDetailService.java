package com.ybing.authentication.service;

import com.ybing.authentication.repositories.YbingRoleRepository;
import com.ybing.authentication.repositories.YbingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by niko on 2019/5/17.
 */
@Service
public class YbingUserDetailService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private YbingUserRepository ybingUserRepository;

    @Autowired
    private YbingRoleRepository ybingRoleRepository;

    public void loadUser(String username, String password) {
        
    }


}
